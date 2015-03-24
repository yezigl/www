/**
 * Copyright 2014 yezi.gl. All Rights Reserved.
 */
package com.mm.service.time;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mm.data.dao.time.UserBuyDao;
import com.mm.data.dao.time.UserSellDao;
import com.mm.data.model.time.UserBuy;
import com.mm.data.model.time.UserSell;
import com.mm.data.model.user.User;
import com.mm.data.page.Pagination;
import com.mm.service.context.UserContext;

/**
 * description here
 *
 * @author yezi
 * @since 2014年11月5日
 */
@Service
public class UserTimeService {

    @Resource
    UserSellDao userSellDao;

    @Resource
    UserBuyDao userBuyDao;

    public int sell(UserSell userSell) {
        userSell.setStatus(UserSell.STATUS_SELL);
        userSell.setCtime(new Date());
        userSell.setUtime(new Date());
        return userSellDao.create(userSell);
    }

    public void updateSell(UserSell userSell) {
        userSell.setUtime(new Date());
        userSellDao.update(userSell);
    }

    @Transactional
    public int buy(UserBuy userBuy, UserSell userSell) {
        userBuy.setStatus(UserBuy.STATUS_BUY);
        userBuy.setCtime(new Date());
        userBuy.setUtime(new Date());
        userBuy.setSellid(userSell.getId());
        userSell.setStatus(UserSell.STATUS_BUY);
        updateSell(userSell);
        return userBuyDao.create(userBuy);
    }

    public void updateBuy(UserBuy userBuy) {
        userBuy.setUtime(new Date());
        userBuyDao.update(userBuy);
    }

    @Transactional
    public boolean cancelSell(UserSell userSell) {
        UserBuy userBuy = userBuyDao.getBySell(userSell.getId());
        if (userBuy != null) {
            userBuy.setSellid(0);
            userBuy.setStatus(UserBuy.STATUS_CANCEL);
            updateBuy(userBuy);
            userSell.setStatus(UserSell.STATUS_CANCEL);
            updateSell(userSell);
            return true;
        }
        return false;
    }

    /**
     * 用户取消购买
     * 
     * @param userBuy
     * @return
     */
    @Transactional
    public boolean cancelBuy(UserBuy userBuy) {
        UserSell userSell = userSellDao.get(userBuy.getSellid());
        if (userSell != null) {
            userSell.setStatus(UserSell.STATUS_RESELL);
            updateSell(userSell);
            userBuy.setStatus(UserBuy.STATUS_CANCEL);
            updateBuy(userBuy);
            return true;
        }

        return false;
    }

    /**
     * 过期出售
     * 
     * @param userSell
     * @return
     */
    public boolean expireSell(UserSell userSell) {
        userSell.setStatus(UserSell.STATUS_EXPIRED);
        updateSell(userSell);
        return true;
    }

    @Transactional
    public boolean doneSell(UserSell userSell) {
        UserBuy userBuy = userBuyDao.getBySell(userSell.getId());
        if (userBuy != null) {
            userBuy.setStatus(UserBuy.STATUS_DONE);
            updateBuy(userBuy);
            userSell.setStatus(UserSell.STATUS_DONE);
            updateSell(userSell);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean doneBuy(UserBuy userBuy) {
        UserSell userSell = userSellDao.get(userBuy.getId());
        if (userSell != null) {
            userSell.setStatus(UserSell.STATUS_TBD);
            updateSell(userSell);
            userBuy.setStatus(UserBuy.STATUS_TBD);
            updateBuy(userBuy);
            return true;
        }
        return false;
    }

    public List<UserSell> getSellLatest(Pagination pag) {
        return userSellDao.getLastest(pag.getOffset(), pag.getLimit());
    }

    public List<UserSell> getSellAll(Pagination pagination) {
        return getSell(pagination, null);
    }

    public List<UserSell> getSellTBD(Pagination pagination) {
        return getSell(pagination, UserSell.STATUS_TBD);
    }

    public List<UserSell> getSellDone(Pagination pagination) {
        return getSell(pagination, UserSell.STATUS_DONE);
    }

    public List<UserSell> getSelling(Pagination pagination) {
        return getSell(pagination, UserSell.STATUS_SELL, UserSell.STATUS_RESELL);
    }

    public List<UserSell> getSellBuy(Pagination pagination) {
        return getSell(pagination, UserSell.STATUS_BUY);
    }

    private List<UserSell> getSell(Pagination pagination, int... status) {
        User user = UserContext.getUser();
        return userSellDao.getUserSellsByStatus(user.getId(), status, pagination.getOffset(), pagination.getLimit());
    }

    public List<UserBuy> getBuyAll(Pagination pagination) {
        return getBuy(pagination, null);
    }

    public List<UserBuy> getBuyTBD(Pagination pagination) {
        return getBuy(pagination, UserBuy.STATUS_TBD);
    }

    public List<UserBuy> getBuyDone(Pagination pagination) {
        return getBuy(pagination, UserBuy.STATUS_DONE);
    }

    public List<UserBuy> getBuying(Pagination pagination) {
        return getBuy(pagination, UserBuy.STATUS_BUY);
    }

    private List<UserBuy> getBuy(Pagination pagination, int... status) {
        User user = UserContext.getUser();
        return userBuyDao.getUserBuysByStatus(user.getId(), status, pagination.getOffset(), pagination.getLimit());
    }
}
