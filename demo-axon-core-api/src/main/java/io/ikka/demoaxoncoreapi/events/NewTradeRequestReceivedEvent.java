package io.ikka.demoaxoncoreapi.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class NewTradeRequestReceivedEvent {
    public final String requestId;
    public final String orderNum;
    public final String customerCode;
    public final String security;
    public final String settleCode;
    public final String dealNumber;
    public final String currency;
    public final String counterCurrency;
}
