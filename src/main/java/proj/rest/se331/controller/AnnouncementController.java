package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Files;
import proj.rest.se331.request.AnnouncementRequest;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.service.AnnouncementService;
import proj.rest.se331.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnnouncementController {
    final AnnouncementService announcementService;
    final AdvisorService advisorService;

    @GetMapping("/announcement/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable("id")Long id
            ,@RequestParam(value = "_limit",required = false)Integer perPage
            ,@RequestParam(value = "_page",required = false)Integer page){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Files> pageOutput = announcementService.getFiles(id, PageRequest.of(page - 1 , perPage));
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getFileDTO(pageOutput.getContent())
        ,responseHeader, HttpStatus.OK);
    }
    @PostMapping("/createAnnouncement/{id}")
    public ResponseEntity<?> announcement(@RequestBody AnnouncementRequest request, @PathVariable("id")Long id) {
        Advisor advisor = advisorService.getAdvisor(id);
        Files fileDb = Files.builder()
                .files(List.of(request.getFile()))
                .content(request.getContent())
                .build();
        fileDb.setAdvisor(advisor);
        advisor.setFiles(List.of(fileDb));
        Files output = announcementService.save(fileDb);
        return ResponseEntity.ok(LabMapper.INSTANCE.getFileDTO(output));
    }
}
