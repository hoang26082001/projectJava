package com.nguyenvanhoang.application.service;

import com.nguyenvanhoang.application.model.request.CreateCommentPostRequest;
import com.nguyenvanhoang.application.model.request.CreateCommentProductRequest;
import com.nguyenvanhoang.application.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment createCommentPost(CreateCommentPostRequest createCommentPostRequest, long userId);
    Comment createCommentProduct(CreateCommentProductRequest createCommentProductRequest, long userId);
}
