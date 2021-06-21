package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.NewMessage;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.NewMessageService;
import com.hzauSpeaking.service.UserService;

@RestController
@Api(tags = "添加管理员回复")
public class AddAdminReplyController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewMessageService newMessageService;

    @Transactional
    @PostMapping("/addNewMessageByAdmin/{adminId}/{messageId}/{messageUserId}")
    @ApiOperation(value = "通过管理员添加新消息", httpMethod = "POST")
    public Integer addNewMessageByAdmin(@PathVariable Integer adminId, @PathVariable Integer messageId, @PathVariable Integer messageUserId, @RequestBody String newMessage) {
        User admin = userService.getById(adminId);
        if (admin.getUserIsAdmin() != 2) {
            return 400;
        }

        NewMessage newNewMessage = new NewMessage();
        newNewMessage.setNewMessageDetail(newMessage);
        newNewMessage.setMessageId(messageId);
        newNewMessage.setUserId(messageUserId);
        newNewMessage.setNewMessageType(3);
        newMessageService.add(newNewMessage);

        return 200;
    }


}
