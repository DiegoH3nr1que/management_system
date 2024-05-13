package com.system.management_system.controller;

import com.system.management_system.users.User;
import com.system.management_system.users.UserRepository;
import com.system.management_system.users.UserRequestDTO;
import com.system.management_system.users.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {


    @Autowired
    private UserRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @Operation(summary = "Postar", description = "Método que Posta os usuários", tags = "Post em todos os usuários")

    public void SaveUser(@RequestBody UserRequestDTO data){
        User UserData = new User(data);
        repository.save(UserData);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    @Operation(summary = "Listar", description = "Método que retorna os dados de usuário", tags = "Get em todos os usuários")
    public List<UserResponseDTO> getAll(){
        List<UserResponseDTO> userList = repository.findAll().stream().map(UserResponseDTO::new).toList();
        return userList;

    }

}
