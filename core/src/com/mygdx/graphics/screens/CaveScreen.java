package com.mygdx.graphics.screens;

import com.badlogic.gdx.ScreenAdapter;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.Inventory.Item;
import com.mygdx.entities.Entity;
import com.mygdx.entities.Player;
import com.mygdx.graphics.renderer.OrthogonalTiledMapSpriteRenderer;
import com.mygdx.radiant.GameStateManager;
import com.mygdx.radiant.RadiantCore;
import com.mygdx.radiant.State;

import java.util.ArrayList;

/**
 * Created by Clifford Hill on 1/3/2017.
 * IGNORE THIS CLASS FOR NOW IT WAS FOR TESTING
 */

public class CaveScreen extends State {

    private int numPlayers = 0;
    private RadiantCore game;

    //box 2d variables
    private World world;
    private Box2DDebugRenderer b2dr;

    private OrthographicCamera gameCam;
    private GameScreenInput input;
    Player player;
    TiledMap map;
    TmxMapLoader mapLoader;
    OrthogonalTiledMapRenderer renderer;
    OrthogonalTiledMapSpriteRenderer tiledMapRenderer;

    private ArrayList<Entity> mapEntities = new ArrayList<Entity>();    //all entities that will be on the map
    private ArrayList<Item> mapItems = new ArrayList<Item>();           //all items that will be on the map


    public CaveScreen(GameStateManager gsm){
        super(gsm);
        world = new World(new Vector2(0,0), true);
        b2dr = new Box2DDebugRenderer();

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("test2.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);

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
}
