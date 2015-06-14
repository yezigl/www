/**
 * Copyright 2015 yezi.gl. All Rights Reserved.
 */
package com.yueqiu.model;

/**
 * description here
 *
 * @author yezi
 * @since 2015年6月14日
 */
public enum GameType {

    ALL(0),
    FOOTBALL(1);
    
    int type;
    
    /**
     * 
     */
    private GameType(int type) {
        this.type = type;
    }
    
    public static GameType valueOfType(int type) {
        for (GameType gameType : values()) {
            if (gameType.type == type) {
                return gameType;
            }
        }
        return ALL;
    }
}
