package com.system.management_system.wallet;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "wallet", schema = "public")
@Entity(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "date_of_create")
    private Date dateOfCreate;

    private double balance;

    @PrePersist
    protected void onCreate() {
        this.dateOfCreate = new Date();
    }


    public Wallet(WalletRequestDTO data) {
        this.name = data.name();
        this.dateOfCreate = data.date_of_create();
        this.balance = data.balance();
    }
}
