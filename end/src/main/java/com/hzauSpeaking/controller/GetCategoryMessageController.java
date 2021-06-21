package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.Category;
import com.hzauSpeaking.service.CategoryService;

import java.util.List;

@RestController
@Api(tags = "查询标签信息")
public class GetCategoryMessageController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getMessage/getAllCategoryMessage")
    @ApiOperation(value = "查询所有标签信息", httpMethod = "GET")
    public List<Category> getAllCategoryMessage() {
        return categoryService.findAll();
    }
}
