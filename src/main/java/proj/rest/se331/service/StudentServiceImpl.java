package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.AdvisorDao;
import proj.rest.se331.dao.StudentDao;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    final AdvisorDao advisorDao;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentDao.getStudents(pageSize,page);
    }
    @Override
    public Page<Student> getStudents(String query, Pageable page){
        return studentDao.getStudents(query,page);
    }
    @Override
    public Student getStudent(Long id){
        return studentDao.getStudent(id);
    }
    @Override
    public Student save(Student student){
        return  studentDao.save(student);
    }
    @Override
    public Student editStudentAdvisor(Student student){
        return studentDao.editStudentAdvisor(student);
    }
    @Override
    public Page<Student> getStudentByAdvisorId(Long id, Pageable page){
        return studentDao.getStudentByAdvisorId(id,page);
    }
}
