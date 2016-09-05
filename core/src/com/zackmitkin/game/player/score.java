package com.zackmitkin.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by zack on 03/09/16.
 */
public class score {

    static BitmapFont P1ScoreFont;
    static BitmapFont P2ScoreFont;


    static SpriteBatch spriteBatch;

    static CharSequence P1ScoreText;
    static CharSequence P2ScoreText;

    public static void setup() {
        P1ScoreText = "You: 0";
        P2ScoreText = "Player 2: 0";

        spriteBatch = new SpriteBatch();

        P1ScoreFont = new BitmapFont(Gdx.files.internal("font.fnt"));
        P2ScoreFont = new BitmapFont(Gdx.files.internal("font.fnt"));
    }

    public static void draw() {
        spriteBatch.begin();
        P1ScoreFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        P1ScoreFont.draw(spriteBatch, P1ScoreText, 350, 720 - 10);

        P2ScoreFont.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        P2ScoreFont.draw(spriteBatch, P2ScoreText, 1080 - 330, 720 - 10);
        spriteBatch.end();
    }

    public static void setP1Score(int scoreInt) {
        P1ScoreText = "Player 1: " + scoreInt;
    }

    public static void setP2Score(int scoreInt) {
        P2ScoreText = "Player 2: " + scoreInt;
    }

}
