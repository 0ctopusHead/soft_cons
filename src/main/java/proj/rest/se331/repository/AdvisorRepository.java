package proj.rest.se331.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor,Long> {
    Page<Advisor> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String name, String surname, Pageable pageRequest);
}
