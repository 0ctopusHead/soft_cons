package proj.rest.se331.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import proj.rest.se331.dao.CommentDao;
import proj.rest.se331.entity.Comment;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    final CommentDao commentDao;
    @Override
    public Comment getComment(Long id){
        return commentDao.getComment(id);
    }
    @Override
    public Comment save(Comment comment){
        return commentDao.save(comment);
    }
}
