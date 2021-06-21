package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.service.AttendService;
import com.hzauSpeaking.service.CommentService;
import com.hzauSpeaking.service.NewMessageService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.util.isComment.IsComment;

@RestController
@Api(tags = "添加评论")
public class AddCommentController {

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private NewMessageService newMessageService;

    @Autowired
    private AttendService attendService;

    @Transactional
    @PostMapping("/addComment/{userId}/{messageId}/{messageUserId}")
    @ApiOperation(value = "添加评论", httpMethod = "POST")
    public IsComment addComment(@PathVariable Integer userId, @RequestBody String userComment, @PathVariable Integer messageId, @PathVariable Integer messageUserId) {
        return new IsComment().isTrue(userId, messageId, userComment, messageUserId, userService, commentService, newMessageService, attendService);
    }

}
