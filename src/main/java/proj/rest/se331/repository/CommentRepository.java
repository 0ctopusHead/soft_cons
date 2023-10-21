package proj.rest.se331.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.rest.se331.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
