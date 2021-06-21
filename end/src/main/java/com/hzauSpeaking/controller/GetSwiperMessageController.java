package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Swiper;
import com.hzauSpeaking.service.SwiperService;

import java.util.List;

@RestController
@Api(tags = "查询轮播图片信息")
public class GetSwiperMessageController {

    @Autowired
    private SwiperService swiperService;

    @GetMapping("/getMessage/getAllSwiperMessage")
    @ApiOperation(value = "查询所有轮播图片信息", httpMethod = "GET")
    public List<Swiper> getAllSwiperMessage() {
        return swiperService.findAll();
    }
}
