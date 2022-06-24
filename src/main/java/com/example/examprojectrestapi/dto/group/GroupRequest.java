package com.example.examprojectrestapi.dto.group;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GroupRequest {

    private String groupName;

    private Date dateOfStart;

    private Date dateOfFinish;

}
