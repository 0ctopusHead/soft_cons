package proj.rest.se331.dao;

import org.springframework.data.domain.Page;
import proj.rest.se331.entity.Student;

public interface StudentDao {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);


}
