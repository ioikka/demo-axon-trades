package io.ikka.demoaxontradesmono.repository;

import io.ikka.demoaxontradesmono.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findAccountByCurrencyAndCounterCurrency(String currency, String counterCurrency);
}
