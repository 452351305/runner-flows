package tech.guyi.component.flows.endpoint.start;

import lombok.SneakyThrows;
import tech.guyi.component.channel.MessageChannelOption;
import tech.guyi.component.channel.defaults.UdpMessageChannel;
import tech.guyi.component.flows.api.FlowsContext;
import tech.guyi.component.flows.api.endpoint.EndpointProperty;
import tech.guyi.component.flows.api.executor.StartExecutor;

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
    public List<String> getPropertyKeys() {
        return Collections.singletonList(PORT);
    }

    @Override
    public String getId() {
        return "udp-server";
    }

    private UdpMessageChannel channel;

    @Override
    @SneakyThrows
    public void start(FlowsContext.StartFlowsContext context, List<EndpointProperty> properties) {
        int port = Integer.parseInt(this.getProperty(PORT, properties).toString());
        channel = new UdpMessageChannel();
        channel.option(MessageChannelOption.ON_MESSAGE, message -> context.next(message.getContent()));
        channel.listen(new InetSocketAddress(port));
    }

    @Override
    public void stop() {
        if (this.channel != null){
            this.channel.close();
        }
    }
}
