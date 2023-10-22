package proj.rest.se331.request;

import lombok.*;
import proj.rest.se331.entity.Comment;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {
    private String content;
    private Comment comment;
}
