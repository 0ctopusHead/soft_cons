package proj.rest.se331.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import proj.rest.se331.entity.Comment;
import proj.rest.se331.repository.CommentRepository;
@Repository
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao {
    final CommentRepository commentRepository;
    @Override
    public Comment getComment(Long id){
        return commentRepository.findById(id).orElse(null);
    }
    @Override
    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }
}
