package com.skillsync.skillsync.service;

import java.util.List;

import com.skillsync.skillsync.model.Skill;

public interface SkillService {

    List<Skill> getSkillsByUserId(Long userId);
}
