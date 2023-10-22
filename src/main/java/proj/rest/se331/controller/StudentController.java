package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Student;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.service.StudentService;
import proj.rest.se331.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class StudentController {
    final StudentService studentService;
    final AdvisorService advisorService;
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit",required = false)Integer perPage
            , @RequestParam(value = "_page",required = false)Integer page
            , @RequestParam(value = "_query", required = false)String query){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        if(query == null){
            pageOutput = studentService.getStudents(perPage, page);
        }
        else{
            pageOutput =studentService.getStudents(query, PageRequest.of(page - 1, perPage));
        }
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
    @PostMapping("/students/editInformation/{id}")
    public ResponseEntity<?> editStudentInformation(@RequestBody Student student, @PathVariable("id")Long id){
        Student studentDb = studentService.getStudent(id);
        if(!student.getName().isEmpty()){
            studentDb.setName(student.getName());
        }
        if(!student.getStudentID().isEmpty()){
            studentDb.setStudentID(student.getStudentID());
        }
        if(!student.getSurname().isEmpty()){
            studentDb.setSurname(student.getSurname());
        }
        if(!student.getDepartment().isEmpty()){
            studentDb.setDepartment(student.getDepartment());
        }
        if(!student.getImages().isEmpty()){
            studentDb.setImages(student.getImages());
        }
        Student output = studentService.save(studentDb);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }
    @PostMapping("/students/editAdvisor/{id}")
    public ResponseEntity<?> editStudentAdvisor(@RequestBody Student student, @PathVariable("id")Long id){
        Student studentDb = studentService.getStudent(id);
        Advisor advisorDb = advisorService.getAdvisor(student.getAdvisor().getId());
        studentDb.setAdvisor(advisorDb);
        Student output = studentService.save(studentDb);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }
}
