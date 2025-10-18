package com.skillsync.skillsync.dto;

import com.skillsync.skillsync.model.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserSearchResponseDTO {
    private Long id;
    private String name;
    private String bio;
    private List<SkillDTO> skills; // List of DTOs

    // Static mapper to convert Entity to DTO
    public static UserSearchResponseDTO fromEntity(User user) {
        UserSearchResponseDTO dto = new UserSearchResponseDTO();
        dto.id = user.getId();
        dto.name = user.getName();
        dto.bio = user.getBio();
        
        // Map List<Skill> to List<SkillDTO>
        dto.skills = user.getSkills().stream()
                .map(SkillDTO::fromEntity)
                .collect(Collectors.toList());
                
        return dto;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public List<SkillDTO> getSkills() { return skills; }
    public void setSkills(List<SkillDTO> skills) { this.skills = skills; }
}