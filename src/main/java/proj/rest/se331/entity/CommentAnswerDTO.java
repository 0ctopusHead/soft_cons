package proj.rest.se331.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentAnswerDTO {
    Long id;
    String commentContent;
    LocalDateTime postedAt;
    AdvisorCommentDto advisor;
    StudentCommentDTO student;
}
