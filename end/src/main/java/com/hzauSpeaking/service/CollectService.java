package com.hzauSpeaking.service;

import com.hzauSpeaking.util.SameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzauSpeaking.mapper.CollectMapper;
import com.hzauSpeaking.entity.Collect;

import java.util.List;

@Service
public class CollectService extends SameService<Collect> {

    @Autowired
    private CollectMapper collectMapper;

    public List<Collect> getAllCollectionMessageByUserId(Integer userId) {
        return collectMapper.getAllCollectionMessageByUserId(userId);
    }
}
