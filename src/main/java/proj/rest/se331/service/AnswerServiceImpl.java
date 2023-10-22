package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import proj.rest.se331.dao.AnswerDao;
import proj.rest.se331.entity.Answer;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{
    final AnswerDao answerDao;
    @Override
    public Answer getAnswer(Long id){
        return answerDao.getAnswer(id);
    }
    @Override
    public Answer save(Answer answer){
        return answerDao.save(answer);
    }
}
