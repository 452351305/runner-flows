package tech.guyi.component.flows.endpoint.mid;

import lombok.SneakyThrows;
import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.executor.MidExecutor;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Collections;
import java.util.List;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
public class JavaScriptExecutor implements MidExecutor {

    private final ScriptEngineManager manager = new ScriptEngineManager();

    @Override
    public List<String> getPropertyKeys() {
        return Collections.singletonList("func");
    }

    @Override
    public String getId() {
        return "javascript";
    }

    @Override
    @SneakyThrows
    public Object run(FlowsContext context, List<EndpointProperty> properties) {
        ScriptEngine engine = this.manager.getEngineByName("js");
        String js = this.getProperty("func", properties).toString();
        engine.put("context", context);
        return engine.eval(js);
    }
}
