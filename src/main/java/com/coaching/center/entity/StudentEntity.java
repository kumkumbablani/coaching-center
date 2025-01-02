package com.coaching.center.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "address")
})
public class StudentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long studentId;

        @Column(nullable = false, length = 100)
        private String fullName;

        @Column(nullable = false)
        private LocalDate dateOfBirth;

        @Column(nullable = false, unique = true, length = 15)
        private String contactNumber;

        @Column(nullable = false, unique = true, length = 100)
        private String email;

        @Column
        private String address;

        @Column(nullable = false)
        private LocalDate registrationDate = LocalDate.now();
    }

