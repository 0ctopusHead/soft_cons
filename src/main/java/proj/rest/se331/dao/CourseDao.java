package proj.rest.se331.dao;

import org.springframework.data.domain.Page;
import proj.rest.se331.entity.Course;

public interface CourseDao {
    Page<Course> getCourses(Integer pageSize, Integer page);
    Course getCourse(Long id);
}
