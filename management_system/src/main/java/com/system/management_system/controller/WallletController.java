package com.system.management_system.controller;

import com.system.management_system.users.User;
import com.system.management_system.users.UserRepository;
import com.system.management_system.users.UserRequestDTO;
import com.system.management_system.users.UserResponseDTO;
import com.system.management_system.wallet.Wallet;
import com.system.management_system.wallet.WalletRepository;
import com.system.management_system.wallet.WalletRequestDTO;
import com.system.management_system.wallet.WalletResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/wallet")
public class WallletController {

    @Autowired
    private WalletRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void SaveUsewallet(@RequestBody WalletRequestDTO data){
        Wallet WalletData = new Wallet(data);
        repository.save(WalletData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<WalletResponseDTO> getAll(){
        List<WalletResponseDTO> walletList = repository.findAll().stream().map(WalletResponseDTO::new).toList();
        return walletList;
    }

}
