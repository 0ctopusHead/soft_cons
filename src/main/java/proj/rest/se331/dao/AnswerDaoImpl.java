package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Answer;
import proj.rest.se331.repository.AnswerRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerDaoImpl implements AnswerDao {
    final AnswerRepository answerRepository;
    @Override
    public  Answer getAnswer(Long id){
        return answerRepository.findById(id).orElse(null);
    }
    @Override
    public List<Answer> getAllAnswerByCommentId(Long id){
        return answerRepository.findAllByComment_Id(id);
    }
    @Override
    public Answer save(Answer answer){
       return answerRepository.save(answer);
    }
}
