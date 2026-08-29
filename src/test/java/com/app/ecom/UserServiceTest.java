package com.app.ecom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UserServiceTest {

    @Test
    void updateUser_shouldUpdateExistingUser() {
        UserService userService = new UserService();
        User user = new User();
        user.setFirstName("Alice");
        user.setLastName("Smith");

        userService.addUser(user);

        User updated = new User();
        updated.setFirstName("Alicia");
        updated.setLastName("Jones");

        User result = userService.updateUser(1L, updated);

        assertNotNull(result);
        assertEquals("Alicia", result.getFirstName());
        assertEquals("Jones", result.getLastName());
    }
}
