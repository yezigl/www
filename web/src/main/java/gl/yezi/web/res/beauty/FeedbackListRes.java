/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.res.beauty;

import java.util.ArrayList;
import java.util.List;

import gl.yezi.web.res.Res;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月14日
 */
public class FeedbackListRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<FeedbackRes> feedbacks;
    private Integer offset;

    public List<FeedbackRes> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<FeedbackRes> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    
    public void addFeedback(FeedbackRes feedbackRes) {
        if (feedbacks == null) {
            feedbacks = new ArrayList<FeedbackRes>();
        }
        feedbacks.add(feedbackRes);
    }

}
