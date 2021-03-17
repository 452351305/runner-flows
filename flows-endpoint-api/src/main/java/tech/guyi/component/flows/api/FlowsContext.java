package tech.guyi.component.flows.api;

import java.util.HashMap;
import java.util.function.Consumer;

/**
 * 执行流上下文
 * @author guyi
 * @date 2021/3/16 20:24
 */
public class FlowsContext extends HashMap<String,Object> {

    public static final String LAST_RESULT_KEY = "resp";

    public static final class StartFlowsContext {

        private final FlowsContext context;
        public StartFlowsContext(FlowsContext context) {
            this.context = context;
        }

        public void next(Object value){
            this.context.put(LAST_RESULT_KEY, value);
            this.context.midRunnable.accept(this.context);
        }

    }

    private final Consumer<FlowsContext> midRunnable;

    public FlowsContext(Consumer<FlowsContext> midRunnable) {
        this.midRunnable = midRunnable;
    }

    /**
     * 获取上一个执行器返回的内容
     * @return 上一个执行器返回的内容
     */
    public Object getLastResponse(){
        return this.get(LAST_RESULT_KEY);
    }
}
