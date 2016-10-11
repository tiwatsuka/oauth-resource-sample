package org.sample.oauth.api.comment;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.sample.oauth.domain.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@Inject
	Mapper beanMapper;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public CommentResource getComment(@PathVariable Long id){
		return beanMapper.map(commentService.getComment(id), CommentResource.class);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public CommentResource createComment(@RequestBody @Validated CommentResource comment){
		return comment;
	}
}
