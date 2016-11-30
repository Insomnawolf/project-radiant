package com.mygdx.radiant;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.entities.Entity;

/**
 * Created by Edward Mondragon on 11/27/2016.
 */

public class CollisionDetector {
    private Entity entity;
    private TiledMapTileLayer collisionLayer;
    private TiledMapTile tile;

    private float oldX, oldY;

    public CollisionDetector(Entity entity, TiledMapTileLayer collisionLayer) {
        this.entity = entity;
        this.collisionLayer = collisionLayer;
    }

   /* public boolean canMove()
    {
        return (collision() && inBoundsCheck());
    }*/

    public boolean collision()
    {
        oldX = entity.getPosX();
        oldY = entity.getPosY();
        float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
        boolean collisionX = false, collisionY = false;

        entity.setPosX(entity.getPosX() + entity.getVelocityX());

        if(entity.getVelocityX() < 0)
        {
            //top left tile collision test
            try {
                collisionX = collisionLayer.getCell((int) (entity.getPosX() / tileWidth), (int) ((entity.getPosY() + entity.getSprite().getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }catch(NullPointerException e){
                System.out.print("Null 1");
            }
                //middle left tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");
            //bottom left tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
        }
        else if(entity.getVelocityX() > 0) {
            //top right tile collision test
            try {
                collisionX = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            }catch(NullPointerException e){
                System.out.print("Null 2");
            }
            //middle right tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");
            //bottom right tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
        }

        if(collisionX)
        {
            entity.setVelocityX(0);
            entity.setPosX(oldX);
        }

        entity.setPosY(entity.getPosY() + entity.getVelocityY());

        if(entity.getVelocityY() < 0)
        {
            //bottom left tile collision test
            collisionY = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
            //bottom middle tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
            //bottom right tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");

        }
        else if(entity.getVelocityY() > 0)
        {
            //top left tile collision test
            collisionY = collisionLayer.getCell((int)(entity.getPosX()/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //top middle tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth()/2)/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //top right tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((entity.getPosX() + entity.getSprite().getWidth())/tileWidth), (int)((entity.getPosY() + entity.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
        }

        if(collisionY)
        {
            entity.setVelocityY(0);
            entity.setPosY(oldY);
        }

        return (collisionX || collisionY);
    }
}
