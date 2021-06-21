package com.hzauSpeaking.service;

import com.hzauSpeaking.util.SameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzauSpeaking.mapper.AttendMapper;
import com.hzauSpeaking.entity.Attend;

import java.util.List;

@Service
public class AttendService extends SameService<Attend> {

    @Autowired
    private AttendMapper attendMapper;

    public List<Attend> getAllAttendMessageByUserId(Integer id) {
        return attendMapper.getAllAttendMessageByUserId(id);
    }
}
