package tech.guyi.component.flows.endpoint;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.executor.EndExecutor;
import tech.guyi.component.flows.api.executor.ExecutorProperty;

import java.util.Collections;
import java.util.List;

/**
 * @author guyi
 * @date 2021/3/16 21:50
 */
public class ConsoleExecutor implements EndExecutor {

    @Override
    public void end(FlowsContext context, List<EndpointProperty> properties) {
        System.out.println(context.getLastResponse());
    }

    @Override
    public List<ExecutorProperty> getPropertyKeys() {
        return Collections.emptyList();
    }

    @Override
    public String getId() {
        return "console";
    }
}
