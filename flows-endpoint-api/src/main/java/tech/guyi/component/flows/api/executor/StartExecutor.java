package tech.guyi.component.flows.api.executor;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;

import java.util.List;

/**
 * 开始节点
 * @author guyi
 * @date 2021/3/16 20:34
 */
public interface StartExecutor extends Executor {

    @Override
    default ExecutorType getType(){
        return ExecutorType.START;
    }

    /**
     * 启动节点
     * @param context 上下文
     * @param properties 属性
     */
    void start(FlowsContext.StartFlowsContext context, List<EndpointProperty> properties);

    /**
     * <p>停止</p>
     * <p>当流被关闭时执行</p>
     */
    void stop();

}
