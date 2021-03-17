package tech.guyi.component.flows;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.executor.EndExecutor;
import tech.guyi.component.flows.api.executor.MidExecutor;
import tech.guyi.component.flows.api.executor.StartExecutor;
import tech.guyi.component.flows.entry.ExecutorEntry;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * 执行流
 * @author guyi
 * @date 2021/3/16 20:13
 */
public class Flows {

    private final ExecutorEntry<StartExecutor> start;
    private final ExecutorEntry<EndExecutor> end;
    private final List<ExecutorEntry<MidExecutor>> mid;

    public Flows(ExecutorEntry<StartExecutor> start, ExecutorEntry<EndExecutor> end,List<ExecutorEntry<MidExecutor>> mid) {
        this.start = start;
        this.end = end;
        this.mid = mid;
    }

    /**
     * 启动流
     */
    public void start(ExecutorService service) {
        service.execute(() -> {
            FlowsContext context = new FlowsContext(ctx -> {
                this.mid.forEach(e -> ctx.put(FlowsContext.LAST_RESULT_KEY, e.getExecutor().run(ctx, e.getProperties())));
                this.end.getExecutor().end(ctx, this.end.getProperties());
            });
            StartExecutor executor = this.start.getExecutor();
            executor.start(new FlowsContext.StartFlowsContext(context), this.start.getProperties());
        });
    }

    public void stop(){
        this.start.getExecutor().stop();
    }

}
