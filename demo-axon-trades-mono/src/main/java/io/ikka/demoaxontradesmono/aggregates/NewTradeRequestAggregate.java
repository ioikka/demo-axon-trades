package io.ikka.demoaxontradesmono.aggregates;

import io.ikka.demoaxoncoreapi.commands.CreateNewTradeRequestCommand;
import io.ikka.demoaxoncoreapi.commands.EnrichNewTradeRequestCommand;
import io.ikka.demoaxoncoreapi.events.NewTradeRequestEnrichedEvent;
import io.ikka.demoaxoncoreapi.events.NewTradeRequestReceivedEvent;
import io.ikka.demoaxoncoreapi.queries.FindAccountsQuery;
import io.ikka.demoaxontradesmono.model.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@NoArgsConstructor
@Data
@Aggregate
public class NewTradeRequestAggregate {
    @AggregateIdentifier
    private String requestId;
    private String orderNum;
    private String customerCode;
    private String security;
    private String settleCode;
    private String dealNumber;
    private String currency;
    private String counterCurrency;
    private String payAccountNumber;
    private String putAccountNumber;


    private transient QueryGateway queryGateway;

    @Autowired
    public void setQueryGateway(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @CommandHandler
    public NewTradeRequestAggregate(CreateNewTradeRequestCommand cmd) {
        log.info("{}", cmd);
//        CompletableFuture<Account> query = queryGateway.query(new FindAccountsQuery(cmd.currency, cmd.counterCurrency), Account.class);
//        try {
//            Account account = query.get();
//        } catch (InterruptedException | ExecutionException e) {
//            log.error("", e);
//        }
        AggregateLifecycle.apply(
                new NewTradeRequestReceivedEvent(cmd.requestId, cmd.orderNum, cmd.customerCode, cmd.security,
                        cmd.settleCode, cmd.dealNumber, cmd.currency, cmd.counterCurrency));
    }



    @CommandHandler
    public void handle(EnrichNewTradeRequestCommand cmd) {
        log.info("{}", cmd);
        AggregateLifecycle.apply(
                new NewTradeRequestEnrichedEvent(cmd.requestId, cmd.putAccount, cmd.payAccount)
        );
    }

    @EventSourcingHandler
    protected void on(NewTradeRequestReceivedEvent event){
        log.info("{}", event);
        this.requestId = event.requestId;
        this.orderNum = event.orderNum;
        this.customerCode = event.customerCode;
        this.security = event.security;
        this.settleCode = event.settleCode;
        this.dealNumber = event.dealNumber;
        this.currency = event.currency;
        this.counterCurrency = event.counterCurrency;
    }

    @EventSourcingHandler
    protected void on(NewTradeRequestEnrichedEvent event){
        log.info("{}", event);
        this.payAccountNumber = event.payAccount;
        this.putAccountNumber = event.putAccount;
    }
}
