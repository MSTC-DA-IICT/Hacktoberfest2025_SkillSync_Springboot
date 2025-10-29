package com.skillsync.skillsync.repository;

import com.skillsync.skillsync.model.Skill;
import com.skillsync.skillsync.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Future custom queries like findBySkillName can be added here
    List<Skill> findByUser(User user);
}
