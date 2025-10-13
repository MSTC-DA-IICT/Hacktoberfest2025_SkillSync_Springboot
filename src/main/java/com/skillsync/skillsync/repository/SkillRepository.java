package com.skillsync.skillsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillsync.skillsync.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Future custom queries like findBySkillName can be added here
}
