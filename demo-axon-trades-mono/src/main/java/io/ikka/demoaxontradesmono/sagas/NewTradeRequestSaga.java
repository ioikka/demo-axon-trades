package io.ikka.demoaxontradesmono.sagas;

import io.ikka.demoaxoncoreapi.commands.EnrichNewTradeRequestCommand;
import io.ikka.demoaxoncoreapi.events.NewTradeRequestEnrichedEvent;
import io.ikka.demoaxoncoreapi.events.NewTradeRequestReceivedEvent;
import io.ikka.demoaxoncoreapi.queries.FindAccountsQuery;
import io.ikka.demoaxontradesmono.model.Account;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Saga
public class NewTradeRequestSaga {

    @Autowired
    private transient CommandGateway commandGateway;
    @Autowired
    private transient QueryGateway queryGateway;
//    @Autowired
//    private transient SimpleEventBus eventBus;

    @StartSaga
    @SagaEventHandler(associationProperty = "requestId")
    public void handle(NewTradeRequestReceivedEvent event) {
        log.info("{}", event);
        CompletableFuture<Account> query = queryGateway.query(new FindAccountsQuery(event.currency, event.counterCurrency), Account.class);
        try {
            Account account = query.get();
            log.info("{}", account);
            commandGateway.send(
                    new EnrichNewTradeRequestCommand(
                            event.requestId, account.getPutAccount(), account.getPayAccount()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @SagaEventHandler(associationProperty = "requestId")
    public void handle(NewTradeRequestEnrichedEvent event) {
        log.info("{}", event);
        throw new IllegalArgumentException();

    }

//    @EndSaga
//    @SagaEventHandler(associationProperty = "originalRequestId")
//    public void handle(NewTradeRequestPersistedEvent event) {
//        log.info("{}", event);
//    }

//    @EventHandler
//    public void hh(NewTradeRequestReceivedEvent event) {
//        log.info("{}", event);
//    }
}
