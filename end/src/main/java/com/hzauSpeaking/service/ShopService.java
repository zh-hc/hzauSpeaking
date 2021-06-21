package com.hzauSpeaking.service;

import com.hzauSpeaking.util.SameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hzauSpeaking.mapper.ShopMapper;
import com.hzauSpeaking.entity.Shop;

@Service
public class ShopService extends SameService<Shop> {
    @Autowired
    private ShopMapper shopMapper;


}
