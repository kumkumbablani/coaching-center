package com.coaching.center.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Student {
        private Long studentId;
        private String fullName;
        private LocalDate dateOfBirth;
        private String contactNumber;
        private String email;
        private String address;
        private LocalDate registrationDate = LocalDate.now();
    }

