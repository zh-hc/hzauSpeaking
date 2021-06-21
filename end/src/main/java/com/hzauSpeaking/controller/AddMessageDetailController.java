package com.hzauSpeaking.controller;

import com.hzauSpeaking.service.MessageImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Message;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.util.Upload.IsUpload;

@RestController
@Api(tags = "添加帖子内容")
public class AddMessageDetailController {
    @Autowired
    private MessageImagesService messageImagesService;
    @Autowired
    private MessageDetailService messageDetailService;
    @Autowired
    private UserService userService;

    @Transactional
    @PostMapping("/addMessage/{userId}")
    @ApiOperation(value = "添加帖子内容", httpMethod = "POST")
    public IsUpload addMessage(@PathVariable Integer userId, @RequestBody Message message) {
        return new IsUpload().isTrue(message, messageDetailService, messageImagesService, userService);
    }
}
