package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Student;
import proj.rest.se331.repository.StudentRepository;
@Repository
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDao {
    final StudentRepository studentRepository;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentRepository.findAll(PageRequest.of(page-1,pageSize));
    }
    @Override
    public Student getStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }
}
