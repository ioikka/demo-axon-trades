package io.ikka.demoaxontradesmono.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "account", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_ACCOUNT", columnNames =
                {"putAccount", "payAccount", "currency", "counterCurrency"})
})
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String putAccount;
    private String payAccount;
    private String currency;
    private String counterCurrency;

}
