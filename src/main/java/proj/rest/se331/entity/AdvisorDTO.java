package proj.rest.se331.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorDTO {
    Long id;
    String academicPosition;
    String name;
    String surname;
    String department;
    List<String> images;
    List<String> files;
    List<StudentAdvisorDTO> advisees;
}
