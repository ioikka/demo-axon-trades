package io.ikka.demoaxoncoreapi.queries;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class FindAccountsQuery {
    private final String currency;
    private final String counterCurrency;
}
