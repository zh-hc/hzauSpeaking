package com.hzauSpeaking.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "`message`")
public class Message {

    @Override
    public String toString() {
        return "Message{" +
                "resultImage=" + resultImage +
                ", messageId=" + messageId +
                ", userIdAnonymity=" + userIdAnonymity +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", userPhone='" + userPhone + '\'' +
                ", userMajor='" + userMajor + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", messageDetail='" + messageDetail + '\'' +
                ", messageShare=" + messageShare +
                ", messageComment=" + messageComment +
                ", messageWatch=" + messageWatch +
                ", messageCreatTime=" + messageCreatTime +
                ", messageImages=" + messageImages +
                ", comments=" + comments +
                ", user=" + user +
                '}';
    }

    private List<String> resultImage;

    public List<String> getResultImage() {
        return resultImage;
    }

    public void setResultImage(List<String> resultImage) {
        this.resultImage = resultImage;
    }

    @Id
    @Column(name = "`message_id`")
    private Integer messageId;

    @Column(name = "`user_id_anonymity`")
    private Integer userIdAnonymity;

    @Column(name = "`user_id`")
    private Integer userId;

    @Column(name = "`category_id`")
    private Integer categoryId;

    @Column(name = "`user_phone`")
    private String userPhone;

    @Column(name = "`user_major`")
    private String userMajor;

    @Column(name = "`user_level`")
    private String userLevel;

    @Column(name = "`message_detail`")
    private String messageDetail;

    @Column(name = "`message_share`")
    private Integer messageShare;

    @Column(name = "`message_comment`")
    private Integer messageComment;

    @Column(name = "`message_watch`")
    private Integer messageWatch;

    @Column(name = "`message_creat_time`")
    private Date messageCreatTime;

    private List<MessageImages> messageImages;

    private List<Comment> comments;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MessageImages> getMessageImages() {
        return messageImages;
    }

    public void setMessageImages(List<MessageImages> messageImages) {
        this.messageImages = messageImages;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
     * @return user_id_anonymity
     */
    public Integer getUserIdAnonymity() {
        return userIdAnonymity;
    }

    /**
     * @param userIdAnonymity
     */
    public void setUserIdAnonymity(Integer userIdAnonymity) {
        this.userIdAnonymity = userIdAnonymity;
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
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_major
     */
    public String getUserMajor() {
        return userMajor;
    }

    /**
     * @param userMajor
     */
    public void setUserMajor(String userMajor) {
        this.userMajor = userMajor;
    }

    /**
     * @return user_level
     */
    public String getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel
     */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * @return message_detail
     */
    public String getMessageDetail() {
        return messageDetail;
    }

    /**
     * @param messageDetail
     */
    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    /**
     * @return message_share
     */
    public Integer getMessageShare() {
        return messageShare;
    }

    /**
     * @param messageShare
     */
    public void setMessageShare(Integer messageShare) {
        this.messageShare = messageShare;
    }

    /**
     * @return message_comment
     */
    public Integer getMessageComment() {
        return messageComment;
    }

    /**
     * @param messageComment
     */
    public void setMessageComment(Integer messageComment) {
        this.messageComment = messageComment;
    }

    /**
     * @return message_watch
     */
    public Integer getMessageWatch() {
        return messageWatch;
    }

    /**
     * @param messageWatch
     */
    public void setMessageWatch(Integer messageWatch) {
        this.messageWatch = messageWatch;
    }

    /**
     * @return message_creat_time
     */
    public Date getMessageCreatTime() {
        return messageCreatTime;
    }

    /**
     * @param messageCreatTime
     */
    public void setMessageCreatTime(Date messageCreatTime) {
        this.messageCreatTime = messageCreatTime;
    }
}