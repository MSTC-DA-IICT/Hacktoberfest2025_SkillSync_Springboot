package com.skillsync.skillsync.service.impl;

import java.util.*;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skillsync.skillsync.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{   
    private final UserRepository userRepository;

    //Constructor for Dependency Injection
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        // TODO: Implement save logic using repository
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        // TODO: Implement fetch all users logic
        return new ArrayList<>();
    }

    @Override
    public User getUserById(Long id) {
        // TODO: Implement get user by ID logic
        return null;
    }


    // Update User
    @Override
    public User updateUser(Long id, User user) {
        // TODO: Fetch existing user by ID
        // TODO: Update only provided fields
        // TODO: Save and return updated user
        return null;
    }


    // Add Skill to User
    @Override
    public User addSkillToUser(Long userId, Skill skill) {
        // TODO: Fetch user by ID
        // TODO: Add skill to user’s skill list
        // TODO: Save updated user
        // TODO: Return updated user
        return null;
    }


    // Find Users by Skill Name
    @Override
    public List<User> getUsersBySkill(String skillName) {
        // TODO: Implement logic to fetch users having the given skill
        // TODO: can use repository
        return null;
    }


    // Search Users by Name, Bio, or Skills
    @Override
    public List<User> searchUsers(String query) {
        if (query == null || query.trim().isEmpty()) {
            // Requirement: Return appropriate empty list if no users found
            return Collections.emptyList();
        }
        
        //Call the custom query defined in the repository
        return userRepository.searchUsers(query.trim());
    }

    
}
