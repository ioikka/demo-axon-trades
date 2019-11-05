package io.ikka.demoaxontradesmono.startup;

import io.ikka.demoaxontradesmono.model.Account;
import io.ikka.demoaxontradesmono.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class AccountPopulator implements CommandLineRunner {
    private final AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            Account entity = new Account();
            entity.setCurrency("USD");
            entity.setCounterCurrency("EUR");
            entity.setPayAccount("12345678901234567890");
            entity.setPutAccount("09876543210987654321");
            accountRepository.save(entity);
        } catch (Throwable e) {
            log.error("", e);
        }
    }
}
