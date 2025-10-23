package com.skillsync.skillsync.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Builder
public class UserUpdateDTO {
    private String name;
    private String bio;
    private List<SkillDTO> skills;
}
