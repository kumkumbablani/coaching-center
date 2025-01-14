package com.coaching.center.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class Message {
    public static final String MSG_EMPTY_COURSE_NAME = "Course Name cannot be empty";
    public static final String MSG_EMPTY_COURSE_DESC = "Course Description cannot be empty";

    public static final String MSG_EMPTY_STUDENT_NAME = "Student full name cannot be empty.";
    public static final String MSG_EMPTY_STUDENT_EMAIL = "Email cannot be empty.";
    public static final String MSG_INVALID_EMAIL_FORMAT = "Invalid email format.";
    public static final String MSG_EMPTY_STUDENT_DOB = "Date of birth cannot be empty.";
    public static final String MSG_INVALID_STUDENT_DOB = "Date of birth must be a valid past date.";
    public static final String MSG_EMPTY_CONTACT_NUMBER = "Contact number cannot be empty.";
    public static final String MSG_INVALID_CONTACT_NUMBER = "Contact number must be a valid 10-digit number.";

    public static final String MSG_VALID_CONTACT_NUMBER = "Contact number is valid";
    public static final String MSG_INVALID_STUDENT_ID = "Course ID must be a valid number.";
    public static final String MSG_INVALID_COURSE_ID = "Course ID must be a valid number.";
    public static final String MSG_EMPTY_STUDENT_ADDRESS = "Address cannot be empty.";

    public static boolean validateContactNumber(String contactNumber) {
        return !StringUtils.isEmpty(contactNumber) && contactNumber.matches("\\d{10}");
    }
}
