package com.sid.splitwiseduplicate.repository;

import com.sid.splitwiseduplicate.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
