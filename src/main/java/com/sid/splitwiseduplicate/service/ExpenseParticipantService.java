package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.ExpenseParticipant;
import com.sid.splitwiseduplicate.repository.ExpenseParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseParticipantService {

    private final ExpenseParticipantRepository expenseParticipantRepository;

    @Autowired
    public ExpenseParticipantService(ExpenseParticipantRepository expenseParticipantRepository) {
        this.expenseParticipantRepository = expenseParticipantRepository;
    }

    /**
     * Create Operations
     */
    public void addExpenseParticipant(ExpenseParticipant expenseParticipant) {
        expenseParticipantRepository.save(expenseParticipant);
    }

    /**
     * Read Operations
     */
    public ExpenseParticipant getExpenseParticipantById(Long id) {
        return expenseParticipantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExpenseParticipant not found with id: "
                        + id));
    }

    public ExpenseParticipant getExpenseParticipantByUsername(String username) {
        return expenseParticipantRepository.findByCircleMemberUserUsername(username)
                .orElseThrow(() -> new RuntimeException("ExpenseParticipant not found for user: "
                        + username));
    }

    /**
     * Update Operations
     */
    public ExpenseParticipant updateExpenseParticipant(ExpenseParticipant expenseParticipant) {
        ExpenseParticipant existingExpenseParticipant = getExpenseParticipantById(expenseParticipant.getId());
        if (existingExpenseParticipant != null) {
            existingExpenseParticipant.setShare(expenseParticipant.getShare());
            existingExpenseParticipant.setSettled(expenseParticipant.getSettled());
            return expenseParticipantRepository.save(existingExpenseParticipant);
        }
        return null;
    }

    /**
     * Delete Operations
     */
    public void deleteExpenseParticipantById(Long id) {
        ExpenseParticipant existingExpenseParticipant = getExpenseParticipantById(id);
        if (existingExpenseParticipant != null) {
            expenseParticipantRepository.delete(existingExpenseParticipant);
        } else {
            throw new RuntimeException("ExpenseParticipant not found with id: " + id);
        }
    }
}
