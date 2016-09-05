package com.zackmitkin.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.zackmitkin.game.player.bot;
import com.zackmitkin.game.player.player;
import com.zackmitkin.game.player.score;

/**
 * Created by zack on 02/09/16.
 */
public class ball {

    static float x, y, radius;
    static float deltaTime;

    static ShapeRenderer ctx;

    static float ballcentery;

    static float speedX;
    static float speedY;

    static int P1Score;
    static int P2Score;

    public static void setup() {

        // Positions
        x = 720/2;
        y = 480/2 + 480/2;

        radius = 20;

        if (randomBoolean())
            speedX = 350;
        else
            speedX = -350;

        if (randomBoolean())
            speedY = 350;
        else
            speedY = -350;

        ctx = new ShapeRenderer();

        P1Score = 0;
        P2Score = 0;
    }

    public static void draw() {
        collision();

        deltaTime = Gdx.graphics.getDeltaTime();

        ballcentery = y + radius;
        x += speedX * deltaTime;
        y += speedY * deltaTime;

        ctx.begin(ShapeRenderer.ShapeType.Filled);
        ctx.setColor(0, 0, 0, 1);
        ctx.circle(x, y, radius);
        ctx.end();
    }

    static void collision() {
        if (y < 0) {
            speedY = -speedY;
        }
        else if (y > 720) {
            speedY = -speedY;
        }
        if (x < 30) {
            P2Score = P2Score + 1;
            score.setP2Score(P2Score);
            main.restart();
        }
        else if (x > 1280 - 30) {
            P1Score = P1Score + 1;
            score.setP1Score(P1Score);
            main.restart();
        }

        // Coliision with player
       if(x > player.getPosition().x && x < player.getPosition().x + 40)
        {
            if(y>player.getPosition().y && y < player.getPosition().y + 210)
            {
                speedX = speedX + 10;
                speedY = GetReflection(ballcentery - player.getPosition().y);
                speedX = -speedX;

                System.out.println(speedY);

                System.out.println("Collided");
            }
        }

        if(x > bot.getPosition().x && x < bot.getPosition().x + 40)
        {
            if(y>bot.getPosition().y && y < bot.getPosition().y + 210)
            {
                speedX = speedX + 10;
                speedY = GetReflection(ballcentery - bot.getPosition().y);
                speedX = -speedX;

                System.out.println(speedY);

                System.out.println("Collided");
            }
        }
    }



    static float GetReflection(float hity) {
        // Make sure the hity variable is within the height of the paddle
        if (hity < 0) {
            hity = 0;
        } else if (hity > player.getPosition().y) {
            hity = player.getPosition().y;
        }

        hity -= player.getPosition().y / 2.0f;

        // Scale the reflection, making it fall in the range -2.0f to 2.0f
        return 30.0f * (hity / (player.getPosition().y / 45.0f));
    }

    static boolean randomBoolean() {
        if (Math.random() < 0.5) {
            return true;
        }
        else return false;
    }

    public static Vector2 getPosition() {
        Vector2 pos;
        pos = new Vector2(x, y);

        return pos;
    }

    public static void reset() {
        x = 1280/2;
        y = 720/2;

        if (randomBoolean())
            speedX = 350;
        else
            speedX = -350;

        if (randomBoolean())
            speedY = 350;
        else
            speedY = -350;
    }
}