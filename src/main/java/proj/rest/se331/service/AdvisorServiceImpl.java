package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.AdvisorDao;
import proj.rest.se331.entity.Advisor;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {
    final AdvisorDao advisorDao;
    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page){
        return advisorDao.getAdvisors(pageSize, page);
    }
    @Override
    public Advisor getAdvisor(Long id){
        return advisorDao.getAdvisor(id);
    }
    @Override
    public Advisor save(Advisor advisor){
        return advisorDao.save(advisor);
    }
}
