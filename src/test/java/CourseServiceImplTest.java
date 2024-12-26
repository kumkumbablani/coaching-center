import com.coaching.center.model.Course;
import com.coaching.center.repository.CourseRepository;
import com.coaching.center.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {
    @InjectMocks
    private CourseServiceImpl courseService;
    @Mock
    private CourseRepository courseRepository;

    @Test
    public void test_createCourse_success() {
        // given
        String id = "101";
        Course course = Course.builder()
                .name("JAVA")
                .description("JAVA Description")
                .build();

        // when
        doReturn(id).when(courseRepository).createCourse(course);

        // then
        String response = courseService.createCourse(course);
        assertNotNull(response);
        assertEquals(id, response);
    }

    @Test
    public void test_createCourse_failure_courseNameIsNull() {
        // given
        Course course = Course.builder()
                .name("")
                .description("JAVA Description")
                .build();

        // when
        doThrow(NullPointerException.class).when(courseRepository).createCourse(course);

        // then
        assertThrows(NullPointerException.class, () ->courseService.createCourse(course));
    }
}
