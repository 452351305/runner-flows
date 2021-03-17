package tech.guyi.component.flows.endpoint.mid;

import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.executor.MidExecutor;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
public class ByteToStringExecutor implements MidExecutor {

    @Override
    public List<String> getPropertyKeys() {
        return Collections.emptyList();
    }

    @Override
    public String getId() {
        return "byte-to-string";
    }

    @Override
    public Object run(FlowsContext context, List<EndpointProperty> properties) {
        byte[] bytes = (byte[]) context.getLastResponse();
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
