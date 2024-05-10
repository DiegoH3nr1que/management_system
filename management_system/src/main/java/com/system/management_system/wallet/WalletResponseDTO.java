package com.system.management_system.wallet;

import java.util.Date;

public record WalletResponseDTO(Long id, String name, Date date_of_create, double balance) {
    public WalletResponseDTO(Wallet wallet){
        this(wallet.getId(), wallet.getName(), wallet.getDate_of_create(), wallet.getBalance());
    }
}
