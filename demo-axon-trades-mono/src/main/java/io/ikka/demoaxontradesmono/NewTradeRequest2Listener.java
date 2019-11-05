package io.ikka.demoaxontradesmono;

import io.ikka.demoaxoncoreapi.events.NewTradeRequestReceivedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NewTradeRequest2Listener {
    private final CommandGateway commandGateway;
    @EventHandler
    public void handle(NewTradeRequestReceivedEvent event) {
        log.info("{}", event);
//        commandGateway.send()
    }
}
