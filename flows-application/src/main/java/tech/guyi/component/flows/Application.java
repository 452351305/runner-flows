package tech.guyi.component.flows;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.endpoint.EndpointPropertyType;
import tech.guyi.component.flows.api.executor.Executor;
import tech.guyi.component.flows.entry.ExecutorEntry;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author guyi
 * @date 2021/3/16 20:11
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Resource
    private List<Executor> executors;

    @Override
    public void run(String... args) throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();

        List<ExecutorEntry> entries = Arrays.asList(
                new ExecutorEntry(
                        this.executors.stream().filter(e -> "udp-server".equals(e.getId())).findFirst().orElse(null),
                        Collections.singletonList(new EndpointProperty("port","9999", EndpointPropertyType.INPUT))
                ),
                new ExecutorEntry(
                        this.executors.stream().filter(e -> "console".equals(e.getId())).findFirst().orElse(null),
                        Collections.emptyList()
                )
        );

        Flows flows = new Flows(entries);
        flows.start(service);
    }

}
