package com.hzauSpeaking.mapper;

import tk.mybatis.mapper.common.Mapper;
import com.hzauSpeaking.entity.Collect;

import java.util.List;

public interface CollectMapper extends Mapper<Collect> {
    List<Collect>  getAllCollectionMessageByUserId(Integer id);

}