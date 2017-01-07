package com.mygdx.radiant;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.graphics.screens.*;

import java.util.HashMap;

public class RadiantCore extends Game {
	public static final int V_WIDTH = 1900;
	public static final int V_HEIGHT = 1200;
    private HashMap<String, State> screenHash = new HashMap<String, State>();
	private Screen currentScreen;
	public SpriteBatch batch;
	private GameStateManager gsm;

	public enum SCREEN{
		SPLASH,
		MENU,
		GAME,
		CAVE
	}

	public SCREEN state;

	@Override
	public void create() {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		gsm.push(new GameScreen(gsm)); //put what screen you want to start out in here
		state = SCREEN.GAME;


		//I don't think this is needed anymore
		// Create and store screens
//		MainMenuScreen mainMenuScreen = new MainMenuScreen(gsm);
//		screenHash.put("mainmenu", mainMenuScreen);
//
//        GameScreen gameScreen = new GameScreen(gsm);
//        screenHash.put("game", gameScreen);
//
//		CaveScreen caveScreen = new CaveScreen(gsm);
//		screenHash.put("cave", caveScreen);
	}

	public void render()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.render(batch);
		gsm.update(Gdx.graphics.getDeltaTime());
//		super.render();

//		checkScreen();
//		currentScreen.render(batch);
//		currentScreen.update(Gdx.graphics.getDeltaTime());

	}

//	public void checkScreen()
//	{
//		switch(state) {
//			case SPLASH:
//				currentScreen = screenHash.get("splash");
//				break;
//			case MENU:
//				currentScreen = screenHash.get("mainmenu");
//				break;
//			case GAME:
//				currentScreen = screenHash.get("game");
//				break;
//			case CAVE:
//				currentScreen = screenHash.get("cave");
//				break;
//		}
//	}


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
