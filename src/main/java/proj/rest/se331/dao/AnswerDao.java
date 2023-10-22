package proj.rest.se331.dao;

import proj.rest.se331.entity.Answer;

import java.util.List;

public interface AnswerDao {
    Answer getAnswer(Long id);
    List<Answer> getAllAnswerByCommentId(Long id);
    Answer save(Answer answer);
}
