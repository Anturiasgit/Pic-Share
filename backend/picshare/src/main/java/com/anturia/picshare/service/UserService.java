package com.anturia.picshare.service;

import com.anturia.picshare.model.User;
import com.anturia.picshare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Créer un utilisateur
    public User createUser(User user) {
        // Encode le mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User register(String username, String email, String rawPassword) {

    if (usernameExists(username)) {
        throw new RuntimeException("Username already exists");
    }

    if (emailExists(email)) {
        throw new RuntimeException("Email already exists");
    }

    User user = User.builder()
            .username(username)
            .email(email)
            .password(passwordEncoder.encode(rawPassword))
            .build();

    return userRepository.save(user);
}

    // Récupérer un utilisateur par ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Récupérer un utilisateur par username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Mettre à jour un utilisateur
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Vérifier si un username existe
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // Vérifier si un email existe
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}