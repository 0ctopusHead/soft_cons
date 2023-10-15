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
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.util.LabMapper;

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
}
