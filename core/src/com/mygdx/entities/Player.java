package com.mygdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.radiant.CollisionDetector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Edward Mondragon on 11/26/2016.
 */

public class Player extends Entity {

    private OrthographicCamera camera;

    public Player(TiledMapTileLayer collisionLayer, Vector2 position)
    {
        super(collisionLayer, position);
        baseSpeed = 3;
        movementSpeed = baseSpeed;
        img = new Texture(Gdx.files.internal("warriorL.png"));
        sprite = new Sprite(img);
        camera = new OrthographicCamera();
        sprite.setOrigin(0, 0);
        sprite.setBounds(position.x, position.y, sprite.getWidth(), sprite.getHeight()/2);
        sprite.setScale(1, 2);
    }

    public void update()
    {
        if(inBoundsCheck())
            collisionDetector.collision();
        sprite.setPosition(position.x, position.y);
        HashMap<Object, Float> tileProperties = collisionDetector.checkEntityTile();
        if(tileProperties.containsKey("speed"))
            movementSpeed = baseSpeed * (float)tileProperties.get("speed");
        //clamp speed
        if(movementSpeed <= 0.5f)
            movementSpeed = 0.5f;
        if(movementSpeed >= 6)
            movementSpeed = 6;
    }


    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
    public OrthographicCamera getCamera() {
        return camera;
    }

    public void dispose()
    {
        img.dispose();
    }
}
