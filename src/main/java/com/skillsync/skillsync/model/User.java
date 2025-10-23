package com.skillsync.skillsync.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String bio;

    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.LEARNER; // default

    private boolean availableForMentorship = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills = new ArrayList<>();

    // Constructors
//    public User() {
//    }

//    // Constructors
//    public User() {
//    }
//
//    public User(String name, String email, String password, String bio, RoleType roleType,
//            boolean availableForMentorship) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.bio = bio;
//        this.roleType = roleType;
//        this.availableForMentorship = availableForMentorship;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return user_id;
//    }
//
//    public void setId(Long id) {
//        this.user_id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public boolean isAvailableForMentorship() {
//        return availableForMentorship;
//    }
//
//    public void setAvailableForMentorship(boolean availableForMentorship) {
//        this.availableForMentorship = availableForMentorship;
//    }
//
//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }

}
