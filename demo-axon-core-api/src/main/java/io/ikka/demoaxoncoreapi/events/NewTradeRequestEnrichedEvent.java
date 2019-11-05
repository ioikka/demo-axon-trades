package io.ikka.demoaxoncoreapi.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class NewTradeRequestEnrichedEvent {
    public final String requestId;
    public final String putAccount;
    public final String payAccount;
}
