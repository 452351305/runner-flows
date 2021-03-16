package tech.guyi.component.flows.api.endpoint;

import lombok.Data;

import java.util.List;

/**
 * 执行节点
 * @author guyi
 * @date 2021/3/16 20:14
 */
@Data
public class Endpoint {

    /**
     * 节点名称
     */
    private String name;
    /**
     * 节点指向执行器
     */
    private String target;
    /**
     * 节点属性
     */
    private List<EndpointProperty> properties;

}
