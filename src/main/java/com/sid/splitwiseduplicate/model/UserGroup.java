package com.sid.splitwiseduplicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_groups")

public class UserGroup {
    @Getter @Setter @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @Getter @Setter
    @ManyToMany(mappedBy = "allUserGroups", fetch = FetchType.LAZY)
    private Set<User> members = new HashSet<>();

    public UserGroup() {}

    public UserGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
