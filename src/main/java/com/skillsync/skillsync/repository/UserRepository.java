package com.skillsync.skillsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillsync.skillsync.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be added later, e.g. findByEmail, findBySkillName,
    // etc.
    @Query("SELECT DISTINCT u FROM User u " +
           "LEFT JOIN u.skills s " + 
           "WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(u.bio) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(s.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<User> searchUsers(@Param("query") String query);
    
    // Find users by skill name (case-insensitive)
    @Query("SELECT DISTINCT u FROM User u " +
           "JOIN u.skills s " +
           "WHERE LOWER(s.name) = LOWER(:skillName)")
    List<User> findBySkillNameIgnoreCase(@Param("skillName") String skillName);
}