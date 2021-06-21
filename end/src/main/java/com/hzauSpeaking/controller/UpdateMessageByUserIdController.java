package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.util.isUpdate.IsUpdate;

@RestController
@Api(tags = "根据用户id更新")
public class UpdateMessageByUserIdController {

    @Autowired
    private MessageDetailService messageDetailService;

    @Autowired
    private UserService userService;

    @Transactional
    @ApiOperation(value = "根据消息id更新消息",httpMethod = "PUT")
    @PutMapping("/updateMessageById/{id}/{messageId}")
    public IsUpdate updateMessageById(@PathVariable Integer id,@PathVariable Integer messageId,@RequestBody String message){


        return new IsUpdate().isTrue(id,messageId,message, messageDetailService, userService);
    }
}
