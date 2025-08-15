package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.Circle;
import com.sid.splitwiseduplicate.model.CircleMember;
import com.sid.splitwiseduplicate.repository.CircleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleService {

    private final CircleRepository circleRepository;
    private final CircleMemberService circleMemberService;

    @Autowired
    public CircleService(CircleRepository circleRepository, CircleMemberService circleMemberService) {
        this.circleRepository = circleRepository;
        this.circleMemberService = circleMemberService;
    }

    /**
     * Create Operations
     */
    @Transactional
    public Circle addCircle(Circle circle) {
        Circle createdCircle = circleRepository.save(circle);
        circleMemberService.addCircleMember(new CircleMember(
                createdCircle.getCreatedBy(),
                createdCircle,
                true
        ));
        return createdCircle;
    }

    /**
     * Read Operations
     */
    public List<Circle> findAll() {
        return circleRepository.findAll();
    }

    public Circle findById(Long id) {
        return circleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Circle not found with id: " + id));
    }

    /**
     * Update Operations
     */
    public Circle updateCircle(Circle circle) {
        Circle existingCircle = findById(circle.getId());
        if (existingCircle != null) {
            existingCircle.setName(circle.getName());
            existingCircle.setDescription(circle.getDescription());
            return circleRepository.save(existingCircle);
        }
        return null;
    }

    /**
     * Delete Operations
     */
    public void deleteCircleById(Long id) {
        circleRepository.deleteById(id);
    }

    public void deleteAllCircles() {
        circleRepository.deleteAll();
    }

}
