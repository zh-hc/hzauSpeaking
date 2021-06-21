package com.hzauSpeaking.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzauSpeaking.entity.*;
import com.hzauSpeaking.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.LinkedList;
import java.util.List;

@RestController
@Api(tags = "查询帖子详细")
public class GetMessageDetailController {

    @Autowired
    private MessageDetailService messageDetailService;

    @Autowired
    private MessageImagesService messageImagesService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentReplayService commentReplayService;

    @Autowired
    private UserService userService;

    @GetMapping("/getMessage/getAllMessageDetail/{pageNumber}")
    @ApiOperation(value = "根据页数查询所有帖子详细", httpMethod = "GET")
    public List<Message> getAllMessageDetail(@PathVariable Integer pageNumber) {

        PageHelper.startPage(pageNumber, 8);

        PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getAllMessage());

        if (pageInfo.getPageNum() < pageNumber) {
            List list1 = new LinkedList();
            list1.add(200);
            return list1;
        }
        List<Message> allMessage = pageInfo.getList();

        return getImage(allMessage, userService, messageImagesService);
    }

    @GetMapping("/getMessage/getAllMessageDetail/{categoryId}/{pageNumber}")
    @ApiOperation(value = "根据标签和页数查询所有帖子详细", httpMethod = "GET")
    public List<Message> getMessageByCategoryId(@PathVariable Integer categoryId, @PathVariable Integer pageNumber) {
        PageHelper.startPage(pageNumber, 8);

        PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getMessageByCategoryId(categoryId));

        if (pageInfo.getPageNum() < pageNumber) {
            List list1 = new LinkedList();
            list1.add(200);
            return list1;
        }
        List<Message> allMessage = pageInfo.getList();
        return getImage(allMessage, userService, messageImagesService);
    }

    public List<Message> getImage(List<Message> allMessage, UserService userService, MessageImagesService messageImagesService) {
        for (int i = 0; i < allMessage.size(); i++) {
            allMessage.get(i).setUser(userService.getById(allMessage.get(i).getUserId()));
            MessageImages messageImages = new MessageImages();
            messageImages.setMessageId(allMessage.get(i).getMessageId());
            allMessage.get(i).setMessageImages(messageImagesService.findList(messageImages));
        }
        return allMessage;
    }

    @GetMapping("/getMessageDetailById/{id}")
    @ApiOperation(value = "根据id查询所有帖子详细", httpMethod = "GET")
    public Message getMessageDetailById(@PathVariable Integer id) {
        Message message = messageDetailService.getById(id);

        if (message == null) {
            return null;
        }

        Comment comment = new Comment();
        comment.setMessageId(id);
        List<Comment> comments = commentService.findList(comment);
        message.setComments(comments);
        User user = userService.getById(message.getUserId());
        message.setUser(user);


        MessageImages messageImages = new MessageImages();
        messageImages.setMessageId(id);
        message.setMessageImages(messageImagesService.findList(messageImages));

        Integer messageWatch = message.getMessageWatch();

        Message message1 = new Message();
        message1.setMessageId(id);
        message1.setMessageWatch(messageWatch + 1);
        message1.setMessageComment(comments.size());
        messageDetailService.update(message1);

        if (comments.size() == 0) {
            return message;
        }


        for (int i = 0; i < comments.size(); i++) {
            CommentReply commentReply = new CommentReply();
            commentReply.setCommentId(comments.get(i).getCommentId());
            comments.get(i).setCommentReplies(commentReplayService.findList(commentReply));
            comments.get(i).setUser(userService.getById(comments.get(i).getUserId()));
        }
        message.setComments(comments);
        return message;
    }

    @PostMapping("/getMessage/getMessageDetailByUserId/{userId}/{pageNumber}")
    public List<Message> getMessageDetailByUserId(@PathVariable Integer userId, @PathVariable Integer pageNumber) {

        User user = userService.getById(userId);

        if (user.getUserIsAdmin() == 2) {
            PageHelper.startPage(pageNumber, 5);
            PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getAllMessage());
            List<Message> list = pageInfo.getList();
            getImage(list, userService, messageImagesService);
            if (pageInfo.getPageNum() < pageNumber) {
                List list1 = new LinkedList();
                list1.add(200);
                return list1;
            }
            return list;
        } else {
            PageHelper.startPage(pageNumber, 3);
            PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getMessageDetailByUserId(userId));
            List<Message> list = pageInfo.getList();
            getImage(list, userService, messageImagesService);
            if (pageInfo.getPageNum() < pageNumber) {
                List list1 = new LinkedList();
                list1.add(200);
                return list1;
            }
            return list;

        }


    }

}
