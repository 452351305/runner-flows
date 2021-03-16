package tech.guyi.component.flows.api.executor;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;

import java.util.List;

/**
 * @author guyi
 * @date 2021/3/16 20:34
 */
public interface MidExecutor extends Executor {

    @Override
    default ExecutorType getType() {
        return ExecutorType.MID;
    }

    /**
     * 执行过程
     * @param context 上下文
     * @param properties 属性
     */
    Object run(FlowsContext context, List<EndpointProperty> properties);

}
