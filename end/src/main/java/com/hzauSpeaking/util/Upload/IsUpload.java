package com.hzauSpeaking.util.Upload;

import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.MessageDetailService;
import com.hzauSpeaking.service.MessageImagesService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.entity.Message;
import com.hzauSpeaking.entity.MessageImages;

import java.util.List;

public class IsUpload {

    /**
     * 500 服务器错误
     * 200 上传成功
     * 403 不允许发布,拉黑
     * 400 数据出现问题
     * 401  未登录
     * 1000 非法入侵
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public IsUpload isTrue(Message message, MessageDetailService messageDetailService, MessageImagesService messageImagesService, UserService userService) {
        IsUpload isUpload = new IsUpload();

        User user = userService.getById(message.getUserId());

        if (user == null) {
            isUpload.setCode(1000);
            return isUpload;
        }

        if(user.getUserAllow()!=1){
            isUpload.setCode(301);
            return isUpload;
        }

        List<String> resultImage = message.getResultImage();

        messageDetailService.insertMessageDetail(message);

        for (int i = 0; i < resultImage.size(); i++) {
            MessageImages messageImages = new MessageImages();
            messageImages.setImageUrl(resultImage.get(i));
            messageImages.setMessageId(message.getMessageId());
            messageImagesService.add(messageImages);
        }

        isUpload.setCode(200);

        return isUpload;


    }

}
