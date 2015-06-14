/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.entity;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月13日
 */
@Entity("entry")
public class Entry extends BaseEntity {

    @Reference
    private Game game;
    @Reference
    private User user;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
