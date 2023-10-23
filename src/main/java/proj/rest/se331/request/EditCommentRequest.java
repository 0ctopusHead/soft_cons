package proj.rest.se331.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import proj.rest.se331.entity.Comment;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditCommentRequest {
    private Long id;
    private String commentContent;
    private Long advisorId;
}
