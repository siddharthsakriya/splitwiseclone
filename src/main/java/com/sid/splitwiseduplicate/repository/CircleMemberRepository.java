package com.sid.splitwiseduplicate.repository;

import com.sid.splitwiseduplicate.model.CircleMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CircleMemberRepository extends JpaRepository<CircleMember, Long> {
    Optional<CircleMember> findByUserUsername(String username);
}
