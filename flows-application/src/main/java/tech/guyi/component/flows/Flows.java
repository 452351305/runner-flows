package tech.guyi.component.flows;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.executor.EndExecutor;
import tech.guyi.component.flows.api.executor.MidExecutor;
import tech.guyi.component.flows.api.executor.StartExecutor;
import tech.guyi.component.flows.entry.ExecutorEntry;
import tech.guyi.component.flows.exception.EmptyFlowsException;
import tech.guyi.component.flows.exception.StartExecutorException;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 执行流
 * @author guyi
 * @date 2021/3/16 20:13
 */
public class Flows {

    private final ExecutorEntry start;
    private final List<ExecutorEntry> executors;

    public Flows(List<ExecutorEntry> executors) {
        if (executors.isEmpty()){
            throw new EmptyFlowsException();
        }

        if (executors.get(0).getExecutor() instanceof StartExecutor) {
            this.start = executors.get(0);
        }else{
            throw new StartExecutorException();
        }

        this.executors = executors.subList(1, executors.size());
    }

    /**
     * 启动流
     */
    public void start(ExecutorService service) {
        service.execute(() -> {
            FlowsContext context = new FlowsContext(ctx -> this.executors.forEach(e -> {
                if (e.getExecutor() instanceof MidExecutor){
                    Object value = ((MidExecutor) e).run(ctx, e.getProperties());
                    ctx.put(FlowsContext.LAST_RESULT_KEY, value);
                } else if (e.getExecutor() instanceof EndExecutor){
                    ((EndExecutor) e.getExecutor()).end(ctx, e.getProperties());
                }
            }));
            StartExecutor executor = (StartExecutor) this.start.getExecutor();
            executor.start(new FlowsContext.StartFlowsContext(context), this.start.getProperties());
        });
    }

}
