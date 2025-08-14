package com.sid.splitwiseduplicate.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")

public class User  {

    @Getter @Setter @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id ;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
