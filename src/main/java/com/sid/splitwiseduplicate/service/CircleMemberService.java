package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.CircleMember;
import com.sid.splitwiseduplicate.repository.CircleMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CircleMemberService {

    private final CircleMemberRepository circleMemberRepository;

    @Autowired
    public CircleMemberService(CircleMemberRepository circleMemberRepository) {
        this.circleMemberRepository = circleMemberRepository;
    }

    /**
     * Create Operations
     */
    public void addCircleMember(CircleMember circleMember) {
        circleMemberRepository.save(circleMember);
    }

    /**
     * Read Operations
     */
    public CircleMember findById(Long id) {
        return circleMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CircleMember not found with id: " + id));
    }


    /**
     * Update Operations
     */
    public CircleMember updateCircleMember(CircleMember circleMember) {
        CircleMember existingCircleMember = findById(circleMember.getId());
        if (existingCircleMember != null) {
            existingCircleMember.setUser(circleMember.getUser());
            existingCircleMember.setCircle(circleMember.getCircle());
            existingCircleMember.setAdmin(circleMember.isAdmin());
            return circleMemberRepository.save(existingCircleMember);
        }
        return null;
    }

    /**
     * Delete Operations
     */
    public void deleteCircleMemberById(Long id) {
        CircleMember existingCircleMember = findById(id);
        if (existingCircleMember != null) {
            circleMemberRepository.delete(existingCircleMember);
        } else {
            throw new RuntimeException("CircleMember not found with id: " + id);
        }
    }

    public void deleteCircleMemberByUsername(String username) {
        CircleMember circleMember = circleMemberRepository.findByUserUsername(username)
                .orElseThrow(() -> new RuntimeException("CircleMember not found with username: " + username));

        circleMemberRepository.delete(circleMember);
    }
}
