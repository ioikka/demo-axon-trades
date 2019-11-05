package io.ikka.demoaxoncoreapi.commands;

import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@RequiredArgsConstructor
public class EnrichNewTradeRequestCommand {
    @TargetAggregateIdentifier
    public final String requestId;
    public final String putAccount;
    public final String payAccount;

// "requestUID"	: "d2d0ae51-2a03-466b-ace6-49fe3c72d4f2",
//         "quickClassCode": "CETS",
//         "security": "USD000000TOD",
//         "settleCode": "MB0054311161",
//         "dealType": "aggregate",
//
//         "orderNum": 30000000090,
//         "dealNumber": "4018671690",
//         "customerCode": "41151",
//         "amount": "200",
//         "currency": "RUR",
//         "counterCurrency": "USD",
//         "side": "b",
//         "tradeRate" : "57.12",
//         "valueDate": "2019-10-11",
//         "tradeDate": "2019-10-11"

}
