package com.sid.splitwiseduplicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Expense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String description;

    @Column(nullable = false)
    @Getter @Setter
    private double amount;

    @Getter @Setter
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circle_id", nullable = false)
    @Getter @Setter
    private Circle circle;

    @OneToMany(mappedBy = "expense", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Getter @Setter
    private List<ExpenseParticipant> expenseParticipants;

    public Expense() {}

    public Expense(String description, double amount, LocalDate date, User user, Circle circle) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.user = user;
        this.circle = circle;
    }
}
