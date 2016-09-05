package com.zackmitkin.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by zack on 30/08/16.
 */
public class input {

    public static float x = 0;
    public static float y = 0;

    public static float getX() {
        x = Gdx.input.getX();
        return x;
    }

    public static float getY() {
        y = -Gdx.input.getY() + 720;
        return y;
    }



}
