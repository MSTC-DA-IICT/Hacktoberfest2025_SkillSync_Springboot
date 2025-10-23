package com.skillsync.skillsync.service;

import com.skillsync.skillsync.model.Skill;

import java.util.List;

public interface SkillService {

    List<Skill> getSkillsByUserId(Long userId);
}
