package com.skillsync.skillsync.service;

import java.util.*;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;

public interface UserService {
    User saveUser(User user); 

    List<User> getAllUsers(); 

    User getUserById(Long id); 

    // Update User
    User updateUser(Long id, User user);

    // Add Skill to existing  User
    User addSkillToUser(Long userId, Skill skill);

    // Find Users by Skill Name
    List<User> getUsersBySkill(String skillName);

    // Search Users by Name, Bio, or Skills
    List<User> searchUsers(String query);

}
