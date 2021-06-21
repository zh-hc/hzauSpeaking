package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Comment;
import com.hzauSpeaking.entity.CommentReply;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.CommentReplayService;
import com.hzauSpeaking.service.CommentService;
import com.hzauSpeaking.service.UserService;

@RestController
@Api(tags = "根据id删除评论")
public class DeleteCommentByIdController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentReplayService commentReplayService;

    @Transactional
    @DeleteMapping("/deleteCommentByCommentId/{userId}/{messageId}")
    @ApiOperation(value = "根据评论id删除评论", httpMethod = "DELETE")
    public Integer deleteCommentByCommentId(@PathVariable Integer userId, @PathVariable Integer messageId) {
        User user = userService.getById(userId);
        if (user == null) {
            return 400;
        }
        Comment comment = new Comment();

        if (user.getUserIsAdmin() == 2) {
            comment.setCommentId(messageId);
        } else {
            comment.setCommentId(messageId);
            comment.setUserId(userId);
        }

        commentService.delete(comment);

        CommentReply commentReply = new CommentReply();
        commentReply.setCommentId(messageId);
        commentReplayService.delete(commentReply);


        return 200;
    }


    @Transactional
    @DeleteMapping("/deleteCommentReplyByCommentId/{userId}/{commentReplyId}")
    @ApiOperation(value = "根据评论id删除评论回复", httpMethod = "DELETE")
    public Integer deleteCommentReplyByCommentId(@PathVariable Integer userId, @PathVariable Integer commentReplyId) {
        User user = userService.getById(userId);
        if (user == null) {
            return 400;
        }
        CommentReply commentReply = new CommentReply();

        if (user.getUserIsAdmin() == 2) {
            commentReply.setCommentReplyId(commentReplyId);
        } else {
            commentReply.setCommentReplyId(commentReplyId);
            commentReply.setReplayUserId(userId);
        }

        commentReplayService.delete(commentReply);

        return 200;
    }

}


