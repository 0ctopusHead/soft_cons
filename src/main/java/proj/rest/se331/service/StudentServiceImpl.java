package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.StudentDao;
import proj.rest.se331.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentDao.getStudents(pageSize,page);
    }
    @Override
    public Student getStudent(Long id){
        return studentDao.getStudent(id);
    }
}
