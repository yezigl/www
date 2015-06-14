/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.res;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.yueqiu.entity.User;
import com.yueqiu.utils.Constants;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
public class GameRes extends Res {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private int type;
    private StadiumRes stadium;
    private String date;
    private float price;
    private float value;
    private int total;
    private int attend;
    @JsonInclude(Include.NON_NULL)
    private UserRes organizer;
    private List<Player> players;

    public GameRes() {
        players = new ArrayList<Player>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StadiumRes getStadium() {
        return stadium;
    }

    public void setStadium(StadiumRes stadium) {
        this.stadium = stadium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
        this.attend = attend;
    }

    public UserRes getOrganizer() {
        return organizer;
    }

    public void setOrganizer(UserRes organizer) {
        this.organizer = organizer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void addPlayer(User user) {
        Player player = new Player();
        player.setAvatar(StringUtils.defaultString(user.getAvatar(), Constants.DEFAULT_AVATAR));
        player.setId(user.getId().toString());
        players.add(player);
    }

}