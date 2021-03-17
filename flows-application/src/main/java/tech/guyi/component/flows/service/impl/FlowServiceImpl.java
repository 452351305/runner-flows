package tech.guyi.component.flows.service.impl;

import lombok.Getter;
import org.springframework.stereotype.Service;
import tech.guyi.component.flows.Flows;
import tech.guyi.component.flows.api.endpoint.Endpoint;
import tech.guyi.component.flows.api.executor.Executor;
import tech.guyi.component.flows.api.executor.MidExecutor;
import tech.guyi.component.flows.db.entity.Flow;
import tech.guyi.component.flows.db.repository.FlowRepository;
import tech.guyi.component.flows.entry.ExecutorEntry;
import tech.guyi.component.flows.flow.ExecutorRepository;
import tech.guyi.component.flows.service.FlowService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author e-Peng.Zhang2
 * @date 2021/3/17
 */
@Service
public class FlowServiceImpl implements FlowService {

    @Getter
    @Resource
    private FlowRepository repository;

    @Resource
    private ExecutorRepository executorRepository;

    private final ExecutorService service = Executors.newScheduledThreadPool(2);
    private final Map<String, Flows> flows = new HashMap<>();

    @Override
    public Class<Flow> entityClass() {
        return Flow.class;
    }

    private <T extends Executor> ExecutorEntry<T> converter(Endpoint endpoint){
        return this.executorRepository.get(endpoint.getTarget())
                .map(e -> new ExecutorEntry<>((T) e, endpoint.getProperties()))
                .orElse(null);
    }

    @Override
    public void start(String flowId) {
        this.findById(flowId).ifPresent(flow -> {
            Flows flows = new Flows(
                    this.converter(flow.getStart()),
                    this.converter(flow.getEnd()),
                    flow.getMid().stream().map(this::<MidExecutor>converter).collect(Collectors.toList())
            );
            flows.start(this.service);
            this.flows.put(flowId,flows);
        });
    }

    @Override
    public void stop(String flowId) {
        Optional.ofNullable(this.flows.get(flowId))
                .ifPresent(Flows::stop);
    }
}
