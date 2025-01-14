package com.coaching.center.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        private Long id;

        @Column(length = 100)
        private String name;

        @Column(name = "dob")
        private LocalDate dateOfBirth;

        @Column(name = "contact_number" , unique = true, length = 15)
        private String contactNumber;

        @Column(unique = true, length = 100)
        private String email;

        @Column
        private String address;

        @Column(name = "registration_date")
        private LocalDateTime registrationDate;
    }
