package com.system.management_system.wallet;

import java.util.Date;

public record WalletResponseDTO(Long id, String username, Date date_of_create, double balance, double balance_final) {
    public WalletResponseDTO(Wallet wallet){
        this(wallet.getId(), wallet.getUsername(), wallet.getDate_of_create(), wallet.getBalance(), wallet.getBalance_final());
    }
}
