package com.sid.splitwiseduplicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private  String firstName;

    @Getter @Setter
    private String lastName;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String passwordHashed;

    @Getter @Setter
    private LocalDateTime createdAt;

    @OneToMany (mappedBy = "participant", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<ExpenseParticipant> expenseParticipants;

    public User() {};

    public User(String username, String firstName, String lastName, String email, String passwordHashed) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHashed = passwordHashed;
        this.createdAt = LocalDateTime.now();
    }
}
