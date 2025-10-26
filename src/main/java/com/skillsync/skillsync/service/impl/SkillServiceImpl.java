package com.skillsync.skillsync.service.impl;

import java.util.*;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import com.skillsync.skillsync.repository.SkillRepository;
import com.skillsync.skillsync.repository.UserRepository;
import com.skillsync.skillsync.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    final private UserRepository userRepository;
    final private SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository,UserRepository userRepository){
        this.skillRepository=skillRepository;
        this.userRepository=userRepository;
    }

    @Override
    public List<Skill> getSkillsByUserId(Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            return List.of();
        }
        User user = userOpt.get();
        List<Skill> skills = skillRepository.findByUser(user);
        return skills.isEmpty() ? List.of() : skills;
    }

}
