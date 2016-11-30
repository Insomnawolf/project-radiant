package com.mygdx.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.radiant.PlayerCollisionDetector;

/**
 * Created by Clifford Hill on 11/30/2016.
 */

public abstract class Entity {

    protected float posX;
    protected float posY;
    protected Texture img;
    protected Sprite sprite;
    protected Vector2 velocity = new Vector2(0, 0);
    protected TiledMapTileLayer collisionLayer;
    protected PlayerCollisionDetector collisionDetector;
    protected int movementSpeed;

    public boolean inBoundsCheck() {

        float rightBounds = collisionLayer.getWidth() * collisionLayer.getTileWidth();
        float upperBounds = collisionLayer.getHeight() * collisionLayer.getTileHeight();

        if (posX + velocity.x < 0 && velocity.x <0) {
            posX = 0;
            return false;
        }
        if ((posX + sprite.getWidth() + velocity.x) >= rightBounds) {
            posX = rightBounds - sprite.getWidth();
            return false;
        }
        if (posY + velocity.y < 0)
        {
            posY = 0;
            return false;
        }
        if((posY + sprite.getHeight() + velocity.y) >= upperBounds)
        {
            posY = upperBounds - sprite.getHeight();
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
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public int getMovementSpeed(){return movementSpeed;}

    public Sprite getSprite() {
        return sprite;
    }















}
