package proj.rest.se331.service;

import org.springframework.data.domain.Page;
import proj.rest.se331.entity.Course;

public interface CourseService {
    Page<Course> getCourses(Integer pageSize, Integer page);
    Course getCourse(Long id);
}
