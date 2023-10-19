package proj.rest.se331.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    Page<Student> findByStudentIDContainingOrNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String studentID, String name, String surname, Pageable pageRequest);
}
