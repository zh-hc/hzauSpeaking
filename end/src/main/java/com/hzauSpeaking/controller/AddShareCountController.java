package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Message;
import com.hzauSpeaking.service.MessageDetailService;

@RestController
@Api(tags = "增加转发数")
public class AddShareCountController {


    @Autowired
    private MessageDetailService messageDetailService;

    @PostMapping("/share/addShareCount/{messageId}")
    @ApiOperation(value = "增加转发数", httpMethod = "POST")
    public Integer addShareCount(@PathVariable Integer messageId) {

        Message message = messageDetailService.getById(messageId);

        Message newMessage = new Message();

        newMessage.setMessageId(messageId);
        newMessage.setMessageShare(message.getMessageShare() + 1);
        messageDetailService.update(newMessage);


        return message.getMessageShare();
    }

}
