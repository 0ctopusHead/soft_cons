package proj.rest.se331.dao;

import proj.rest.se331.entity.Comment;

public interface CommentDao {
    Comment getComment(Long id);
    Comment save(Comment comment);
}
