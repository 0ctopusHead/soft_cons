package proj.rest.se331.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import proj.rest.se331.entity.Answer;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditAnswerRequest {
    private Answer answer;
    private String content;
}
