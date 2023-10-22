package proj.rest.se331.service;

import proj.rest.se331.entity.Answer;

import java.util.List;

public interface AnswerService {
    Answer getAnswer(Long id);
    List<Answer> getAllAnswerByCommentId(Long id);
    Answer save(Answer answer);
}
