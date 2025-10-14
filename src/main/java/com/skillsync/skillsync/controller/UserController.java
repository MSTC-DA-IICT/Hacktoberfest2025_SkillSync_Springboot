package com.skillsync.skillsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillsync.skillsync.dto.UserUpdateDTO;
import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.service.SkillService;
import com.skillsync.skillsync.service.UserService;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Save user
    @PostMapping
    public User saveUser(@RequestBody User user) {
        // TODO: Add logic to save user
        return null;
    }

    //get all users
    @GetMapping
    public List<User> getAllUsers() {
        // TODO: Add logic to fetch all users
        return null;
    }

    // get user by id
    @GetMapping
    public User getUserById(@PathVariable Long id) {
        // TODO: Add logic to fetch user by ID
        return null;
    }

    // get skill's of particular user
    @GetMapping
    public List<Skill> getUserSkills(@PathVariable Long id) {
        // TODO: Add logic to fetch user's skills
        return null;
    }

    //update User by id  -> @RequestBody User user, change to UserUpdateDTO object
    @PutMapping
    public User updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO user) {
        // TODO: Implement update user logic (call service layer)
        return null;
    }


    //  Add Skill to existing User
    @PostMapping
    public User addSkillToUser(@PathVariable Long id, @RequestBody Skill skill) {
        // TODO: Implement logic to attach skill to user via service layer
        return null;
    }


    // Find Users by Skill Name
    @GetMapping
    public List<User> getUsersBySkill(@PathVariable String skillName) {
        // TODO: Implement logic to fetch users having the given skill
        return null;
    }

    // Search Users by Name, Bio, or Skills
    @GetMapping
    public List<User> searchUsers(@RequestParam("query") String query) {
        // TODO: Implement logic to search users by name, bio, or skills
        return null;
    }
}
