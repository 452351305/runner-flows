package tech.guyi.component.flows.endpoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.guyi.component.flows.endpoint.end.ConsoleExecutor;
import tech.guyi.component.flows.endpoint.mid.ByteToStringExecutor;
import tech.guyi.component.flows.endpoint.mid.JavaScriptExecutor;
import tech.guyi.component.flows.endpoint.start.UdpExecutor;

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

    @Bean
    public ByteToStringExecutor byteToStringExecutor(){
        return new ByteToStringExecutor();
    }

    @Bean
    public JavaScriptExecutor javaScriptExecutor(){
        return new JavaScriptExecutor();
    }

}
