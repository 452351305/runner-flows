package tech.guyi.component.flows.api.executor;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 执行器类型
 * @author guyi
 * @date 2021/3/16 20:31
 */
@Getter
@AllArgsConstructor
public enum ExecutorType {

    START("START","开始节点"),
    MID("MID","中间节点"),
    END("END","结束节点");

    private final String value;
    private final String text;

}
