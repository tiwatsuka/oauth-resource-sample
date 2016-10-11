package org.sample.oauth.domain.service.comment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.sample.oauth.domain.model.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Override
	public Comment getComment(Long id) {
		// always return same contents because this is a sample implementation.
		Comment comment = new Comment();
		comment.setId(id);
		comment.setContent("Sample comment.");
		comment.setUserId(12345678L);
		LocalDateTime currentDateTime = LocalDateTime.now();
		Instant instant = currentDateTime.toInstant(ZoneOffset.ofHours(9));
		comment.setCreated(Date.from(instant));
		return comment;
	}

	@Override
	public void createComment(Comment comment) {
	}

}
