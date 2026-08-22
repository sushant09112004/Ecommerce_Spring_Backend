package com.app.ecom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/users")
    public List <User> getAllUsers(){
        return  userService.fetchAllUsers();
    }

    @GetMapping("/api/users/{id}")
    public User getUser(@PathVariable Long id){
        return  userService.fetchUser(id);
    }

    @PostMapping("api/users")
    public String createUser (@RequestBody User user){
        userService.addUser(user);
        return "User added Succesfully";
    }
}
