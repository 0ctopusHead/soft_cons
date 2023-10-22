package proj.rest.se331.dao;

import proj.rest.se331.entity.Answer;

public interface AnswerDao {
    Answer getAnswer(Long id);
    Answer save(Answer answer);
}
