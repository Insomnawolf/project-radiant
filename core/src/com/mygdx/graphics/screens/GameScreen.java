package com.mygdx.graphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.Inventory.*;
import com.mygdx.entities.Entity;
import com.mygdx.entities.npcs.NPC;
import com.mygdx.graphics.renderer.OrthogonalTiledMapSpriteRenderer;
import com.mygdx.entities.Player;
import com.mygdx.radiant.RadiantCore;

import java.util.ArrayList;

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
    private ArrayList<Entity> mapEntities = new ArrayList<Entity>();    //all entities that will be on the map
    private ArrayList<Item> mapItems = new ArrayList<Item>();           //all items that will be on the map


    public GameScreen(RadiantCore game)
    {
        //???
        this.game = game;

        //Set up window bounds
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        //load the tile map
        tiledMap = new TmxMapLoader().load("test.tmx");
        tiledMapRenderer = new OrthogonalTiledMapSpriteRenderer(tiledMap);
        TiledMapTileLayer layer = (TiledMapTileLayer)tiledMap.getLayers().get(0);
        float tileWidth = layer.getTileWidth();
        float tileHeight = layer.getTileHeight();

        //add in the player
        player = new Player(layer, new Vector2(layer.getWidth() * tileWidth / 2, layer.getHeight() * tileHeight / 2));

        //add items
        NPC npc1 = new NPC(layer, new Vector2(layer.getWidth() * tileWidth / 2, layer.getHeight() * tileHeight / 2), new Sprite(new Texture(Gdx.files.internal("NPC_Down.png"))));


        //set the camera
        camera = player.getCamera();
        camera.setToOrtho(false, width, height);
        camera.update();

        //set up input listener
        input = new GameScreenInput(player, (TiledMapTileLayer)tiledMap.getLayers().get(0));
        Gdx.input.setInputProcessor(input);

        //add player to tile map
        tiledMapRenderer.addSprite(npc1.getSprite());
        tiledMapRenderer.addSprite(player.getSprite());
        show();
    }

    @Override
    public void render(float delta) {

        //Listen for inputs
        input.processInput();

        //meh
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Update map objects
        player.update();
        for(int i = 0; i < mapEntities.size(); i++){
            mapEntities.get(i).update();
        }
        for(int i = 0; i < mapItems.size(); i++){
            mapItems.get(i).update();
        }

        //Update camera
        camera.position.set(player.getPosX() + player.getSprite().getWidth()/2, player.getPosY() + player.getSprite().getHeight()/2, 0);
        camera.update();

        //???
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
