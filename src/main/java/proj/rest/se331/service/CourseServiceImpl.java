package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.CourseDao;
import proj.rest.se331.entity.Course;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    final CourseDao courseDao;
    @Override
    public Page<Course> getCourses(Integer pageSize, Integer page){
        return courseDao.getCourses(pageSize,page);
    }
    @Override
    public Course getCourse(Long id){
        return courseDao.getCourse(id);
    }
}
