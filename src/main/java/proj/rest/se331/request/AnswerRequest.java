package proj.rest.se331.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {
    private String content;
    private Long commentId;
}
