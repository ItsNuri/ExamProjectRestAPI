package com.example.examprojectrestapi.apis;

import com.example.examprojectrestapi.dto.group.GroupRequest;
import com.example.examprojectrestapi.dto.group.GroupResponse;
import com.example.examprojectrestapi.dto.SimpleResponse;
import com.example.examprojectrestapi.models.Group;
import com.example.examprojectrestapi.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {

    private final GroupService groupService;

    //find all
    @GetMapping
    public List<GroupResponse> findAll() {
        return groupService.findAll();
    }

    //find by id
    @PostMapping("/find/{groupId}")
    public GroupResponse findById(@PathVariable Long groupId) {
        return groupService.findById(groupId);
    }

    //save
    @PostMapping
    public GroupResponse save(@RequestBody GroupRequest groupSaveRequest) {
        return groupService.save(groupSaveRequest);
    }

    //delete
    @DeleteMapping("/delete/{groupId}")
    public SimpleResponse deleteGroupById(@PathVariable Long groupId) {
        return groupService.deleteById(groupId);
    }

    //update
    @PutMapping("/update/{groupId}")
    public GroupResponse updateGroupById(@PathVariable Long groupId,
                                 @RequestBody GroupRequest groupSaveRequest) {
        return groupService.updateById(groupId,groupSaveRequest);
    }
}
