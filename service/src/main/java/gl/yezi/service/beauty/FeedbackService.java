/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.service.beauty;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import gl.yezi.data.dao.beauty.FeedbackDao;
import gl.yezi.data.model.beauty.Feedback;
import gl.yezi.service.BaseService;

import org.springframework.stereotype.Service;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月14日
 */
@Service
public class FeedbackService extends BaseService {

    @Resource
    FeedbackDao feedbackDao;

    public int create(Feedback feedback) {
        feedback.setCtime(new Date());
        feedback.setUtime(new Date());
        feedback.setStatus(Feedback.STATUS_NORMAL);
        return feedbackDao.create(feedback);
    }

    public List<Feedback> getList(int dealId, int beauticianId, int offset, int limit) {
        return feedbackDao.getList(0, dealId, beauticianId, offset, limit);
    }

    public List<Feedback> getList(int userId, int offset, int limit) {
        return feedbackDao.getList(userId, 0, 0, offset, limit);
    }
}
