package proj.rest.se331.service;

import proj.rest.se331.entity.Comment;

public interface CommentService {
    Comment getComment(Long id);
    Comment save(Comment comment);

}
