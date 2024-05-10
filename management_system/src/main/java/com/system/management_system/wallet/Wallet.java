package com.system.management_system.wallet;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "wallet")
@Entity(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


//    Realizei um teste sobre esse atributo  date of create e ainda não está funcionando 100%
//    Estou tentando fazer com que esse atributo seja inserido automatico ao criar um wallet
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_create")
    private Date date_of_create;

    private double balance;

    @PrePersist
    protected void onCreate() {
        this.date_of_create = new Date();
    }

    public Wallet(WalletRequestDTO data) {
        this.name = data.name();
        this.balance = data.balance();
    }
}
