package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.se331.entity.Student;
import proj.rest.se331.service.StudentService;
import proj.rest.se331.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit",required = false)Integer perPage,@RequestParam(value = "_page",required = false)Integer page){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        pageOutput = studentService.getStudents(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDTO(pageOutput.getContent())
                ,responseHeader, HttpStatus.OK);
    }
    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id")Long id){
        Student output = studentService.getStudent(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not exist");
        }
    }
    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        Student output = studentService.save(student);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }
    @PostMapping("/students/edit/{id}")
    public ResponseEntity<?> editStudent(@RequestBody Student student, @PathVariable("id")Long id){
        Student studentDb = studentService.getStudent(id);
        if(student.getName() != null){
            studentDb.setName(student.getName());
        }
        if(student.getStudentID() != null){
            studentDb.setStudentID(student.getStudentID());
        }
        if(student.getSurname() != null){
            studentDb.setSurname(student.getSurname());
        }
        if(student.getDepartment() != null){
            studentDb.setDepartment(student.getDepartment());
        }
        if(student.getImages() != null){
            studentDb.setImages(student.getImages());
        }
        Student output = studentService.save(studentDb);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }
}
