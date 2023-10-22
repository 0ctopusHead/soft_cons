package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.se331.entity.Course;
import proj.rest.se331.service.CourseService;
import proj.rest.se331.util.LabMapper;

@Controller
@RequiredArgsConstructor
public class CourseController {
    final CourseService courseService;
    @GetMapping("courses")
    public ResponseEntity<?> getCourseLists(@RequestParam(value = "_limit",required = false)Integer perPage, @RequestParam(value = "_page",required = false)Integer page){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Course> pageOutput;
        pageOutput = courseService.getCourses(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return  new ResponseEntity<>(LabMapper.INSTANCE.getCourseDTO(pageOutput.getContent())
        ,responseHeader, HttpStatus.OK);
    }
    @GetMapping("courses/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id")Long id){
        Course output = courseService.getCourse(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getCourseDTO(output));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not exist");
        }
    }
}
