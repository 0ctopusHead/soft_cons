package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import proj.rest.se331.dao.AnswerDao;
import proj.rest.se331.entity.Answer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{
    final AnswerDao answerDao;
    @Override
    public Answer getAnswer(Long id){
        return answerDao.getAnswer(id);
    }
    @Override
    public List<Answer> getAllAnswerByCommentId(Long id){
        return answerDao.getAllAnswerByCommentId(id);
    }
    @Override
    public Answer save(Answer answer){
        return answerDao.save(answer);
    }
}
