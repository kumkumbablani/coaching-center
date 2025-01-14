package com.coaching.center.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateStudentModel {
    private String name;
    private String address;
    private String email;
    private String contactNumber;
}
