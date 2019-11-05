package io.ikka.demoaxontradesmono;

import io.ikka.demoaxoncoreapi.events.NewTradeRequestReceivedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Slf4j

@Service
public class NewTradeRequestListener {
    @EventHandler
    public void handle(NewTradeRequestReceivedEvent event) {
        log.info("{}", event);
    }
}
