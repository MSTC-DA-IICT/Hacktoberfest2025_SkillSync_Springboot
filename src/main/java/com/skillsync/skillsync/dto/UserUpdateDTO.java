package com.skillsync.skillsync.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    // Add feilds to update user
    // this file helps not to senf all the fields of user entity to update
    private Long id;
    private String email;
    private String bio;
    private String roleType;
    private boolean isAvailableForMentorship;

}
