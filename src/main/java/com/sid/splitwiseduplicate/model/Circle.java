package com.sid.splitwiseduplicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;

@Entity
public class Circle {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User createdBy;

    @OneToMany(mappedBy = "circle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<CircleMember> circleMembers;

    @OneToMany(mappedBy = "circle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Expense> expenses;


    @Getter @Setter
    private LocalDateTime createdAt;

    public Circle() {}

    public Circle(String name, String description, User createdBy) {
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }
}
