package tech.guyi.component.flows.api.endpoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 节点属性
 * @author guyi
 * @date 2021/3/16 20:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndpointProperty {

    /**
     * 键
     */
    private String key;
    /**
     * 值
     */
    private String value;

}
