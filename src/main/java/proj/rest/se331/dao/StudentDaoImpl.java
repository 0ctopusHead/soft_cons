package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Student;
import proj.rest.se331.repository.AdvisorRepository;
import proj.rest.se331.repository.StudentRepository;
@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoImpl implements StudentDao {
    final StudentRepository studentRepository;
    final AdvisorRepository advisorRepository;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentRepository.findAll(PageRequest.of(page-1,pageSize));
    }
    @Override
    public  Page<Student> getStudents(String query, Pageable page){
        return studentRepository.findByStudentIDContainingOrNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(query,query,query,page);
    }
    @Override
    public Student getStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }
    @Override
    public Student save(Student student){

        return studentRepository.save(student);
    }
    @Override
    public Student editStudentAdvisor(Student student){
        Advisor advisor = advisorRepository.findById(student.getAdvisor().getId()).orElse(null);
        student.setAdvisor(advisor);
        return studentRepository.save(student);
    }


}
