package com.coaching.center.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Student {
        private Long id;
        private String name;
        private LocalDate dateOfBirth;
        private String contactNumber;
        private String email;
        private String address;
    }

