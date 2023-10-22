package proj.rest.se331.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import proj.rest.se331.entity.Advisor;
import proj.rest.se331.entity.Comment;
import proj.rest.se331.entity.Student;
import proj.rest.se331.request.CommentRequest;
import proj.rest.se331.service.AdvisorService;
import proj.rest.se331.service.CommentService;
import proj.rest.se331.service.StudentService;
import proj.rest.se331.util.LabMapper;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;
    final StudentService studentService;
    final AdvisorService advisorService;
    @GetMapping("/comments/{id}")
    public ResponseEntity<?> getComment(@PathVariable("id")Long id){
        List<Comment> output = studentService.getStudent(id).getComment();
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The comment doesn't exist");
        }
    }
    @PostMapping("/addComment/{id}")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest request, @PathVariable("id")Long id) {
        Student studentDb = studentService.getStudent(id);
        Advisor advisorDb = advisorService.getAdvisor(request.getAdvisorId());
        Comment new_comment = Comment.builder()
                .commentContent(request.getCommentContent())
                .postedAt(LocalDateTime.now())
                .build();
        new_comment.setAdvisor(advisorDb);
        new_comment.setStudent(studentDb);
        studentDb.setComment(List.of(new_comment));
        Comment output = commentService.save(new_comment);

        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));
    }
}
