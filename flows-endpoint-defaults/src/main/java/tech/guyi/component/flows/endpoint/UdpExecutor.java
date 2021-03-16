package tech.guyi.component.flows.endpoint;

import io.netty.channel.nio.NioEventLoopGroup;
import lombok.SneakyThrows;
import tech.guyi.component.channel.MessageChannelOption;
import tech.guyi.component.channel.defaults.UdpMessageChannel;
import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.endpoint.EndpointPropertyType;
import tech.guyi.component.flows.api.executor.ExecutorProperty;
import tech.guyi.component.flows.api.executor.StartExecutor;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.List;

/**
 * @author guyi
 * @date 2021/3/16 21:09
 */
public class UdpExecutor implements StartExecutor {

    private static final String PORT = "port";

    @Override
    public List<ExecutorProperty> getPropertyKeys() {
        return Collections.singletonList(new ExecutorProperty(PORT, EndpointPropertyType.INPUT));
    }

    @Override
    public String getId() {
        return "udp-server";
    }

    private DatagramSocket server;

    @Override
    @SneakyThrows
    public void start(FlowsContext.StartFlowsContext context, List<EndpointProperty> properties) {
        int port = Integer.parseInt(((EndpointProperty) this.getProperty(PORT, properties)).getValue());
        UdpMessageChannel channel = new UdpMessageChannel();
        channel.option(MessageChannelOption.ON_MESSAGE, message -> {
            context.next(new String(message.getContent()));
        });
        channel.listen(new InetSocketAddress(port), new NioEventLoopGroup());
    }

    @Override
    public void stop() {

    }
}
