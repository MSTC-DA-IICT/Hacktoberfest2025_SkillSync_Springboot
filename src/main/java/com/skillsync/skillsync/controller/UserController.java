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

    @Autowired
    private UserService userService;

    // Save user
    @PostMapping("/register")
    public User saveUser(@RequestBody User user) {
        // TODO: Add logic to save user
        return null;
    }

    //get all users
    @GetMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // get skill's of particular user
    @GetMapping("/{id}/skills")
    public List<Skill> getUserSkills(@PathVariable Long id) {
        
        return userService.getUserSkills(id);
    }

    //update User by id  -> @RequestBody User user, change to UserUpdateDTO object
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO user) {
        // TODO: Implement update user logic (call service layer)
        return null;
    }


    //  Add Skill to existing User
    @PostMapping("/{id}/add/skills")
    public User addSkillToUser(@PathVariable Long id, @RequestBody Skill skill) {
        // TODO: Implement logic to attach skill to user via service layer
        return null;
    }


    // Find Users by Skill Name
    @GetMapping("/skill/{skillName}")
    public List<User> getUsersBySkill(@PathVariable String skillName) {
        // TODO: Implement logic to fetch users having the given skill
        return null;
    }

    // Search Users by Name, Bio, or Skills
    @GetMapping("/search")
    public List<User> searchUsers(@RequestParam("query") String query) {
        // TODO: Implement logic to search users by name, bio, or skills
        return null;
    }
}
