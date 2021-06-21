package com.hzauSpeaking.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "`comment`")
public class Comment {
    @Id
    @Column(name = "`comment_id`")
    private Integer commentId;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`message_id`")
    private Integer messageId;

    @Column(name = "`comment_detail`")
    private String commentDetail;

    @Column(name = "`comment_creat_time`")
    private Date commentCreatTime;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private List<CommentReply> commentReplies;

    public List<CommentReply> getCommentReplies() {
        return commentReplies;
    }

    public void setCommentReplies(List<CommentReply> commentReplies) {
        this.commentReplies = commentReplies;
    }

    /**
     * @return comment_id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * @param commentId
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return message_id
     */
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId
     */
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    /**
     * @return comment_detail
     */
    public String getCommentDetail() {
        return commentDetail;
    }

    /**
     * @param commentDetail
     */
    public void setCommentDetail(String commentDetail) {
        this.commentDetail = commentDetail;
    }

    /**
     * @return comment_creat_time
     */
    public Date getCommentCreatTime() {
        return commentCreatTime;
    }

    /**
     * @param commentCreatTime
     */
    public void setCommentCreatTime(Date commentCreatTime) {
        this.commentCreatTime = commentCreatTime;
    }
}