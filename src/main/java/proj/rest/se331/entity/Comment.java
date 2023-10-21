package proj.rest.se331.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id","advisor_id"})})
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String commentContent;
    LocalDateTime postedAt;
    @ManyToOne
    @JoinColumn(name = "advisor_id")
    Advisor advisor;
    @OneToOne
    @JoinColumn(name = "student_id")
    Student student;
    @OneToOne(mappedBy = "comment")
    Answer answer;
}
