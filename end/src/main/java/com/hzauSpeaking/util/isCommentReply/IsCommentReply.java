package com.hzauSpeaking.util.isCommentReply;

import com.hzauSpeaking.entity.CommentReply;
import com.hzauSpeaking.entity.NewMessage;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.AttendService;
import com.hzauSpeaking.service.CommentReplayService;
import com.hzauSpeaking.service.NewMessageService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.entity.Attend;

public class IsCommentReply {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public IsCommentReply isTrue(Integer messageId, CommentReply commentReply, UserService userService, CommentReplayService commentReplayService, NewMessageService newMessageService, AttendService attendService) {
        IsCommentReply isCommentReply = new IsCommentReply();
        isCommentReply.setCode(500);
        User user = userService.getById(commentReply.getReplayUserId());
        if (user == null) {
            isCommentReply.setCode(400);
            return isCommentReply;
        }

        if(user.getUserAllow()!=1){
            isCommentReply.setCode(301);
            return isCommentReply;
        }

        commentReplayService.add(commentReply);


        if (commentReply.getReceiveUserId() == commentReply.getReplayUserId()) {
            isCommentReply.setCode(200);
            return isCommentReply;
        }

        if(commentReply.getReplayUserId()!= commentReply.getReceiveUserId()) {
            NewMessage newMessage = new NewMessage();
            newMessage.setUserId(commentReply.getReceiveUserId());
            newMessage.setNewMessageType(2);
            newMessage.setMessageId(messageId);
            newMessage.setNewMessageDetail(commentReply.getReplyDetail());
            newMessageService.add(newMessage);
        }

        Attend attend = new Attend();
        attend.setMessageId(messageId);
        attend.setUserId(commentReply.getReplayUserId());

        if (attendService.findCount(attend) != 0) {
            isCommentReply.setCode(200);
            return isCommentReply;
        }

        attendService.add(attend);


        isCommentReply.setCode(200);
        return isCommentReply;
    }
}
