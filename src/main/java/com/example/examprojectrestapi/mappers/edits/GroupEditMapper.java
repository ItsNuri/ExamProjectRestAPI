package com.example.examprojectrestapi.mappers.edits;

import com.example.examprojectrestapi.dto.group.GroupRequest;
import com.example.examprojectrestapi.models.Group;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GroupEditMapper {

    public Group create(GroupRequest request) {

        if(request == null) {
            return null;
        }

        Group group = new Group();
        group.setGroupName(request.getGroupName());
        group.setDateOfStart(request.getDateOfStart());
        group.setDateOfFinish(request.getDateOfFinish());
        group.setCreatedDate(LocalDate.now());
        group.setActive(true);

        return group;
    }

    public void update(Group group, GroupRequest request) {
        group.setGroupName(request.getGroupName());
        group.setDateOfStart(request.getDateOfStart());
        group.setDateOfFinish(request.getDateOfFinish());
    }
}
