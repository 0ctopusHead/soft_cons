package proj.rest.se331.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Files;

public interface AnnouncementDao {
    Page<Files> getFiles(Long id, Pageable page);
    Files save(Files files);
}
