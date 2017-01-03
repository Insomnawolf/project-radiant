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
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
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

    //box 2d variables
    private World world;
    private Box2DDebugRenderer b2dr;

    private OrthographicCamera camera;
    private GameScreenInput input;
    Player player;
    TiledMap tiledMap;
    TmxMapLoader mapLoader;
    OrthoCachedTiledMapRenderer renderer;
    OrthogonalTiledMapSpriteRenderer tiledMapRenderer;

    private ArrayList<Entity> mapEntities = new ArrayList<Entity>();    //all entities that will be on the map
    private ArrayList<Item> mapItems = new ArrayList<Item>();           //all items that will be on the map

    private Sword sword; //testing

    public GameScreen(RadiantCore game)
    {
        //establish the world for box2d
        world = new World(new Vector2(0,0), true); // World ->(Vect2 (forces), BOOL don't calculate bodies at rest)
        b2dr = new Box2DDebugRenderer();

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
        player = new Player(layer, new Vector2(layer.getWidth() * tileWidth / 2, layer.getHeight() * tileHeight / 2),world);
//        player = new Player(layer, new Vector2(200* tileWidth / 2, layer.getHeight() * tileHeight / 2));

        //add items
        NPC npc1 = new NPC(layer, new Vector2(layer.getWidth() * tileWidth / 2, layer.getHeight() * tileHeight / 2), new Sprite(new Texture(Gdx.files.internal("NPC_Down.png"))));
        Rock rock1 = new Rock(true, new Vector2(40*tileWidth/2,40*tileHeight/2));
        System.out.print(layer.getHeight() + " " + tileWidth);
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


        world.step(delta,6,2); //6,2 are recommended
        b2dr.render(world, camera.combined);
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

    public World getWorld(){
        return world;
    }

    public TiledMap getMap(){
        return tiledMap;
    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
