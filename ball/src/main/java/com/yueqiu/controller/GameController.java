/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yueqiu.entity.Game;
import com.yueqiu.entity.User;
import com.yueqiu.model.DateType;
import com.yueqiu.model.GameType;
import com.yueqiu.model.OrderBy;
import com.yueqiu.res.GameRes;
import com.yueqiu.res.Representation;
import com.yueqiu.res.StadiumRes;
import com.yueqiu.res.Status;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
@RestController
@RequestMapping("/1")
public class GameController extends AbstractController {

    @RequestMapping(value = "/activities", method = RequestMethod.GET)
    public Representation list(@RequestParam(defaultValue = "0") int dateType,
            @RequestParam(defaultValue = "0") int gameType, @RequestParam(defaultValue = "desc") String orderBy,
            @RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int limit) {
        Representation rep = new Representation();

        DateType dt = DateType.valueOfType(dateType);
        GameType gt = GameType.valueOfType(gameType);
        OrderBy ob = OrderBy.valueOfOrder(orderBy);

        List<Game> list = gameService.list(dt, gt, ob, offset, limit);
        List<GameRes> resList = new ArrayList<GameRes>();
        for (Game game : list) {
            resList.add(fromGame(game));
        }
        rep.setData(resList);

        return rep;
    }

    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public Representation get(@PathVariable String id) {
        Representation rep = new Representation();

        Game game = gameService.get(id);
        if (game == null) {
            rep.setError(Status.NOT_EXIST);
            return rep;
        }

        GameRes res = fromGame(game);
        rep.setData(res);

        return rep;
    }

    private String pattern = "MM月dd日 EEE HH:mm";

    private GameRes fromGame(Game game) {
        GameRes res = new GameRes();
        List<User> users = gameService.getAttend(game.getId().toString());
        res.setId(game.getId().toString());
        res.setTitle(game.getTitle());
        res.setType(game.getType());
        res.setDate(DateFormatUtils.format(game.getDate(), pattern, Locale.CHINA));
        res.setPrice(game.getPrice());
        res.setValue(game.getPrice());
        res.setTotal(game.getTotal());
        res.setAttend(game.getAttend());
        res.setOrganizer(null);
        StadiumRes stadium = new StadiumRes(game.getStadium());
        res.setStadium(stadium);
        for (User user : users) {
            res.addPlayer(user);
        }
        return res;
    }
}
