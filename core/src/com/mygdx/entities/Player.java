package com.mygdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.radiant.CollisionDetector;

/**
 * Created by Edward Mondragon on 11/26/2016.
 */

public class Player extends Entity {

    private OrthographicCamera camera;

    public Player(TiledMapTileLayer collisionLayer, Vector2 position)
    {
        super(collisionLayer, position);
        movementSpeed = 3;
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
