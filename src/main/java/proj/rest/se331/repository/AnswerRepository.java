package proj.rest.se331.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Answer;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    List<Answer> findAllByComment_Id(Long id);
}
