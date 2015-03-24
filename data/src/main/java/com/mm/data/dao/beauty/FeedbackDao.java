package com.mm.data.dao.beauty;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.mm.data.mapper.beauty.FeedbackMapper;
import com.mm.data.model.beauty.Feedback;

@Repository
public class FeedbackDao {

    @Resource
    FeedbackMapper feedbackMapper;

    public int create(Feedback feedback) {
        return feedbackMapper.create(feedback);
    }

    public Feedback get(int id) {
        return feedbackMapper.get(id);
    }

    public void update(Feedback feedback) {
        feedbackMapper.update(feedback);
    }

    /**
     * @param offset
     * @param limit
     * @return
     */
    public List<Feedback> getList(int userId, int dealId, int beauticianId, int offset, int limit) {
        return feedbackMapper.getList(userId, dealId, beauticianId, new RowBounds(offset, limit));
    }
}