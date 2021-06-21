package com.hzauSpeaking.util.isUpdate;

import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.entity.Message;

public class IsUpdate {

    private Integer code;

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public IsUpdate isTrue(Integer id, Integer messageId, String message, MessageDetailService messageDetailService, UserService userService) {



        IsUpdate isUpdate = new IsUpdate();
        isUpdate.setCode(500);
        User user = userService.getById(id);

        if (user == null) {
            isUpdate.setCode(400);
            return isUpdate;
        }
        Message Message = new Message();

        if (user.getUserIsAdmin() == 2) {
            Message.setMessageId(messageId);
        } else {
            Message.setMessageId(messageId);
            Message.setUserId(id);

            Integer count = messageDetailService.findCount(Message);

            if (count == 0) {
                isUpdate.setCode(400);
                return isUpdate;
            }
        }
        Message.setMessageDetail(message);
        messageDetailService.update(Message);
        isUpdate.setCode(200);
        return isUpdate;
    }
}
