package com.skillsync.skillsync.dto;

import com.skillsync.skillsync.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter
@Getter
public class SkillDTO {
    private Long id;
    private String name;
    private String description;

    public static SkillDTO fromEntity(Skill skill) {
        SkillDTO dto = new SkillDTO();
        // Assuming Skill.getId() maps to skill_id, and so on
        dto.id = skill.getId();
        dto.name = skill.getName();
        dto.description = skill.getDescription();
        return dto;
    }
}