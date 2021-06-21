package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.CommentReply;
import com.hzauSpeaking.service.AttendService;
import com.hzauSpeaking.service.CommentReplayService;
import com.hzauSpeaking.service.NewMessageService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.util.isCommentReply.IsCommentReply;

@RestController
@Api(tags = "添加评论回复")
public class AddCommentReplyController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentReplayService commentReplayService;

    @Autowired
    private NewMessageService newMessageService;

    @Autowired
    private AttendService attendService;

    @Transactional
    @PostMapping("/addCommentReply/{messageId}")
    @ApiOperation(value = "添加评论回复", httpMethod = "POST")
    public IsCommentReply addCommentReply(@PathVariable Integer messageId, @RequestBody CommentReply commentReply) {

        return new IsCommentReply().isTrue(messageId, commentReply, userService, commentReplayService, newMessageService, attendService);

    }


}
