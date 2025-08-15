package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.Expense;
import com.sid.splitwiseduplicate.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    /**
     * Create Operations
     */
    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    /**
     * Read Operations
     */
    public Expense getExpenseById(Long expenseId) {
        return expenseRepository.findById(expenseId)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: " + expenseId));
    }

    /**
     * Update Operations
     */
    public Expense updateExpense(Expense expense) {
        Expense existingExpense = getExpenseById(expense.getId());
        if (existingExpense != null) {
            existingExpense.setDescription(expense.getDescription());
            existingExpense.setAmount(expense.getAmount());
            return expenseRepository.save(existingExpense);
        }
        return null;
    }
    /**
     * Delete Operations
     */
    public void deleteExpenseById(Long expenseId) {
        Expense existingExpense = getExpenseById(expenseId);
        if (existingExpense != null) {
            expenseRepository.delete(existingExpense);
        } else {
            throw new RuntimeException("Expense not found with id: " + expenseId);
        }
    }

}
