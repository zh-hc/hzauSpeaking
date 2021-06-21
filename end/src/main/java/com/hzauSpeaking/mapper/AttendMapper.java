package com.hzauSpeaking.mapper;

import tk.mybatis.mapper.common.Mapper;
import com.hzauSpeaking.entity.Attend;

import java.util.List;

public interface AttendMapper extends Mapper<Attend> {
    List<Attend> getAllAttendMessageByUserId(Integer id);
}