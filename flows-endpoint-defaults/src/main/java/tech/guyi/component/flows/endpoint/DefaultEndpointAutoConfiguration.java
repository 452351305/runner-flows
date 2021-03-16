package tech.guyi.component.flows.endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guyi
 * @date 2021/3/16 21:49
 */
@Configuration
public class DefaultEndpointAutoConfiguration {

    @Bean
    public UdpExecutor udpExecutor(){
        return new UdpExecutor();
    }

    @Bean
    public ConsoleExecutor consoleExecutor(){
        return new ConsoleExecutor();
    }

}
