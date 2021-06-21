package com.hzauSpeaking.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.hzauSpeaking.entity.Collect;
import com.hzauSpeaking.entity.Message;
import com.hzauSpeaking.service.CollectService;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.MessageImagesService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.util.isCollect.IsCollect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@Api(tags = "添加收藏")
public class AddCollectionController {
    @Autowired
    private CollectService collectService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageImagesService messageImagesService;

    @Autowired
    private MessageDetailService messageDetailService;

    @GetMapping("/getMessage/getAllCollectionMessageByUserId/{userId}/{pageNumber}")
    @ApiOperation(value = "根据用户id查询所有收藏信息", httpMethod = "GET")
    public List<Message> getAllCollectionMessageByUserId(@PathVariable Integer userId, @PathVariable Integer pageNumber) {
        PageHelper.startPage(pageNumber, 5);
        PageInfo<Collect> pageInfo = new PageInfo<Collect>(collectService.getAllCollectionMessageByUserId(userId));

        if (pageInfo.getPageNum() < pageNumber) {
            List list1 = new LinkedList();
            list1.add(200);
            return list1;
        }
        List<Collect> list = pageInfo.getList();


        List<Message> list1 = new ArrayList<Message>();
        for (int i = 0; i < list.size(); i++) {
            Integer messageId = list.get(i).getMessageId();
            Message message = messageDetailService.getById(messageId);
            list1.add(message);
        }
        return new GetMessageDetailController().getImage(list1, userService, messageImagesService);
    }


    @Transactional
    @PostMapping("/addCollection/{userId}/{messageId}")
    @ApiOperation(value = "添加收藏信息", httpMethod = "POST")
    public IsCollect addCollection(@PathVariable Integer userId, @PathVariable Integer messageId) {
        return new IsCollect().isTrue(userId, messageId, collectService, userService);
    }

    @GetMapping("/addCollection/checkIsCollection/{userId}/{messageId}")
    @ApiOperation(value = "查询是否收藏", httpMethod = "GET")
    public Integer checkIsCollection(@PathVariable Integer userId, @PathVariable Integer messageId) {
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setMessageId(messageId);
        return collectService.findCount(collect);
    }

    @Transactional
    @DeleteMapping("/deleteCollection/{userId}/{messageId}")
    @ApiOperation(value = "删除收藏信息", httpMethod = "DELETE")
    public Integer deleteCollection(@PathVariable Integer userId, @PathVariable Integer messageId) {


        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setMessageId(messageId);
        collectService.delete(collect);
        return 200;
    }
}
