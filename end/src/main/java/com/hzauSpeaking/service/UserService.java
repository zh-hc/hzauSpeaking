package com.hzauSpeaking.service;

import com.hzauSpeaking.mapper.UserMapper;
import com.hzauSpeaking.util.SameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzauSpeaking.entity.User;

import java.util.List;

@Service
public class UserService extends SameService<User> {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新用户插入
     *
     * @param user
     * @return
     */
    public Integer insertUserMessage(User user) {
        return userMapper.insertUserMessage(user);
    }

    /**
     * 得到符合条件的用户数
     *
     * @param user
     * @return
     */

    public Integer getUserCount(User user) {
        return userMapper.selectCount(user);
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUserMessage(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 返回符合条件的用户信息
     */
    public List<User> getUserMessageByOtherMessage(User user) {
        return userMapper.select(user);
    }

}
