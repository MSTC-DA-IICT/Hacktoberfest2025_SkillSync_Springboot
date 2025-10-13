package com.skillsync.skillsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillsync.skillsync.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added later, e.g. findByEmail, findBySkillName,
    // etc.
}