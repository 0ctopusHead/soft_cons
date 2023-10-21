package proj.rest.se331.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Advisor;

public interface AdvisorService {
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Page<Advisor> getAdvisors(String query, Pageable page);
    Advisor getAdvisor(Long id);
    Advisor save(Advisor advisor);
}
