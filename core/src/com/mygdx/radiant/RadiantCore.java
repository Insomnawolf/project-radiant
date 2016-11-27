package com.mygdx.radiant;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class RadiantCore extends Game {
	
	@Override
	public void create () {

		setScreen(new MainMenuScreen(this));

	}

//	@Override
//	public void render () {
//        // Master background color
//		Gdx.gl.glClearColor(20 / 255f, 20 / 255f, 20 / 255f, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//	}

}
