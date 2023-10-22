package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Files;
import proj.rest.se331.repository.AnnouncementRepository;

@Repository
@RequiredArgsConstructor
public class AnnouncementDaoImpl implements AnnouncementDao {
    final AnnouncementRepository announcementRepository;
    @Override
    public Page<Files> getFiles(Long id, Pageable page){
        return announcementRepository.findByAdvisor_Id(id,page);
    }
    @Override
    public Files save(Files files){
        return announcementRepository.save(files);
    }

}
