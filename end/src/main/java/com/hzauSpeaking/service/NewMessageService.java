package com.hzauSpeaking.service;

import com.hzauSpeaking.util.SameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzauSpeaking.mapper.NewMessageMapper;
import com.hzauSpeaking.entity.NewMessage;

import java.util.List;

@Service
public class NewMessageService extends SameService<NewMessage> {


    @Autowired
    private NewMessageMapper newMessageMapper;

    public List<NewMessage> getAllNewMessage(Integer userId) {
        return newMessageMapper.getAllNewMessage(userId);
    }

    public NewMessage getLastNewMessage(Integer id) {
        return newMessageMapper.getLastNewMessage(id);
    }
}
