package com.system.management_system.users;

public record UserResponseDTO(Long id, String name, String username, String email, String password) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getUsername(), user.getEmail(), user.getPassword());
    }
}
