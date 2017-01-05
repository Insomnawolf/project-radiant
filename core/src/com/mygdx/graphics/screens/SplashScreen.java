package com.mygdx.graphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.radiant.GameStateManager;
import com.mygdx.radiant.RadiantCore;
import com.mygdx.radiant.State;

public class SplashScreen extends State {

    Stage stage;
    RadiantCore game;

    public SplashScreen(GameStateManager gsm) {
        super(gsm);
        this.game = game;
        System.out.println("Splash screen loaded.");

//        game.setScreen(new com.mygdx.graphics.screens.MainMenuScreen(game));

    }
    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {

    }

    @Override
    public void dispose() {

    }


    public void render(float deltaTime) {
        // Background color
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

}
