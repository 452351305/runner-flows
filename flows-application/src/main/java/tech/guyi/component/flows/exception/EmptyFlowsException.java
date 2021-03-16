package tech.guyi.component.flows.exception;

/**
 * 空流异常
 * @author guyi
 * @date 2021/3/16 20:44
 */
public class EmptyFlowsException extends RuntimeException {

    public EmptyFlowsException() {
        super("流中必须存在执行器");
    }
}
