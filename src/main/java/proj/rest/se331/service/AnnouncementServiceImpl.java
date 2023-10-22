package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.AnnouncementDao;
import proj.rest.se331.entity.Files;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    final AnnouncementDao announcementDao;
    @Override
    public Page<Files> getFiles(Long id, Pageable page){
        return announcementDao.getFiles(id,page);
    }
    @Override
    public Files save(Files files){
        return announcementDao.save(files);
    }
}
