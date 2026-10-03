package com.app.ecom.service;

import java.util.List;
import java.util.Optional;

import com.app.ecom.model.User;
import com.app.ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> fetchUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> updateUser(Long id, User newUser) {

        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            return Optional.empty();
        }

        User temp = existingUser.get();

        temp.setFirstName(newUser.getFirstName());
        temp.setLastName(newUser.getLastName());

        User updatedUser = userRepository.save(temp);

        return Optional.of(updatedUser);
    }
}