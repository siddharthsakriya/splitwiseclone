package com.sid.splitwiseduplicate.repository;

import com.sid.splitwiseduplicate.model.ExpenseParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpenseParticipantRepository extends JpaRepository<ExpenseParticipant, Long> {
    Optional<ExpenseParticipant> findByCircleMemberUserUsername(String username);
}
