package com.mygdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.radiant.CollisionDetector;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Edward Mondragon on 11/26/2016.
 */

public class Player extends Entity  {

    private OrthographicCamera camera;
    private float minSpeed = .5f;
    private float maxSpeed = 6;
    public Player(TiledMapTileLayer collisionLayer, Vector2 position, World world)
    {
        super(collisionLayer, position, world);
        baseSpeed = 3;
        movementSpeed = baseSpeed;
        img = new Texture(Gdx.files.internal("warriorL.png"));
        sprite = new Sprite(img);
        camera = new OrthographicCamera();

//        sprite.setBounds(position.x, position.y, sprite.getWidth(), sprite.getHeight());
//        sprite.setScale(1, 2);
        defineEntity(world,position,sprite.getWidth(),sprite.getHeight());
        sprite.setOrigin(b2body.getPosition().x, b2body.getPosition().y);
    }

    public void update()
    {
        if(inBoundsCheck())
            collisionDetector.collision();//player is moved here

//        b2body.applyLinearImpulse(new Vector2(getVelocityX(),getVelocityY()),this.getB2body().getWorldCenter(), true);
//move b2body
//        b2body.setTransform(position,0);

        b2body.setLinearVelocity(getVelocityX(),getVelocityY());

        sprite.setPosition(position.x, position.y);

        //apply tile properties
        HashMap<Object, Float> tileProperties = collisionDetector.checkEntityTile();
        if(tileProperties.containsKey("speed"))
            movementSpeed = baseSpeed * (float)tileProperties.get("speed");
        //clamp speed
        if(movementSpeed <= minSpeed)
            movementSpeed = minSpeed;
        if(movementSpeed >= maxSpeed)
            movementSpeed = maxSpeed;
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
