package proj.rest.se331.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
