package proj.rest.se331.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Files;

public interface AnnouncementRepository extends JpaRepository<Files,Long>{
    Page<Files> findByAdvisor_Id(Long id, Pageable pageRequest);
}
