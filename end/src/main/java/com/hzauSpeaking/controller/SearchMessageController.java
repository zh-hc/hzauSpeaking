package com.hzauSpeaking.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzauSpeaking.service.MessageImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Message;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.UserService;

import java.util.LinkedList;
import java.util.List;

@RestController
@Api(tags = "查询帖子")
public class SearchMessageController {

    @Autowired
    private MessageDetailService messageDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageImagesService messageImagesService;

    @GetMapping("/search/{categoryId}/{keyword}")
    @ApiOperation(value = "根据标签和关键词查询帖子", httpMethod = "GET")
    public List<Message> getMessageByCategoryAndKeyword(@PathVariable Integer categoryId, @PathVariable String keyword) {
        List<Message> allMessage = messageDetailService.getMessageByCategoryAndKeyword(categoryId, keyword);
        return new GetMessageDetailController().getImage(allMessage, userService, messageImagesService);

    }

    @GetMapping("/searchByKeyword/{keyword}/{pageNumber}")
    @ApiOperation(value = "根据关键词和页数查询帖子", httpMethod = "GET")
    public List<Message> getMessageByCategoryAndKeyword(@PathVariable String keyword, @PathVariable Integer pageNumber) {

        PageHelper.startPage(pageNumber, 3);

        PageInfo<Message> pageInfo = new PageInfo<Message>(messageDetailService.getMessageByKeyword(keyword));

        if (pageInfo.getPageNum() < pageNumber) {
            List list1 = new LinkedList();
            list1.add(200);
            return list1;
        }

        List<Message> allMessage = pageInfo.getList();

        return new GetMessageDetailController().getImage(allMessage, userService, messageImagesService);

    }

}
