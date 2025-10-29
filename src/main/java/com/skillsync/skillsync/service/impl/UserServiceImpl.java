package com.skillsync.skillsync.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import com.skillsync.skillsync.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import com.skillsync.skillsync.dto.SkillMapper;
import com.skillsync.skillsync.dto.UserMapper;
import com.skillsync.skillsync.dto.UserUpdateDTO;
import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.UserRepository;
import com.skillsync.skillsync.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{   
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final SkillMapper skillMapper;

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
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }


    // Update User
    @Override
    public User updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        // TODO: Fetch existing user by ID
        // TODO: Update only provided fields
        // TODO: Save and return updated user
        User existingUser = getUserById(id);

        UserUpdateDTO existingDto = userMapper.fromEntityToDto(existingUser);

        UserUpdateDTO.UserUpdateDTOBuilder builder = UserUpdateDTO.builder();
        ofNullable(existingDto.getBio()).ifPresent(builder::bio);
        ofNullable(existingDto.getName()).ifPresent(builder::name);
        if (!CollectionUtils.isEmpty(userUpdateDTO.getSkills())) {
            builder.skills(userUpdateDTO.getSkills());
        }
        UserUpdateDTO updateDTO = builder.build();
        User updatedUser = userMapper.fromDtoToEntity(updateDTO);

        updatedUser.setId(existingUser.getId());
        if (!CollectionUtils.isEmpty(updateDTO.getSkills())) {
            updatedUser.getSkills().clear();
            User finalUpdatedUser = updatedUser;
            List<Skill> updatedSkills = updateDTO.getSkills().stream()
                    .map(skillMapper::fromDtoToEntity)
                    .peek(skill -> skill.setUser(finalUpdatedUser))
                    .toList();
            updatedUser.setSkills(updatedSkills);
        }
        updatedUser = userRepository.save(updatedUser);
        return updatedUser;
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
