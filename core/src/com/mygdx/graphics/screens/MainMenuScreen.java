package com.mygdx.graphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.radiant.RadiantCore;

public class MainMenuScreen extends ScreenAdapter {

    RadiantCore game;

    private Stage stage;
    private Table table;

    public MainMenuScreen(RadiantCore game) {
        this.game = game;
        System.out.println("Main menu loaded.");

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        table.setDebug(true); // debug

        Skin skin = new Skin(new FileHandle("tests/data/uiskin.json"), new TextureAtlas("tests/data/uiskin.atlas"));
        //Skin skin = new Skin(Gdx.files.internal("tests/data/uiskin.json"));

        TextButton newGameButton = new TextButton("New Game", skin, "default");
        newGameButton.debugAll();
        newGameButton.setSize(200, 70);
        newGameButton.setName("newGame");
        //newGameButton.setPosition(500, 500);

        table.addActor(newGameButton);

    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(20 / 255f, 20 / 255f, 20 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }

}
