package io.ikka.demoaxontradesmono.controllers;

import io.ikka.demoaxoncoreapi.queries.FindAccountsQuery;
import io.ikka.demoaxontradesmono.model.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class QueryController {
    private final QueryGateway queryGateway;
    @GetMapping("/q")
    public ResponseEntity q() {
        log.info("start query");
        CompletableFuture<Account> query = queryGateway.query(new FindAccountsQuery("USD", "EUR"), Account.class);
        try {
            Account account = query.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("", e);
        }
        return ResponseEntity.ok("OK");
    }
}
