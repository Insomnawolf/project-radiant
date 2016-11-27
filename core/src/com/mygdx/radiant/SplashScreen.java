package com.mygdx.radiant;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SplashScreen extends ScreenAdapter {

    Stage stage;
    RadiantCore game;

    public SplashScreen(RadiantCore game) {

        this.game = game;
        System.out.println("Splash screen loaded.");

        game.setScreen(new MainMenuScreen(game));

    }

    public void render(float deltaTime) {
        // Background color
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

}
