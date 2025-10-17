package com.skillsync.skillsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skillsync.skillsync.model.User;

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
}