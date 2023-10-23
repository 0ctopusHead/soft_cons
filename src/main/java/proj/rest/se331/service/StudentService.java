package proj.rest.se331.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Student;

import java.util.List;

public interface StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(String query, Pageable page);
    Student getStudent(Long id);
    Student save(Student student);
    Student editStudentAdvisor(Student student);
    List<Student> getStudentByAdvisorId(Long id);
}
