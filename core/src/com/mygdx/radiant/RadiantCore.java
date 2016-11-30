package com.mygdx.radiant;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.graphics.screens.*;

import java.util.HashMap;

public class RadiantCore extends Game {
    private HashMap<String, Screen> screenHash = new HashMap<String, Screen>();
	private Screen currentScreen;
	public enum SCREEN{
		SPLASH,
		MENU,
		GAME
	}

	public SCREEN state;

	@Override
	public void create() {
		state = SCREEN.GAME;
		MainMenuScreen mainMenuScreen = new MainMenuScreen(this);
        GameScreen gameScreen = new GameScreen(this);
		screenHash.put("mainmenu", mainMenuScreen);
        screenHash.put("game", gameScreen);
	}

	public void render()
	{
		super.render();
		checkScreen();
        currentScreen.render(Gdx.graphics.getDeltaTime());
	}

	public void checkScreen()
	{
		switch(state) {
			case SPLASH:
				currentScreen = screenHash.get("splash");
				break;
			case MENU:
				currentScreen = screenHash.get("mainmenu");
				break;
			case GAME:
				currentScreen = screenHash.get("game");
				break;
		}
	}

	/*@Override
	public void create () {

		setScreen(new MainMenuScreen(this));

	}*/

//	@Override
//	public void render () {
//        // Master background color
//		Gdx.gl.glClearColor(20 / 255f, 20 / 255f, 20 / 255f, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//	}

}
