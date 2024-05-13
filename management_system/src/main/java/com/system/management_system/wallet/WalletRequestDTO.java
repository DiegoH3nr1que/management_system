package com.system.management_system.wallet;

import java.util.Date;
public record WalletRequestDTO(String username, Date date_of_create, double balance) {

}
