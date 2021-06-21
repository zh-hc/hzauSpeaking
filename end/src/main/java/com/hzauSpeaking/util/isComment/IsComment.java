package com.hzauSpeaking.util.isComment;

import com.hzauSpeaking.entity.NewMessage;
import com.hzauSpeaking.entity.User;
import com.hzauSpeaking.service.AttendService;
import com.hzauSpeaking.service.CommentService;
import com.hzauSpeaking.service.NewMessageService;
import com.hzauSpeaking.service.UserService;
import com.hzauSpeaking.entity.Attend;
import com.hzauSpeaking.entity.Comment;

public class IsComment {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public IsComment isTrue(Integer userId, Integer messageId, String userComment, Integer messageUserId, UserService userService, CommentService commentService, NewMessageService newMessageService, AttendService attendService) {
        IsComment isComment = new IsComment();
        isComment.setCode(500);
        User user = userService.getById(userId);
        if (user == null) {
            isComment.setCode(400);
            return isComment;
        }

        if(user.getUserAllow()!=1){
            isComment.setCode(301);
            return isComment;
        }

        Comment comment = new Comment();
        comment.setMessageId(messageId);
        comment.setUserId(userId);
        comment.setCommentDetail(userComment);
        commentService.add(comment);

      if(userId!=messageUserId) {
          NewMessage newMessage = new NewMessage();
          newMessage.setUserId(messageUserId);
          newMessage.setNewMessageType(1);
          newMessage.setNewMessageDetail(userComment);
          newMessage.setMessageId(messageId);
          newMessageService.add(newMessage);
      }
        Attend attend = new Attend();

        attend.setMessageId(messageId);
        attend.setUserId(userId);

        if (attendService.findCount(attend) != 0) {
            isComment.setCode(200);
            return isComment;
        }


        attendService.add(attend);

        isComment.setCode(200);
        return isComment;
    }
}
