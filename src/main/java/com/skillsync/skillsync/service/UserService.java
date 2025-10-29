package com.skillsync.skillsync.service;

import com.skillsync.skillsync.dto.UserDTO;
import com.skillsync.skillsync.dto.UserUpdateDTO;
import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;

import java.util.List;

public interface UserService {
    User saveUser(UserDTO userDTO);

    List<User> getAllUsers(); 

    User getUserById(Long id); 

    // Update User
    User updateUser(Long id, UserUpdateDTO user);

    // Add Skill to existing  User
    User addSkillToUser(Long userId, Skill skill);

    // Find Users by Skill Name
    List<User> getUsersBySkill(String skillName);

    // Search Users by Name, Bio, or Skills
    List<User> searchUsers(String query);

    //get skills of a particular users
    List<Skill> getUserSkills(Long userId);
}
