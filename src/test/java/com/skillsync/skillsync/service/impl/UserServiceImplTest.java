package com.skillsync.skillsync.service.impl;


import com.skillsync.skillsync.dto.SkillDTO;
import com.skillsync.skillsync.dto.SkillMapper;
import com.skillsync.skillsync.dto.SkillMapperImpl;
import com.skillsync.skillsync.dto.UserMapper;
import com.skillsync.skillsync.dto.UserMapperImpl;
import com.skillsync.skillsync.dto.UserUpdateDTO;
import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper = new UserMapperImpl();

    @Spy
    private SkillMapper skillMapper = new SkillMapperImpl();

    @Test
    void testUpdateUser() {
        // arrange
        final Long id = 1L;
        final UserUpdateDTO userUpdateDTO = UserUpdateDTO.builder()
                .name("Piolo")
                .skills(List.of(
                        SkillDTO.builder()
                                .name("Java")
                                .build()
                ))
                .build();
        User user = User.builder()
                .name("Piolo")
                .skills(List.of(Skill.builder()
                        .name("Java")
                        .build()))
                .build();
        when(userRepository.findById(anyLong()))
                .thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);


        // act
        User actual = userService.updateUser(id, userUpdateDTO);

        // assert
        Assertions.assertNotNull(actual);
        Assertions.assertFalse(CollectionUtils.isEmpty(actual.getSkills()));
    }
}