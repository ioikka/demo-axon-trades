package io.ikka.demoaxoncoreapi.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class NewTradeRequestPersistedEvent {
    public final String originalRequestId;
    public final String objectId;
    public final boolean success;
    public final String errorCode;
    public final String errorDescription;
}
