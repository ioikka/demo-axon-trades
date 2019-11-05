package io.ikka.demoaxontradesmono.dto;

import lombok.Data;

@Data
public class NewTradeRequestDTO {
    private String requestUID;
    private String orderNum;
    private String customerCode;
    private String security;
    private String settleCode;
    private String dealNumber;
    private String currency;
    private String counterCurrency;
}
