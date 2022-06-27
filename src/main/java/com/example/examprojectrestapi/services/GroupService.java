package com.example.examprojectrestapi.services;

import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.dto.group.GroupRequest;
import com.example.examprojectrestapi.dto.group.GroupResponse;
import com.example.examprojectrestapi.exceptions.GroupNotFoundException;
import com.example.examprojectrestapi.mappers.edits.GroupEditMapper;
import com.example.examprojectrestapi.mappers.views.GroupViewMapper;
import com.example.examprojectrestapi.models.Group;
import com.example.examprojectrestapi.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    private final GroupViewMapper groupViewMapper;

    private final GroupEditMapper groupEditMapper;

//    private Group getGroupById(Long groupId) {
//        return groupRepository.findById(groupId).orElseThrow(
//                () -> new GroupNotFoundException(groupId)
//        );
//    }

    //find all
    public List<GroupResponse> findAll() {
        return groupViewMapper.view(groupRepository.findAll());
    }

    //find by id
    public GroupResponse findById(Long groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new GroupNotFoundException("My Exception: Couldn't not fount group!")
        );
        return groupViewMapper.viewGroup(group);
    }

    //save
    public GroupResponse save(GroupRequest groupRequest) {
        Group group = groupEditMapper.create(groupRequest);
        groupRepository.save(group);
        return groupViewMapper.viewGroup(group);
    }

    //delete by id
    public SimpleResponse deleteById(Long groupId) {

        boolean exists = groupRepository.existsById(groupId);

        if(!exists) {
            throw new GroupNotFoundException("My Exception: Couldn't not found group!");
        }
        groupRepository.deleteById(groupId);

        return new SimpleResponse(
                "DELETED",
                "Successfully deleted group!"
        );
    }

    //update by id
    public GroupResponse updateById(Long groupId, GroupRequest groupRequest) {
        Group group = groupRepository.findById(groupId).get();
        groupEditMapper.update(group, groupRequest);
        groupRepository.save(group);
        return groupViewMapper.viewGroup(groupRepository.save(group));
    }

}
