package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Files;
import proj.rest.se331.repository.AnnouncementRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnnouncementDaoImpl implements AnnouncementDao {
    final AnnouncementRepository announcementRepository;
    @Override
    public List<Files> getFiles(Long id){
        return announcementRepository.findByAdvisor_Id(id);
    }
    @Override
    public Files save(Files files){
        return announcementRepository.save(files);
    }

}
