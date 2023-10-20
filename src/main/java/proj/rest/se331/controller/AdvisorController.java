package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdvisorController {
    final AdvisorService advisorService;
    @GetMapping("advisors")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit",required = false)Integer perPage, @RequestParam(value = "_page", required = false)Integer page){
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Advisor> pageOutput;
        pageOutput = advisorService.getAdvisors(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAdvisorDTO(pageOutput.getContent())
        ,responseHeader, HttpStatus.OK);
    }
    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable("id")Long id){
        Advisor output = advisorService.getAdvisor(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not exist");
        }
    }
    @PostMapping("/advisors")
    public ResponseEntity<?> addAdvisor(@RequestBody Advisor advisor){
        Advisor output = advisorService.save(advisor);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));
    }
    @PostMapping("/advisors/edit/{id}")
    public ResponseEntity<?> edit(@RequestBody Advisor advisor, @PathVariable("id")Long id){
        Advisor advisorDb = advisorService.getAdvisor(id);
        if(!advisor.getName().isEmpty()){
            advisorDb.setName(advisor.getName());
        }
        if(!advisor.getSurname().isEmpty()){
            advisorDb.setSurname(advisor.getSurname());
        }
        if(!advisor.getAcademicPosition().isEmpty()){
            advisorDb.setAcademicPosition(advisor.getAcademicPosition());
        }
        if(!advisor.getImages().isEmpty()){
            advisorDb.setImages(advisor.getImages());
        }
        Advisor output = advisorService.save(advisorDb);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));
    }
}
