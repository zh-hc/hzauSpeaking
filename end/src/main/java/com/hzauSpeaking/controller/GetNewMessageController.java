package com.hzauSpeaking.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.NewMessage;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.NewMessageService;
import com.hzauSpeaking.service.UserService;

import java.util.LinkedList;
import java.util.List;

@RestController
@Api(tags = "查询新消息")
public class GetNewMessageController {


    @Autowired
    private UserService userService;
    @Autowired
    private NewMessageService newMessageService;

    @ApiOperation(value = "查询所有新消息",httpMethod = "GET")
    @GetMapping("/getMessage/getAllNewMessage/{userId}/{pageNumber}")
    public List<NewMessage> getAllNewMessage(@PathVariable Integer userId, @PathVariable Integer pageNumber) {
        User user = userService.getById(userId);
        if (user == null) {
            return null;
        }
        PageHelper.startPage(pageNumber, 10);
        PageInfo<NewMessage> pageInfo = new PageInfo<NewMessage>(newMessageService.getAllNewMessage(userId));

        if (pageInfo.getPageNum() < pageNumber) {
            List list1 = new LinkedList();
            list1.add(200);
            return list1;
        }
        List<NewMessage> list = pageInfo.getList();
        return list;
    }

    @ApiOperation(value = "查询最新消息",httpMethod = "GET")
    @GetMapping("/getMessage/getLastNewMessage/{userId}")
    public NewMessage getLastNewMessage(@PathVariable Integer userId) {

        if (userId == -1) {
            return null;
        }

        return newMessageService.getLastNewMessage(userId);

    }


}
