package proj.rest.se331.entity;

import jakarta.persistence.*;
import lombok.*;
import proj.rest.se331.security.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String academicPosition;
    String name;
    String surname;
    String department;
    @ElementCollection
    List<String> images;
    @ElementCollection
    List<String> files;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Student> advisees = new ArrayList<>();
    @OneToOne
    User user;
}
