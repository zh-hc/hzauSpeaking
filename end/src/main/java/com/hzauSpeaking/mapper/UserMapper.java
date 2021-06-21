package com.hzauSpeaking.mapper;

import tk.mybatis.mapper.common.Mapper;
import com.hzauSpeaking.entity.User;

public interface UserMapper extends Mapper<User> {

    Integer insertUserMessage(User user);

}