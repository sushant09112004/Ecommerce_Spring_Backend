package com.app.ecom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
     private List<User> userList = new ArrayList<>();
     private Long nextId = 1L;

     public List<User> fetchAllUsers(){
        return userList;
     }

     public List<User> addUser (User user){
        user.setId(nextId++); 
        userList.add(user);
        return userList;
     }

     public User fetchUser (Long id){
         for (User user : userList){
            if (user.getId().equals(id)){
               return user;
            }
         }
         return null;
     }
     public User updateUser(Long id, User newUser) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                if (newUser.getFirstName() != null) {
                    user.setFirstName(newUser.getFirstName());
                }
                if (newUser.getLastName() != null) {
                    user.setLastName(newUser.getLastName());
                }
                return user;
            }
        }
        return null;
     }
}