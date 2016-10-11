package org.sample.oauth.domain.service.comment;

import org.sample.oauth.domain.model.Comment;


public interface CommentService {

	Comment getComment(Long id);

	void createComment(Comment comment);
}
