package io.ikka.demoaxontradesmono.controllers;

import io.ikka.demoaxoncoreapi.commands.CreateNewTradeRequestCommand;
import io.ikka.demoaxontradesmono.dto.NewTradeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/trades")
public class NewTradeRequestController {
    private final CommandGateway commandGateway;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<String> createNewTradeRequest(@RequestBody NewTradeRequestDTO req) {
        String newUUID = UUID.randomUUID().toString();
        return commandGateway.send(
                new CreateNewTradeRequestCommand(
                        StringUtils.isEmpty(req.getRequestUID()) ? newUUID: req.getRequestUID(),
                        req.getOrderNum(),
                        req.getCustomerCode(),
                        req.getSecurity(),
                        req.getSettleCode(),
                        req.getDealNumber(),
                        req.getCurrency(),
                        req.getCounterCurrency()));
    }
}
