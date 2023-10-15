package proj.rest.se331.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor,Long> {
}
