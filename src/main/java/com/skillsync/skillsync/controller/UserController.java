package com.skillsync.skillsync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.service.SkillService;
import com.skillsync.skillsync.service.UserService;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public User saveUser(@RequestBody User user) {
        // TODO: Add logic to save user
        return null;
    }

    @GetMapping
    public List<User> getAllUsers() {
        // TODO: Add logic to fetch all users
        return null;
    }

    @GetMapping
    public User getUserById(@PathVariable Long id) {
        // TODO: Add logic to fetch user by ID
        return null;
    }

    @GetMapping
    public List<Skill> getUserSkills(@PathVariable Long id) {
        // TODO: Add logic to fetch user's skills
        return null;
    }
}
