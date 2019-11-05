package io.ikka.demoaxoncoreapi.commands;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@RequiredArgsConstructor
public class CreateNewTradeRequestCommand {
    @TargetAggregateIdentifier
    public final String requestId;
    public final String orderNum;
    public final String customerCode;
    public final String security;
    public final String settleCode;
    public final String dealNumber;
    public final String currency;
    public final String counterCurrency;



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
