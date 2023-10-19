package proj.rest.se331.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Student;

public interface StudentDao {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(String query, Pageable page);
    Student getStudent(Long id);
    Student save(Student student);
    Student editStudentAdvisor(Student student);

}
