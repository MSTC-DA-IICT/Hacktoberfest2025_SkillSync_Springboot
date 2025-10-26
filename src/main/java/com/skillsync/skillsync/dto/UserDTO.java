package com.skillsync.skillsync.dto;


import com.skillsync.skillsync.model.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String bio;
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.LEARNER;
    private boolean availableForMentorship;
    private List<SkillDTO> skills;

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public RoleType getRoleType() { return roleType; }
    public void setRoleType(RoleType roleType) { this.roleType = roleType; }

    public boolean isAvailableForMentorship() { return availableForMentorship; }
    public void setAvailableForMentorship(boolean availableForMentorship) {
        this.availableForMentorship = availableForMentorship;
    }

    public List<SkillDTO> getSkills() { return skills; }
    public void setSkills(List<SkillDTO> skills) { this.skills = skills; }
}
