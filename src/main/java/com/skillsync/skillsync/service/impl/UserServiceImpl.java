package com.skillsync.skillsync.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import com.skillsync.skillsync.dto.SkillDTO;
import com.skillsync.skillsync.dto.UserDTO;
import com.skillsync.skillsync.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.UserRepository;
import com.skillsync.skillsync.service.UserService;

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
    public User updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        // Fetch existing user by ID
        Optional<User> userOptional = userRepository.findById(id);
        
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User Not Found");
        }
        
        User existingUser = userOptional.get();
        
        // Update only name, bio, and skills - other fields remain unchanged
        existingUser.setName(userUpdateDTO.getName());
        
        // Update bio if provided (can be null to clear bio)
        existingUser.setBio(userUpdateDTO.getBio());
        
        // Handle skills update - only update if skills are provided
        if (userUpdateDTO.getSkills() != null) {
            // Clear existing skills from the collection (orphanRemoval will handle deletion)
            // Important: Clear the existing collection, don't replace it with a new one
            existingUser.getSkills().clear();
            
            // Add new skills to the existing collection
            if (!userUpdateDTO.getSkills().isEmpty()) {
                for (SkillDTO skillDTO : userUpdateDTO.getSkills()) {
                    Skill skill = new Skill();
                    skill.setName(skillDTO.getName());
                    skill.setDescription(skillDTO.getDescription());
                    skill.setUser(existingUser);
                    existingUser.getSkills().add(skill);
                }
            }
        }
        
        // Save and return updated user
        return userRepository.save(existingUser);
    }


    // Add Skill to User
    @Override
    public User addSkillToUser(Long userId, Skill skill) {
        // Fetch user by ID
        Optional<User> userOptional = userRepository.findById(userId);
        
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User Not Found with id: " + userId);
        }
        
        User user = userOptional.get();
        
        // Validate skill name is not null or empty
        if (skill.getName() == null || skill.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Skill name is required");
        }
        
        // Set the user reference for the skill
        skill.setUser(user);
        
        // Add skill to user's skill list
        if (user.getSkills() == null) {
            user.setSkills(new ArrayList<>());
        }
        user.getSkills().add(skill);
        
        // Save updated user (skill will be saved due to cascade)
        return userRepository.save(user);
    }


    // Find Users by Skill Name
    @Override
    public List<User> getUsersBySkill(String skillName) {
        // Return empty list if skill name is null or empty
        if (skillName == null || skillName.trim().isEmpty()) {
            return Collections.emptyList();
        }
        
        // Use repository method to find users with case-insensitive skill name matching
        List<User> users = userRepository.findBySkillNameIgnoreCase(skillName.trim());
        
        return users != null ? users : Collections.emptyList();
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
