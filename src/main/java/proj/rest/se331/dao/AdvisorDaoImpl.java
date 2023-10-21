package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.repository.AdvisorRepository;
import proj.rest.se331.repository.StudentRepository;

@Repository
@RequiredArgsConstructor
public class AdvisorDaoImpl implements AdvisorDao {
    final AdvisorRepository advisorRepository;
    final StudentRepository studentRepository;
    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page){
        return advisorRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Advisor getAdvisor(Long id){
        return advisorRepository.findById(id).orElse(null);
    }
    @Override
    public Advisor save(Advisor advisor){
        return advisorRepository.save(advisor);
    }
    @Override
    public Page<Advisor> getAdvisors(String query, Pageable page){
        return advisorRepository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(query,query,page);
    }

}
