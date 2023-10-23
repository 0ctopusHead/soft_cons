package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Files;
import proj.rest.se331.entity.Student;
import proj.rest.se331.request.AnnouncementRequest;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.service.AnnouncementService;
import proj.rest.se331.service.StudentService;
import proj.rest.se331.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
    final StudentService studentService;
    final AnnouncementService announcementService;
    final AdvisorService advisorService;

    @GetMapping("/announcement/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable("id")Long id){
        Advisor id_advisor = studentService.getStudent(id).getAdvisor();
        Advisor advisor = advisorService.getAdvisor(id_advisor.getId());
        List<Files> output = announcementService.getFiles(advisor.getId());
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getFileDTO(output));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The advisor does not exist");
        }
    }
    @GetMapping("/advisorAnnouncement/{id}")
    public ResponseEntity<?> getAdvisorAnnouncement(@PathVariable("id")Long id){
        Advisor advisor = advisorService.getAdvisor(id);
        List<Files> output = announcementService.getFiles(advisor.getId());
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getFileDTO(output));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The advisor does not exist");
        }
    }
    @PostMapping("/createAnnouncement/{id}")
    public ResponseEntity<?> announcement(@RequestBody AnnouncementRequest request, @PathVariable("id")Long id) {
        Advisor advisor = advisorService.getAdvisor(id);
        Files fileDb = Files.builder()
                .files(request.getFiles())
                .content(request.getContent())
                .build();
        fileDb.setAdvisor(advisor);
        advisor.setFiles(List.of(fileDb));
        Files output = announcementService.save(fileDb);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFileDTO(output));
    }
}
