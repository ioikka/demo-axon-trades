package io.ikka.demoaxontradesmono;

import io.ikka.demoaxoncoreapi.queries.FindAccountsQuery;
import io.ikka.demoaxontradesmono.model.Account;
import io.ikka.demoaxontradesmono.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class AccountQueryHandler {
    private final AccountRepository accountRepository;

    @QueryHandler
    public Account handle(FindAccountsQuery query) {
        log.info("{}", query);
        Optional<Account> account = accountRepository.findAccountByCurrencyAndCounterCurrency(query.getCurrency(), query.getCounterCurrency());
        return account.orElse(null);
    }
}
