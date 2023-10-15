package proj.rest.se331.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String studentID;
    String name;
    String surname;
    String department;
    @ElementCollection
    List<String> images;
    @ManyToOne
    Advisor advisor;
    @ManyToMany(mappedBy = "enrolledStudents")
    List<Course> courses;
}
