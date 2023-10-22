package proj.rest.se331.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    Long id;
    String commentContent;
    LocalDateTime postedAt;
    AdvisorCommentDto advisor;
    StudentCommentDTO student;
    List<AnswerCommentDTO> answer;

}
