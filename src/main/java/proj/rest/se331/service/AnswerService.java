package proj.rest.se331.service;

import proj.rest.se331.entity.Answer;

public interface AnswerService {
    Answer getAnswer(Long id);
    Answer save(Answer answer);
}
