package com.hzauSpeaking.mapper;

import com.hzauSpeaking.entity.NewMessage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NewMessageMapper extends Mapper<NewMessage> {

    List<NewMessage> getAllNewMessage(Integer id);


    NewMessage getLastNewMessage(Integer id);
}