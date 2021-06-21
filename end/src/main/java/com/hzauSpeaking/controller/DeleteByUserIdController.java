package com.hzauSpeaking.controller;

import com.hzauSpeaking.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.util.isDelete.IsDelete;

@RestController
@Api(tags = "根据用户id删除")
public class DeleteByUserIdController {
    @Autowired
    private MessageDetailService messageDetailService;

    @Autowired
    private MessageImagesService messageImagesService;

    @Autowired
    private AttendService attendService;

    @Autowired
    private UserService userService;

    @Autowired
    private CollectService collectService;

    @Autowired
    private NewMessageService newMessageService;


    @Transactional
    @DeleteMapping("/deleteMessageById/{userId}/{messageId}")
    @ApiOperation(value = "根据用户id删除帖子", httpMethod = "DELETE")
    public IsDelete deleteByUserId(@PathVariable Integer userId, @PathVariable Integer messageId) {
        return new IsDelete().isDelete(userId, messageId, messageImagesService, userService, messageDetailService, attendService, collectService, newMessageService);
    }


}
