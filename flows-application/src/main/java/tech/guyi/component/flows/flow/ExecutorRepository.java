package tech.guyi.component.flows.flow;

import org.springframework.stereotype.Component;
import tech.guyi.component.flows.api.executor.Executor;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
@Component
public class ExecutorRepository {

    @Resource
    private List<Executor> executors;

    public Optional<Executor> get(String id){
        return this.executors.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

}
