package com.system.management_system.wallet;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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
    private String username;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_create")
    private Date date_of_create;

    private double balance;

    private double balance_final;

    @PrePersist
    protected void onCreate() {
        this.date_of_create = new Date();
    }

    public Wallet(WalletRequestDTO data) {
        this.username = data.username();
        this.balance = data.balance();
    }

    public void updateBalance(double amount) {
        this.balance_final += amount;
    }

    public void recalculateBalance(List<Wallet> wallets) {
        double totalBalance = 0.0;
        for (Wallet wallet : wallets) {
            if (wallet.getUsername().equals(this.username)) {
                totalBalance += wallet.getBalance();
            }
        }
        this.balance_final = totalBalance;
    }
}
