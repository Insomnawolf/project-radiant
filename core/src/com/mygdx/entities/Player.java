package com.mygdx.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.radiant.PlayerCollisionDetector;

/**
 * Created by Edward Mondragon on 11/26/2016.
 */

public class Player{
    private float posX;
    private float posY;
    private Texture img;
    private Sprite sprite;
    private OrthographicCamera camera;
    private Vector2 velocity = new Vector2(0, 0);
    private TiledMapTileLayer collisionLayer;
    private PlayerCollisionDetector collisionDetector;

    public Player(TiledMapTileLayer collisionLayer)
    {
        img = new Texture(Gdx.files.internal("warriorL.png"));
        sprite = new Sprite(img);
        this.collisionLayer = collisionLayer;
        collisionDetector = new PlayerCollisionDetector(this, collisionLayer);
        posX = 10;
        posY = 10;
        camera = new OrthographicCamera();
    }

    public void update()
    {
        if(inBoundsCheck())
            collisionDetector.collision();
        sprite.setPosition(posX, posY);
    }

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

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

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

    public Sprite getSprite() {
        return sprite;
    }

    public void dispose()
    {
        img.dispose();
    }
}
