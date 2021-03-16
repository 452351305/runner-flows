package tech.guyi.component.flows.exception;

import tech.guyi.component.flows.api.executor.EndExecutor;

/**
 * @author guyi
 * @date 2021/3/16 20:46
 */
public class EndExecutorException extends RuntimeException {

    public EndExecutorException() {
        super(String.format("最后一个执行器必须为停止执行器 [%s]", EndExecutor.class));
    }
}
