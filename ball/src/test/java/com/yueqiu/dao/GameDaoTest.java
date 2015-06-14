/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.dao;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yueqiu.TestConfig;
import com.yueqiu.entity.Game;
import com.yueqiu.entity.Stadium;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class GameDaoTest {

    @Autowired
    GameDao gameDao;
    
    @Autowired
    StadiumDao stadiumDao;
    
    /**
     * Test method for {@link com.yueqiu.dao.GameDao#get(java.lang.String)}.
     */
    @Test
    public void testGetString() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link com.yueqiu.dao.GameDao#create(com.yueqiu.entity.Game)}.
     */
    @Test
    public void testCreate() {
        Game game = new Game();
        game.setTitle("快来踢球啊");
        Stadium stadium = stadiumDao.get("557d3a3a87b6a706a5f8fb71");
        game.setStadium(stadium);
        game.setAttend(0);
        game.setDate(new Date());
        game.setPrice(40);
        game.setTotal(10);
        
        gameDao.create(game);
    }

    /**
     * Test method for {@link com.yueqiu.dao.GameDao#update(com.yueqiu.entity.Game)}.
     */
    @Test
    public void testUpdateGame() {
        String id = "557d3a9d87b6a706ab2cb2a1";
        Game game = gameDao.get(id);
        Stadium stadium = stadiumDao.get("557d3a6487b6a706a63dd428");
        game.setStadium(stadium);
        gameDao.update(game);
    }

    /**
     * Test method for {@link com.yueqiu.dao.GameDao#list(com.yueqiu.model.DateType, com.yueqiu.model.GameType, com.yueqiu.model.OrderBy, int, int)}.
     */
    @Test
    public void testList() {
        fail("Not yet implemented");
    }

}
