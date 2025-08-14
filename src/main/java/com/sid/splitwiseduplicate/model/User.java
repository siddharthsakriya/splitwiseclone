package com.sid.splitwiseduplicate.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")

public class User  {

    @Getter @Setter @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String passwordHash;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;

    @Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_groups_junction",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<UserGroup> userGroups = new HashSet<>();

    public User(String username, String passwordHash,  String firstName, String lastName) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public User() {
    }
}
