package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.AnnouncementDao;
import proj.rest.se331.entity.Files;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    final AnnouncementDao announcementDao;
    @Override
    public List<Files> getFiles(Long id){
        return announcementDao.getFiles(id);
    }
    @Override
    public Files save(Files files){
        return announcementDao.save(files);
    }
}
