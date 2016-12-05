package com.mygdx.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.radiant.CollisionDetector;

/**
 * Created by Clifford Hill on 11/30/2016.
 */

public abstract class Entity {

    protected Vector2 position;
    protected Texture img;
    protected Sprite sprite;
    protected Vector2 velocity = new Vector2(0, 0);
    protected TiledMapTileLayer collisionLayer;
    protected CollisionDetector collisionDetector;
    protected float movementSpeed;
    protected float baseSpeed;
    protected String statusAilment;


    public Entity(TiledMapTileLayer collisionLayer, Vector2 position) {
        this.position = position;
        this.collisionLayer = collisionLayer;
        collisionDetector = new CollisionDetector(this, collisionLayer);
    }

    public boolean inBoundsCheck() {

        float rightBounds = collisionLayer.getWidth() * collisionLayer.getTileWidth();
        float upperBounds = collisionLayer.getHeight() * collisionLayer.getTileHeight();

        if (position.x + velocity.x < 0 && velocity.x <0) {
            position.x = 0;
            return false;
        }
        if ((position.x + sprite.getWidth() + velocity.x) >= rightBounds) {
            position.x = rightBounds - sprite.getWidth();
            return false;
        }
        if (position.y + velocity.y < 0)
        {
            position.y = 0;
            return false;
        }
        if((position.y + sprite.getHeight() + velocity.y) >= upperBounds)
        {
            position.y = upperBounds - sprite.getHeight();
            return false;
        }
        return true;
    }

    public float getVelocityX() {
        return velocity.x;
    }

    public float getVelocityY() {
        return velocity.y;
    }

    public void setVelocityX(float velocityX) {
        velocity.x = velocityX;
    }

    public void setVelocityY(float velocityY) { velocity.y = velocityY; }



    public float getPosY() {
        return position.y;
    }

    public void setPosY(float positionY) {
        this.position.y = positionY;
    }

    public float getPosX() {
        return position.x;
    }

    public void setPosX(float positionX) {
        this.position.x = positionX;
    }

    public float getMovementSpeed(){return movementSpeed;}

    public Sprite getSprite() {
        return sprite;
    }
    public void dispose(){
        img.dispose();
    }














}
