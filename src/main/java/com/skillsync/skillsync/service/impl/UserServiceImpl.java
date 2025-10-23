package com.skillsync.skillsync.service.impl;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.UserRepository;
import com.skillsync.skillsync.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService 
{   
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // TODO: Implement save logic using repository
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }


    // Update User
    @Override
    public User updateUser(Long id, User user) { // a dto must be used for inputs
        // TODO: Fetch existing user by ID
        // TODO: Update only provided fields
        // TODO: Save and return updated user
        User existingUser = getUserById(id);
        existingUser.setBio(user.getBio());
        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        return userRepository.save(existingUser);
    }


    // Add Skill to User
    @Override
    public User addSkillToUser(Long userId, Skill skill) {
        // TODO: Fetch user by ID
        // TODO: Add skill to user’s skill list
        // TODO: Save updated user
        // TODO: Return updated user
        User existingUser = getUserById(userId);
        List<Skill> existingSkills = existingUser.getSkills();
        existingSkills.add(skill);
        existingUser.setSkills(existingSkills);
        return userRepository.save(existingUser);
    }


    // Find Users by Skill Name
    @Override
    public List<User> getUsersBySkill(String skillName) {
        // TODO: Implement logic to fetch users having the given skill
        // TODO: can use repository
        return userRepository.findBySkillsNameContainingIgnoreCase(skillName);
    }


    // Search Users by Name, Bio, or Skills
    @Override
    public List<User> searchUsers(String query) {
        //Call the custom query defined in the repository
        return Optional.ofNullable(query)
                .filter(x -> !x.isBlank())
                .map(String::trim)
                .map(userRepository::searchUsers)
                .orElse(Collections.emptyList());
    }

    @Override
    public List<Skill> getUserSkills(Long userId) {
        return getUserById(userId).getSkills();
    }
}
