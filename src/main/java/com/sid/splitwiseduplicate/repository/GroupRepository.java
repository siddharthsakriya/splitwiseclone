package com.sid.splitwiseduplicate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sid.splitwiseduplicate.model.UserGroup;

public interface GroupRepository extends JpaRepository<UserGroup, Long> {
}
