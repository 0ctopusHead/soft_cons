package proj.rest.se331.service;

import org.springframework.data.domain.Page;
import proj.rest.se331.entity.Advisor;

public interface AdvisorService {
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Long id);
}
