package com.sid.splitwiseduplicate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ExpenseParticipant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_id", nullable = false)
    @Getter @Setter
    private Expense expense;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "circle_member_id", nullable = false)
    @Getter @Setter
    private CircleMember circleMember;

    @Getter @Setter
    private double amount;

    @Getter @Setter
    private double share;

    @Getter @Setter
    private Boolean settled;

    public ExpenseParticipant() {}

    public ExpenseParticipant(Expense expense, CircleMember circleMember, double amount, double share, Boolean settled) {
        this.expense = expense;
        this.circleMember = circleMember;
        this.amount = amount;
        this.share = share;
        this.settled = settled;
    }
}
