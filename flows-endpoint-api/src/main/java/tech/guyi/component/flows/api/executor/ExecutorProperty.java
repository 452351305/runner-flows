package tech.guyi.component.flows.api.executor;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.guyi.component.flows.api.endpoint.EndpointPropertyType;

/**
 * @author guyi
 * @date 2021/3/16 21:32
 */
@Data
@AllArgsConstructor
public class ExecutorProperty {

    private String key;
    private EndpointPropertyType type;

}
