/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res.beauty;

import gl.yezi.data.model.beauty.Feedback;
import gl.yezi.web.res.Res;
import gl.yezi.web.res.UserRes;

import java.util.Date;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月14日
 */
public class FeedbackRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int id;
    private UserRes user;
    private DealRes deal;
    private BeauticianRes beautician;
    private String content;
    private Date ctime;
    private String reply;
    private Date replyTime;
    private int score;

    public FeedbackRes() {

    }

    public FeedbackRes(Feedback feedback) {
        setFeedback(feedback);
    }

    public void setFeedback(Feedback feedback) {
        id = feedback.getId();
        content = feedback.getContent();
        ctime = feedback.getCtime();
        reply = feedback.getReply();
        replyTime = feedback.getReplyTime();
        score = feedback.getScore();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserRes getUser() {
        return user;
    }

    public void setUser(UserRes user) {
        this.user = user;
    }

    public DealRes getDeal() {
        return deal;
    }

    public void setDeal(DealRes deal) {
        this.deal = deal;
    }

    public BeauticianRes getBeautician() {
        return beautician;
    }

    public void setBeautician(BeauticianRes beautician) {
        this.beautician = beautician;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
