package proj.rest.se331.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
}
