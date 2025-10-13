package com.skillsync.skillsync.service;

import java.util.*;

import com.skillsync.skillsync.model.User;

public interface UserService {
    User saveUser(User user); 

    List<User> getAllUsers(); 

    User getUserById(Long id); 
}
