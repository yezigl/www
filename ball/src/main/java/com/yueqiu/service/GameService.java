/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yueqiu.entity.Entry;
import com.yueqiu.entity.Game;
import com.yueqiu.entity.User;
import com.yueqiu.model.DateType;
import com.yueqiu.model.GameType;
import com.yueqiu.model.OrderBy;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@Service
public class GameService extends BaseService {

    public Game get(String id) {
        return gameDao.get(id);
    }
    
    public boolean create(Game game) {
        return gameDao.create(game);
    }
    
    public boolean update(Game game) {
        return gameDao.update(game);
    }
    
    public List<Game> list(DateType date, GameType ball, OrderBy orderby, int offset, int limit) {
        return gameDao.list(date, ball, orderby, offset, limit);
    }

    public List<User> getAttend(String gameId) {
        List<Entry> entries = entryDao.getByGame(gameId);
        List<User> users = new ArrayList<User>();
        for (Entry entry : entries) {
            users.add(entry.getUser());
        }
        return users;
    }
}
