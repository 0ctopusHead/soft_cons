package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> addComment(@RequestBody String content, @PathVariable("id")Long id) {
        Student studentDb = studentService.getStudent(id);
        Advisor advisorDb = advisorService.getAdvisor(studentDb.getAdvisor().getId());
        Comment comment = Comment.builder()
                .commentContent(content)
                .postedAt(LocalDateTime.now())
                .build();
        comment.setAdvisor(advisorDb);
        comment.setStudent(studentDb);
        studentDb.setComment(comment);
        Comment output = commentService.save(comment);

        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
    }
}
