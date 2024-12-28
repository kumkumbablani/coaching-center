package com.coaching.center.model;

import lombok.*;


@Data
@Builder
public class Course {
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
