package tech.guyi.component.flows.api.executor;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;

import java.util.List;

/**
 * @author guyi
 * @date 2021/3/16 20:35
 */
public interface EndExecutor extends Executor {

    @Override
    default ExecutorType getType() {
        return ExecutorType.END;
    }

    /**
     * 节点结束
     * @param context 上下文
     * @param properties 属性
     */
    void end(FlowsContext context, List<EndpointProperty> properties);

}
