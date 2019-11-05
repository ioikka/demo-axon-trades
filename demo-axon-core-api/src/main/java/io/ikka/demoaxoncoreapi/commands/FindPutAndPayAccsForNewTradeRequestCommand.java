package io.ikka.demoaxoncoreapi.commands;


import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@RequiredArgsConstructor
public class FindPutAndPayAccsForNewTradeRequestCommand {
    @TargetAggregateIdentifier
    public final String requestId;
}
