package com.skillsync.skillsync.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import com.skillsync.skillsync.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.UserRepository;
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


    /**
     *
     * @param userDTO userDTO
     * @return
     */
    @Override
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setBio(userDTO.getBio());
        user.setRoleType(userDTO.getRoleType());
        user.setAvailableForMentorship(userDTO.isAvailableForMentorship());
        if (userDTO.getSkills() != null && !userDTO.getSkills().isEmpty()) {
            List<Skill> skillList = userDTO.getSkills().stream().map(skillDTO -> {
                Skill skill = new Skill();
                skill.setName(skillDTO.getName());
                skill.setDescription(skillDTO.getDescription());
                skill.setUser(user);
                return skill;
            }).collect(Collectors.toList());

            user.setSkills(skillList);
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent())
        {
            throw new RuntimeException("User Not Found");
        }
        return userOptional.get();
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

    @Override
    public List<Skill> getUserSkills(Long userId) {
        // Find user by ID
        Optional<User> userOptional = userRepository.findById(userId);

        // Check if user exists
        if(!userOptional.isPresent())
        {
            // Note: A custom exception (e.g., UserNotFoundException) is better practice
            throw new RuntimeException("User Not Found"); 
        }

        User user = userOptional.get();

        // Return the list of skills from the User entity
        return user.getSkills();
    }
}
