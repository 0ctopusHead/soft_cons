package proj.rest.se331.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
