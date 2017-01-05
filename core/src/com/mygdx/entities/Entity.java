package com.mygdx.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
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
    protected Body b2body;


    public Entity(TiledMapTileLayer collisionLayer, Vector2 position, World world) {
        this.position = position;
        this.collisionLayer = collisionLayer;
        collisionDetector = new CollisionDetector(this, collisionLayer);
    }

    public Entity(TiledMapTileLayer collisionLayer, Vector2 position, Texture texture) {
        this.position = position;
        this.collisionLayer = collisionLayer;
        this.sprite = new Sprite(texture);
        initializeSprite();
        collisionDetector = new CollisionDetector(this, collisionLayer);
    }

    public Entity(TiledMapTileLayer collisionLayer, Vector2 position, Sprite sprite) {
        this.position = position;
        this.collisionLayer = collisionLayer;
        this.sprite = sprite;
        initializeSprite();
        collisionDetector = new CollisionDetector(this, collisionLayer);
    }

    private void initializeSprite() {
        this.sprite.scale(1f);
        this.sprite.setPosition(position.x+sprite.getWidth(),position.y+sprite.getHeight()/2);
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

    public void defineEntity(World world, Vector2 position, float width, float height){
        BodyDef bdef = new BodyDef();
        bdef.position.set(position.x,position.y);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef =  new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width/2, height/2);
        fdef.shape = shape;
        b2body.createFixture(fdef);
        //shape.dispose();
    }
    public Body getB2body(){
        return b2body;
    }

    public void dispose(){
        img.dispose();
    }
    public void update(){
        sprite.setPosition(position.x, position.y);
    }














}
