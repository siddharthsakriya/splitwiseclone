package com.sid.splitwiseduplicate.service;

import com.sid.splitwiseduplicate.model.UserGroup;
import com.sid.splitwiseduplicate.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<UserGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    public UserGroup getGroupById(Long id) {
        var group = groupRepository.findById(id);
        return group.orElse(null);
    }

    public UserGroup createGroup(UserGroup userGroup) {
        return groupRepository.save(userGroup);
    }

    public UserGroup updateGroup(UserGroup userGroup) {
        return groupRepository.save(userGroup);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
