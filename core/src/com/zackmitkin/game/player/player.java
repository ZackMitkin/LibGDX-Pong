package com.zackmitkin.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.zackmitkin.game.input;

/**
 * Created by zack on 31/08/16.
 */
public class player {

    static float x, y, width, height;
    static double touch;
    static float deltaTime;

    static ShapeRenderer ctx;

    public static void setup() {

        // Positions
        x = 10;
        y = 480/2 + 480/2;

        width = 40;
        height = 210;

        ctx = new ShapeRenderer();
    }

    public static void draw() {

        deltaTime = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isTouched()) {
            touch = input.getY() + 2.2081 - 210 / 2;
        }

        if (touch > y) {
            y = y + 400 * deltaTime;
        }
        if (touch < y) {
            y = y - 400 * deltaTime;
        }
        else {
            //System.out.println(y + " " + touch);
        }

        ctx.begin(ShapeRenderer.ShapeType.Filled);
        ctx.setColor(0, 0, 0, 1);
        ctx.rect(x, y, width, height);
        ctx.end();
    }

    public static Vector2 getPosition() {
        Vector2 position;
        position = new Vector2(x, y);
        return  position;
    }

    public static void reset() {
        y = 720/2 + 210/2;
    }


}
