package tech.guyi.component.flows.api.endpoint;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

/**
 * 节点属性类型
 * @author guyi
 * @date 2021/3/16 20:18
 */
@Getter
@AllArgsConstructor
public enum EndpointPropertyType {

    INPUT("INPUT","普通文本输入", String::toString),
    TEXT("TEXT","文本域", String::toString);

    private final String value;
    private final String text;
    private final Function<String,Object> converter;

}
