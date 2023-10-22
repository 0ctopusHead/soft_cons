package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Answer;
import proj.rest.se331.repository.AnswerRepository;

@Repository
@RequiredArgsConstructor
public class AnswerDaoImpl implements AnswerDao {
    final AnswerRepository answerRepository;
    @Override
    public  Answer getAnswer(Long id){
        return answerRepository.findById(id).orElse(null);
    }
    @Override
    public Answer save(Answer answer){
       return answerRepository.save(answer);
    }
}
