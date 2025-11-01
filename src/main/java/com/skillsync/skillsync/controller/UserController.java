package com.skillsync.skillsync.controller;

import com.skillsync.skillsync.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.skillsync.skillsync.dto.UserUpdateDTO;
import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.service.SkillService;
import com.skillsync.skillsync.service.UserService;
import org.springframework.http.ResponseEntity;
import com.skillsync.skillsync.dto.UserSearchResponseDTO;

import jakarta.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final SkillService skillService;

    @Autowired
    public UserController(UserService userService, SkillService skillService) {
        this.userService = userService;
        this.skillService = skillService;
    }

    // Save user
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User savedUser = userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
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

    //update User by id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        try {
            User updatedUser = userService.updateUser(id, userUpdateDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            if (e.getMessage().equals("User Not Found")) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            throw e;
        }
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
    public ResponseEntity<List<UserSearchResponseDTO>> searchUsers(@RequestParam("query") String query) {
        
        // 1. Call the service layer to get matching User entities
        List<User> matchingUsers = userService.searchUsers(query);

        // 2. Map the User entities to the required DTO structure
        List<UserSearchResponseDTO> response = matchingUsers.stream()
                .map(UserSearchResponseDTO::fromEntity) // Use the static mapper
                .collect(Collectors.toList());

        // 3. Return the 200 OK response. Returns [] if no users match.
        return ResponseEntity.ok(response);
    }

}
