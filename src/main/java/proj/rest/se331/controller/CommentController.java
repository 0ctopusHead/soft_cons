package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Comment;
import proj.rest.se331.entity.Student;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.service.CommentService;
import proj.rest.se331.service.StudentService;
import proj.rest.se331.util.LabMapper;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;
    final StudentService studentService;
    final AdvisorService advisorService;
    @PostMapping("/addComment/{id}")
    public ResponseEntity<?> addComment(@RequestBody Comment comment, @PathVariable("id")Long id) {
        Student studentDb = studentService.getStudent(id);
        Advisor advisorDb = advisorService.getAdvisor(studentDb.getAdvisor().getId());
        Comment new_comment = Comment.builder()
                .commentContent(comment.getCommentContent())
                .postedAt(LocalDateTime.now())
                .build();
        new_comment.setAdvisor(advisorDb);
        new_comment.setStudent(studentDb);
        studentDb.setComment(new_comment);
        Comment output = commentService.save(new_comment);

        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
    }
}
