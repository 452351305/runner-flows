package tech.guyi.component.flows.api.executor;

import tech.guyi.component.flows.api.endpoint.EndpointProperty;

import java.util.List;

/**
 * 执行器
 * @author guyi
 * @date 2021/3/16 20:22
 */
public interface Executor {

    /**
     * 获取属性
     * @param key 键
     * @param properties 属性集合
     * @return 值
     */
    default Object getProperty(String key, List<EndpointProperty> properties){
        return properties.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElse(null);
    }

    /**
     * 属性键集合
     * @return 属性键集合
     */
    List<ExecutorProperty> getPropertyKeys();

    /**
     * 执行器唯一标识
     * @return 唯一标识
     */
    String getId();

    /**
     * 执行器类型
     * @return 执行器类型
     */
    ExecutorType getType();

}
