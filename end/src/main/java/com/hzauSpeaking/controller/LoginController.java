package com.hzauSpeaking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.entity.WXSessionModel;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.util.common.HttpClientUtil;
import com.hzauSpeaking.util.common.JsonUtils;
import com.hzauSpeaking.util.login.IsLogin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "登录")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录功能
     *
     * @param code
     * @param user
     * @return
     */
    @Transactional
    @PostMapping("/Login")
    @ApiOperation(value = "登录", httpMethod = "POST")
    public IsLogin Login(String code, @RequestBody User user) {

        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> param = new HashMap<String, String>();

//        小程序id信息
        param.put("appid", "xxx");
        param.put("secret", "xxx");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        String wxResult = HttpClientUtil.doGet(url, param);
        WXSessionModel wxSessionModel = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

        String openid = wxSessionModel.getOpenid();
        user.setUserOpenid(openid);

        return new IsLogin().isTrue(user, openid, userService);
    }

    @GetMapping("/checkAdmin")
    @ApiOperation(value = "检查是否为管理员", httpMethod = "GET")
    public List<User> checkAdmin(Integer id) {
        User user = new User();
        user.setUserId(id);
        return userService.getUserMessageByOtherMessage(user);
    }
}
