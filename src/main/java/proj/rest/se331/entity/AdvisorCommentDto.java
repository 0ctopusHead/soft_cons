package proj.rest.se331.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorCommentDto   {
    Long id;
    String academicPosition;
    String name;
    String surname;
    String department;
}
