package com.mygdx.radiant;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Edward Mondragon on 11/27/2016.
 */

public class CollisionDetector {
    private Entity entity;
    private TiledMapTileLayer collisionLayer;
    private TiledMapTile tile;

    private float oldX, oldY, tileWidth, tileHeight, newX, newY;

    public CollisionDetector(Entity entity, TiledMapTileLayer collisionLayer) {
        this.entity = entity;
        this.collisionLayer = collisionLayer;
        tileWidth = collisionLayer.getTileWidth();
        tileHeight = collisionLayer.getTileHeight();
    }

   /* public boolean canMove()
    {
        return (collision() && inBoundsCheck());
    }*/

    public boolean collision()
    {
        oldX = entity.getPosX();
        oldY = entity.getPosY();
        boolean collisionX = false, collisionY = false;
        newX = entity.getPosX()+entity.getVelocityX();

        //entity.setPosX(entity.getPosX() + entity.getVelocityX());

        if(entity.getVelocityX() < 0)
        {
            //top left tile collision test
                //collisionX = collisionLayer.getCell((int) (entity.getPosX() / tileWidth), (int) ((entity.getPosY() + entity.getSprite().getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
                collisionX = collisionLayer.getCell((int) (newX / tileWidth), (int) ((entity.getPosY() + entity.getSprite().getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");

            //middle left tile collision test
            if(!collisionX)
                //collisionX = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");
                collisionX = collisionLayer.getCell((int)(newX/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");

            //bottom left tile collision test
            if(!collisionX)
                //collisionX = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
                collisionX = collisionLayer.getCell((int)(newX/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
        }
        else if(entity.getVelocityX() > 0) {
            //top right tile collision test
                //collisionX = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
                collisionX = collisionLayer.getCell((int)((newX + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //middle right tile collision test
            if(!collisionX)
//                collisionX = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");
                collisionX = collisionLayer.getCell((int)((newX + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");

            //bottom right tile collision test
            if(!collisionX)
//                collisionX = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
                collisionX = collisionLayer.getCell((int)((newX + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");

        }

        if(collisionX)
        {
            entity.setVelocityX(0);
         //   entity.setPosX(oldX);
        }else
        {
            entity.setPosX(newX);
        }

        newY = entity.getPosY()+entity.getVelocityY();
        //entity.setPosY(entity.getPosY() + entity.getVelocityY());

        if(entity.getVelocityY() < 0)
        {
            //bottom left tile collision test
//            collisionY = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
              collisionY = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((newY/tileHeight))).getTile().getProperties().containsKey("blocked");

            //bottom middle tile collision test
            if(!collisionY)
//                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
              collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth), (int)((newY/tileHeight))).getTile().getProperties().containsKey("blocked");

            //bottom right tile collision test
            if(!collisionY)
//                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((newY/tileHeight))).getTile().getProperties().containsKey("blocked");

        }
        else if(entity.getVelocityY() > 0)
        {
            //top left tile collision test
//            collisionY = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            collisionY = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((newY + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //top middle tile collision test
            if(!collisionY)
//                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth), (int)((newY + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //top right tile collision test
            if(!collisionY)
//                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
               collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((newY + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");

        }

        if(collisionY)
        {
            entity.setVelocityY(0);
//            entity.setPosY(oldY);
        }else{
            entity.setPosY(newY);
        }

        return (collisionX || collisionY);
    }

    public HashMap<Object, Float> checkEntityTile()
    {
        HashMap<Object, Float> tileProperties = new HashMap<Object, Float>();
        Iterator propertyIT = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth),(int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().getKeys();
        Iterator valueIT = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth),(int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().getValues();
        while(propertyIT.hasNext())
        {
            String key = (String)propertyIT.next();
            if(key.equals("speed"))
                tileProperties.put(key, (Float)valueIT.next());
        }

        return tileProperties;
    }
}
