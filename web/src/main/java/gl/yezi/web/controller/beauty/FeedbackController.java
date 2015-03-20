/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package gl.yezi.web.controller.beauty;

import java.util.List;

import javax.annotation.Resource;

import gl.yezi.data.model.beauty.Beautician;
import gl.yezi.data.model.beauty.Deal;
import gl.yezi.data.model.beauty.Feedback;
import gl.yezi.service.beauty.BeauticianService;
import gl.yezi.service.beauty.DealService;
import gl.yezi.service.beauty.FeedbackService;
import gl.yezi.service.context.UserContext;
import gl.yezi.service.utils.Utils;
import gl.yezi.web.annotation.Auth;
import gl.yezi.web.controller.AbstractController;
import gl.yezi.web.res.UserRes;
import gl.yezi.web.res.beauty.BeauticianRes;
import gl.yezi.web.res.beauty.DealRes;
import gl.yezi.web.res.beauty.FeedbackListRes;
import gl.yezi.web.res.beauty.FeedbackRes;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description here
 *
 * @author yezi
 * @since 2015年3月14日
 */
@RestController
@RequestMapping("/1/beauty")
public class FeedbackController extends AbstractController {

    @Resource
    FeedbackService feedbackService;
    
    @Resource
    DealService dealService;
    
    @Resource
    BeauticianService beauticianService;
    
    @Auth
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public FeedbackRes create(@ModelAttribute Feedback feedback,
            @RequestHeader(value = "X-Forwarded-For", required = false) String forwardIp,
            @RequestHeader(value = "X-Real-IP", required = false) String realIp) {
        FeedbackRes res = new FeedbackRes();
        
        //TODO param check

        feedback.setUserId(UserContext.getUid());
        feedback.setIp(Utils.getClientIP(forwardIp, realIp));

        int id = feedbackService.create(feedback);
        feedback.setId(id);

        res.setFeedback(feedback);

        return res;
    }

    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
    public FeedbackListRes list(@RequestParam(defaultValue = "0") int dealId,
            @RequestParam(defaultValue = "0") int beauticianId, @RequestParam(defaultValue = "0") int offset) {
        FeedbackListRes res = new FeedbackListRes();
        
        // TODO param check
        List<Feedback> list;
        if (dealId == 0 && beauticianId == 0) {
            list = feedbackService.getList(UserContext.getUid(), offset, LIMIT);
        } else {
            list = feedbackService.getList(dealId, beauticianId, offset, LIMIT);
        }
        for (Feedback feedback : list) {
            FeedbackRes feedbackRes = new FeedbackRes(feedback);
            Deal deal = dealService.get(feedback.getDealId());
            Beautician beautician = beauticianService.get(feedback.getBeauticianId());
            feedbackRes.setDeal(new DealRes(deal));
            feedbackRes.setBeautician(new BeauticianRes(beautician));
            feedbackRes.setUser(new UserRes(UserContext.getUser()));
            res.addFeedback(feedbackRes);
        }

        return res;
    }
}
