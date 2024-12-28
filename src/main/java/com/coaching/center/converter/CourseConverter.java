package com.coaching.center.converter;

import com.coaching.center.entity.CourseEntity;
import com.coaching.center.model.Course;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseConverter {

    public static CourseEntity convert(Course course) {
        return CourseEntity.builder()
                .name(course.getName())
                .description(course.getDescription())
                .build();
    }

    public static Course convert(CourseEntity courseEntity) {
        return Course.builder()
                .id(courseEntity.getId())
                .name(courseEntity.getName())
                .description(courseEntity.getDescription())
                .build();
    }
}
