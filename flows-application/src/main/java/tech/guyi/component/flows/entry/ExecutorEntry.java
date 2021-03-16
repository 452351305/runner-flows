package tech.guyi.component.flows.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.executor.Executor;

import java.util.List;

/**
 * @author guyi
 * @date 2021/3/16 20:56
 */
@Data
@AllArgsConstructor
public class ExecutorEntry {

    private Executor executor;
    private List<EndpointProperty> properties;

}
