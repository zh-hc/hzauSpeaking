package com.hzauSpeaking.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.hzauSpeaking.entity.Message;

import java.util.List;

public interface MessageMapper extends Mapper<Message> {

    Message getLostMessage();

    Integer insertMessageDetail(Message message);

    List<Message> getAllMessage();

    List<Message> getMessageByCategoryId(Integer id);

    List<Message> getMessageByCategoryAndKeyword(@Param("id") Integer id, @Param("keyword") String keyword);

    List<Message> getMessageDetailByUserId (Integer userId);

    List<Message> getMessageByKeyword(@Param("keyword") String keyword);

    void deleteCommentAndReply(@Param("id") Integer id);



}