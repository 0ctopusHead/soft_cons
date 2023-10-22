package proj.rest.se331.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String commentContent;
    LocalDateTime postedAt;
    @ManyToOne
    Advisor advisor;
    @ManyToOne
    Student student;
    @OneToMany(mappedBy = "comment")
    List<Answer> answer;
}
