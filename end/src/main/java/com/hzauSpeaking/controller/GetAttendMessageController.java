package com.hzauSpeaking.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzauSpeaking.service.AttendService;
import com.hzauSpeaking.service.MessageImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Attend;
import com.hzauSpeaking.entity.Message;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.UserService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@Api(tags = "查询浏览信息")
public class GetAttendMessageController {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageDetailService messageDetailService;
    @Autowired
    private MessageImagesService messageImagesService;
    @Autowired
    private AttendService attendService;


    @GetMapping("/getMessage/getAttendMessageByUserId/{userId}/{pageNumber}")
    @ApiOperation(value = "根据用户id查询浏览信息", httpMethod = "GET")
    public List<Message> getAttendMessageByUserId(@PathVariable Integer userId, @PathVariable Integer pageNumber) {
        PageHelper.startPage(pageNumber, 5);
        PageInfo<Attend> pageInfo = new PageInfo<Attend>(attendService.getAllAttendMessageByUserId(userId));

        if (pageInfo.getPageNum() < pageNumber) {
            List list1 = new LinkedList();
            list1.add(200);
            return list1;
        }
        List<Attend> list = pageInfo.getList();


        List<Message> list1 = new ArrayList<Message>();
        for (int i = 0; i < list.size(); i++) {
            Integer messageId = list.get(i).getMessageId();
            Message message = messageDetailService.getById(messageId);
            list1.add(message);
        }
        return new GetMessageDetailController().getImage(list1, userService, messageImagesService);
    }
}
