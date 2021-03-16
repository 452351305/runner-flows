package tech.guyi.component.flows.exception;

import tech.guyi.component.flows.api.executor.StartExecutor;

/**
 * @author guyi
 * @date 2021/3/16 20:46
 */
public class StartExecutorException extends RuntimeException {

    public StartExecutorException() {
        super(String.format("第一个执行器必须为启动执行器 [%s]", StartExecutor.class));
    }
}
