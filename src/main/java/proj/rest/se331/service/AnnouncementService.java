package proj.rest.se331.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Files;

public interface AnnouncementService {
    Page<Files> getFiles(Long id, Pageable page);
    Files save(Files files);
}
