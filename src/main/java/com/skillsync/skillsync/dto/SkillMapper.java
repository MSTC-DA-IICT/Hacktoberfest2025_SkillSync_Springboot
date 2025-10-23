package com.skillsync.skillsync.dto;

import com.skillsync.skillsync.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillDTO fromEntityToDto(Skill skill);
    Skill fromDtoToEntity(SkillDTO skillDTO);
}
