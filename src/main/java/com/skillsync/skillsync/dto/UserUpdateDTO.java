package com.skillsync.skillsync.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class UserUpdateDTO {
    
    @NotBlank(message = "Name is required")
    private String name;
    
    private String bio;
    
    @Valid
    private List<SkillDTO> skills;

    // Constructors
    public UserUpdateDTO() {
    }

    public UserUpdateDTO(String name, String bio, List<SkillDTO> skills) {
        this.name = name;
        this.bio = bio;
        this.skills = skills;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillDTO> skills) {
        this.skills = skills;
    }
}
