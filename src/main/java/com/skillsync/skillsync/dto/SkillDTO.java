package com.skillsync.skillsync.dto;

import com.skillsync.skillsync.model.Skill;

public class SkillDTO {
    private Long id;
    private String name;
    private String description;

    // Static mapper to convert Entity to DTO
    public static SkillDTO fromEntity(Skill skill) {
        SkillDTO dto = new SkillDTO();
        // Assuming Skill.getId() maps to skill_id, and so on
        dto.id = skill.getId(); 
        dto.name = skill.getName();
        dto.description = skill.getDescription();
        return dto;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}