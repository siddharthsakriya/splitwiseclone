package com.sid.splitwiseduplicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CircleMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circle_id", nullable = false)
    @Getter @Setter
    private Circle circle;

    @Getter @Setter
    private boolean isAdmin;

    public CircleMember() {}

    public CircleMember(User user, Circle circle, boolean isAdmin) {
        this.user = user;
        this.circle = circle;
        this.isAdmin = isAdmin;
    }
}
