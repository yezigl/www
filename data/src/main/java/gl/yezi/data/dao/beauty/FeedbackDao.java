package gl.yezi.data.dao.beauty;

import java.util.List;

import gl.yezi.data.mapper.beauty.FeedbackMapper;
import gl.yezi.data.model.beauty.Feedback;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
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

    /**
     * @param offset
     * @param limit
     * @return
     */
    public List<Feedback> getList(int userId, int dealId, int beauticianId, int offset, int limit) {
        return feedbackMapper.getList(userId, dealId, beauticianId, new RowBounds(offset, limit));
    }
}