package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Notice;
import com.hzauSpeaking.service.NoticeService;

import java.util.List;

@RestController
@Api(tags = "查询通告")
public class GetNoticeController {


    @Autowired
    private NoticeService noticeService;

    @GetMapping("/getMessage/getAllNoticeMessage")
    @ApiOperation(value = "查询所有通告", httpMethod = "GET")
    public List<Notice> getAllNoticeMessage() {
        return noticeService.findAll();
    }

}
