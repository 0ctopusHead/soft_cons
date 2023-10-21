package proj.rest.se331.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Advisor;

import java.util.Optional;

public interface AdvisorDao {
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Page<Advisor> getAdvisors(String query, Pageable page);
    Advisor getAdvisor(Long id);
    Advisor save(Advisor advisor);

}
