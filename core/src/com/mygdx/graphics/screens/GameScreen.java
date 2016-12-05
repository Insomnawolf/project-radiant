package com.mygdx.graphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.graphics.renderer.OrthogonalTiledMapSpriteRenderer;
import com.mygdx.entities.Player;
import com.mygdx.radiant.RadiantCore;

/**
 * Created by Edward Mondragon on 11/22/2016.
 */

public class GameScreen extends ScreenAdapter{
    private int numPlayers = 0;
    private RadiantCore game;
    private OrthographicCamera camera;
    private GameScreenInput input;
    Player player;
    TiledMap tiledMap;
    OrthogonalTiledMapSpriteRenderer tiledMapRenderer;

    public GameScreen(RadiantCore game)
    {
        this.game = game;
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        tiledMap = new TmxMapLoader().load("test.tmx");
        tiledMapRenderer = new OrthogonalTiledMapSpriteRenderer(tiledMap);
        TiledMapTileLayer layer = (TiledMapTileLayer)tiledMap.getLayers().get(0);
        float tileWidth = layer.getTileWidth();
        float tileHeight = layer.getTileHeight();
        player = new Player(layer, new Vector2(layer.getWidth() * tileWidth / 2, layer.getHeight() * tileHeight / 2));
        camera = player.getCamera();
        camera.setToOrtho(false, width, height);
        camera.update();
        input = new GameScreenInput(player, (TiledMapTileLayer)tiledMap.getLayers().get(0));
        Gdx.input.setInputProcessor(input);
        tiledMapRenderer.addSprite(player.getSprite());
        show();
    }

    @Override
    public void render(float delta) {
        input.processInput();
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        player.update();
        camera.position.set(player.getPosX() + player.getSprite().getWidth()/2, player.getPosY() + player.getSprite().getHeight()/2, 0);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) width / (float) height;
        camera = new OrthographicCamera(2f * aspectRatio, 2f);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
