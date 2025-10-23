package com.skillsync.skillsync.service.impl;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private Skill skill;
    private List<User> userList;
    private List<Skill> skillList;

    @BeforeEach
    void setUp() {
        // Initialize test data
        skill = new Skill();
        skill.setName("Java");

        user = new User();
        user.setId(1L);
        user.setName("Alice");
        user.setEmail("alice@example.com");
        user.setBio("Software Engineer");
        user.setSkills(Collections.singletonList(skill));

        userList = Collections.singletonList(user);
        skillList = Collections.singletonList(skill);
    }


    @Test
    void getAllUsers_ShouldReturnUserList() {
        // Arrange
        when(userRepository.findAll()).thenReturn(userList);

        // Act
        List<User> result = userService.getAllUsers();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void getUserById_WhenUserExists_ShouldReturnUser() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        User result = userService.getUserById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Alice", result.getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserById_WhenUserNotFound_ShouldThrowRuntimeException() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.getUserById(1L));
        assertEquals("User Not Found", exception.getMessage());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void updateUser_WhenUserExists_ShouldUpdateAndReturnUser() {
        // Arrange
        User updatedInput = new User();
        updatedInput.setName("Bob");
        updatedInput.setEmail("bob@example.com");
        updatedInput.setBio("Updated Bio");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User result = userService.updateUser(1L, updatedInput);

        // Assert
        assertNotNull(result);
        assertEquals("Bob", result.getName());
        assertEquals("bob@example.com", result.getEmail());
        assertEquals("Updated Bio", result.getBio());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void updateUser_WhenUserNotFound_ShouldThrowRuntimeException() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.updateUser(1L, user));
        assertEquals("User Not Found", exception.getMessage());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, never()).save(any());
    }


    @Test
    void addSkillToUser_WhenUserNotFound_ShouldThrowRuntimeException() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.addSkillToUser(1L, skill));
        assertEquals("User Not Found", exception.getMessage());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, never()).save(any());
    }

    @Test
    void getUsersBySkill_ShouldReturnUsersWithMatchingSkill() {
        // Arrange
        when(userRepository.findBySkillsNameContainingIgnoreCase("Java")).thenReturn(userList);

        // Act
        List<User> result = userService.getUsersBySkill("Java");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
        verify(userRepository, times(1)).findBySkillsNameContainingIgnoreCase("Java");
    }

    @Test
    void searchUsers_WithValidQuery_ShouldReturnMatchingUsers() {
        // Arrange
        when(userRepository.searchUsers("Alice")).thenReturn(userList);

        // Act
        List<User> result = userService.searchUsers("Alice");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Alice", result.get(0).getName());
        verify(userRepository, times(1)).searchUsers("Alice");
    }

    @Test
    void searchUsers_WithBlankQuery_ShouldReturnEmptyList() {
        // Act
        List<User> result = userService.searchUsers(" ");

        // Assert
        assertTrue(result.isEmpty());
        verify(userRepository, never()).searchUsers(anyString());
    }

    @Test
    void searchUsers_WithNullQuery_ShouldReturnEmptyList() {
        // Act
        List<User> result = userService.searchUsers(null);

        // Assert
        assertTrue(result.isEmpty());
        verify(userRepository, never()).searchUsers(anyString());
    }

    @Test
    void getUserSkills_WhenUserExists_ShouldReturnSkillList() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        List<Skill> result = userService.getUserSkills(1L);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Java", result.get(0).getName());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void getUserSkills_WhenUserNotFound_ShouldThrowRuntimeException() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.getUserSkills(1L));
        assertEquals("User Not Found", exception.getMessage());
        verify(userRepository, times(1)).findById(1L);
    }
}