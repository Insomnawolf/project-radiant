package com.mygdx.radiant;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * This class is used for starting the template for different game states
 * Created by Cliff on 4/30/2016.
 */
public abstract class State {
    protected OrthographicCamera cam;
    protected OrthographicCamera spriteCam;
    protected Vector3 mouse;
    protected GameStateManager gsm;

    public State(GameStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        spriteCam = new OrthographicCamera();
        mouse = new Vector3();
    }
    public OrthographicCamera getcam(){
        return cam;
    }
    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract  void dispose();
}

