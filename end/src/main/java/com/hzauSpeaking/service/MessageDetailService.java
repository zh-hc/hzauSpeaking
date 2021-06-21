package com.hzauSpeaking.service;

import com.hzauSpeaking.mapper.MessageMapper;
import com.hzauSpeaking.util.SameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzauSpeaking.entity.Message;

import java.util.List;

@Service
public class MessageDetailService extends SameService<Message> {

    @Autowired
    private MessageMapper messageMapper;

    public Message getLostMessage() {
        return messageMapper.getLostMessage();
    }

    public Integer insertMessageDetail(Message message) {
        return messageMapper.insertMessageDetail(message);
    }

    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    /**
     * 查询分类所有
     *
     * @param id
     * @return
     */
    public List<Message> getMessageByCategoryId(Integer id) {
        return messageMapper.getMessageByCategoryId(id);
    }

    /**
     * 在分类里查询信息
     */

    public List<Message> getMessageByCategoryAndKeyword(Integer id, String keyword) {
        return messageMapper.getMessageByCategoryAndKeyword(id, keyword);
    }

    /**
     * 全局查询
     */
    public List<Message> getMessageByKeyword(String keyword){
        return messageMapper.getMessageByKeyword(keyword);
    }

    /**
     * 通过用户id查询
     */
    public List<Message> getMessageDetailByUserId(Integer userId) {
        return messageMapper.getMessageDetailByUserId(userId);
    }

    /**
     * 删除对应信息下的所有评论以及回复
     */
    public void deleteCommentAndReply(Integer messageId) {

        messageMapper.deleteCommentAndReply(messageId);
    }
}
