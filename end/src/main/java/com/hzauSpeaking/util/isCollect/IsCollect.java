package com.hzauSpeaking.util.isCollect;

import com.hzauSpeaking.entity.Collect;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.CollectService;
import com.hzauSpeaking.service.UserService;

public class IsCollect {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public IsCollect isTrue(Integer userId, Integer messageId, CollectService collectService, UserService userService) {

        IsCollect isCollect = new IsCollect();
        isCollect.setCode(500);
        User user = userService.getById(userId);
        if (user == null) {
            isCollect.setCode(400);
            return isCollect;
        }

        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setMessageId(messageId);
        collectService.add(collect);

        isCollect.setCode(200);

        return isCollect;

    }
}
