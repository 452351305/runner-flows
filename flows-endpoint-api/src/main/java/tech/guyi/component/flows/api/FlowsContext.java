package tech.guyi.component.flows.api;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 执行流上下文
 * @author guyi
 * @date 2021/3/16 20:24
 */
public class FlowsContext {

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

    /**
     * 上下文存储
     */
    private final Map<String,Object> map;
    private final Consumer<FlowsContext> midRunnable;

    public FlowsContext(Consumer<FlowsContext> midRunnable) {
        this.midRunnable = midRunnable;
        this.map = new HashMap<>();
    }

    /**
     * 添加上下文属性
     * @param key 键
     * @param value 值
     */
    public void put(String key,Object value) {
        this.map.put(key,value);
    }

    /**
     * 获取上下文属性
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return this.map.get(key);
    }

    /**
     * 获取上一个执行器返回的内容
     * @return 上一个执行器返回的内容
     */
    public Object getLastResponse(){
        return this.get(LAST_RESULT_KEY);
    }
}
