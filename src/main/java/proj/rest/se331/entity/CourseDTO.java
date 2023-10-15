package proj.rest.se331.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    Long id;
    String name;
    String courseID;
    String description;
    List<CourseEnrolledStudentDTO> enrolledStudent;
}
