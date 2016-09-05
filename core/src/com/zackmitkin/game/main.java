package com.zackmitkin.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Shape;
import com.zackmitkin.game.player.*;

public class main extends ApplicationAdapter {

	@Override
	public void create () {
		score.setup();
		player.setup();
		ball.setup();
		bot.setup();
	}

	@Override
	public void render () {
        Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        player.draw();
		ball.draw();
		bot.draw();
		score.draw();
	}
	
	@Override
	public void dispose () {

	}

	static void restart() {
		ball.reset();
		player.reset();
		bot.reset();
	}
}
