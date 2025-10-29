package com.skillsync.skillsync.service.impl;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.repository.SkillRepository;
import com.skillsync.skillsync.repository.UserRepository;
import com.skillsync.skillsync.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final UserRepository userRepository;
    private final SkillRepository skillRepository;

    @Override
    public List<Skill> getSkillsByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(skillRepository::findByUser)
                .orElse(Collections.emptyList());
    }

}
