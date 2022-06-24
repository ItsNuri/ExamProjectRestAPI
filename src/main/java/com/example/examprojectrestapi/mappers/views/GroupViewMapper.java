package com.example.examprojectrestapi.mappers.views;

import com.example.examprojectrestapi.dto.group.GroupResponse;
import com.example.examprojectrestapi.models.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }

        GroupResponse response = new GroupResponse();
        response.setId(group.getId());
        response.setGroupName(group.getGroupName());
        response.setDateOfStart(group.getDateOfStart());
        response.setDateOfFinish(group.getDateOfFinish());
        response.setCourses(group.getCourses());
        response.setStudents(group.getStudents());
        response.setCreatedDate(group.getCreatedDate());
        response.setActive(group.isActive());
        return response;
    }

    public List<GroupResponse> view(List<Group> groups) {
        List<GroupResponse> responses = new ArrayList<>();
        for (Group group : groups) {
            responses.add(viewGroup(group));
        }
        return responses;
    }
}
