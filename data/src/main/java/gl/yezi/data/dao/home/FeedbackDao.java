package gl.yezi.data.dao.home;

import gl.yezi.data.mapper.home.FeedbackMapper;
import gl.yezi.data.model.home.Feedback;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

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
}