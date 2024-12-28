package com.coaching.center.validator;

import com.coaching.center.exception.MissingMandatoryFieldException;
import com.coaching.center.model.Course;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.coaching.center.util.Message.MSG_EMPTY_COURSE_DESC;
import static com.coaching.center.util.Message.MSG_EMPTY_COURSE_NAME;

@UtilityClass
public class CourseValidator {

    public static void validateCourse(Course course) {
        List<String> errors = new ArrayList<>();
        if(StringUtils.isEmpty(course.getName()))
            errors.add(MSG_EMPTY_COURSE_NAME);
        if(StringUtils.isEmpty(course.getDescription()))
            errors.add(MSG_EMPTY_COURSE_DESC);
        if(!errors.isEmpty())
            throw new MissingMandatoryFieldException("Mandatory fields are missing", errors);
    }
}
