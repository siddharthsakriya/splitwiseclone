package com.sid.splitwiseduplicate.repository;

import com.sid.splitwiseduplicate.model.ExpenseParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<ExpenseParticipant, Long> {

}
