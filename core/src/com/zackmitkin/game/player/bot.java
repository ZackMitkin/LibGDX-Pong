package com.zackmitkin.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.zackmitkin.game.ball;

/**
 * Created by zack on 03/09/16.
 */
public class bot {

    static float x, y, width, height;
    static float deltaTime;

    static ShapeRenderer ctx;

    public static void setup() {

        // Positions
        x = 1280 - 50;
        y = 480/2 + 480/2;

        width = 40;
        height = 210;

        ctx = new ShapeRenderer();
    }

    public static void draw() {

        deltaTime = Gdx.graphics.getDeltaTime();

        if ((ball.getPosition().y - 210/2) > y) {
            y = y + 350 * deltaTime;
        }
        if ((ball.getPosition().y - 210/2) < y) {
            y = y - 350 * deltaTime;
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
