package proj.rest.se331.service;

import org.springframework.data.domain.Page;
import proj.rest.se331.entity.Student;

public interface StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
}
