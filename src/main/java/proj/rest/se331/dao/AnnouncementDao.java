package proj.rest.se331.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.rest.se331.entity.Files;

import java.util.List;

public interface AnnouncementDao {
    List<Files> getFiles(Long id);
    Files save(Files files);
}
