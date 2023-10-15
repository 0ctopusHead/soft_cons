package proj.rest.se331.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentAdvisorDTO {
    Long id;
    String studentID;
    String name;
    String surname;
    String department;
    List<String> images;
}
