package com.coaching.center.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
