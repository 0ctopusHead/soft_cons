package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Course;
import proj.rest.se331.repository.CourseRepository;

@Repository
@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDao {
    final CourseRepository courseRepository;
    @Override
    public Page<Course> getCourses(Integer pageSize, Integer page){
        return courseRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Course getCourse(Long id){
        return courseRepository.findById(id).orElse(null);
    }
}
