package com.mygdx.radiant;

import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.mygdx.entities.Player;

/**
 * Created by Edward Mondragon on 11/27/2016.
 */

public class PlayerCollisionDetector {
    private Player player;
    private TiledMapTileLayer collisionLayer;
    private TiledMapTile tile;

    private float oldX, oldY;

    public PlayerCollisionDetector(Player player, TiledMapTileLayer collisionLayer)
    {
        this.player = player;
        this.collisionLayer = collisionLayer;
    }

   /* public boolean canMove()
    {
        return (collision() && inBoundsCheck());
    }*/

    public boolean collision()
    {
        oldX = player.getPosX();
        oldY = player.getPosY();
        float tileWidth = collisionLayer.getTileWidth(), tileHeight = collisionLayer.getTileHeight();
        boolean collisionX = false, collisionY = false;

        player.setPosX(player.getPosX() + player.getVelocityX());

        if(player.getVelocityX() < 0)
        {
            //top left tile collision test
            try {
                collisionX = collisionLayer.getCell((int) (player.getPosX() / tileWidth), (int) ((player.getPosY() + player.getSprite().getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
            }catch(NullPointerException e){
                System.out.print("Null 1");
            }
                //middle left tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)(player.getPosX()/tileWidth), (int)((player.getPosY() + player.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");
            //bottom left tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)(player.getPosX()/tileWidth), (int)((player.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
        }
        else if(player.getVelocityX() > 0) {
            //top right tile collision test
            try {
                collisionX = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth())/tileWidth), (int)((player.getPosY() + player.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            }catch(NullPointerException e){
                System.out.print("Null 2");
            }
            //middle right tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth())/tileWidth), (int)((player.getPosY() + player.getSprite().getHeight()/2)/tileHeight)).getTile().getProperties().containsKey("blocked");
            //bottom right tile collision test
            if(!collisionX)
                collisionX = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth())/tileWidth), (int)((player.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
        }

        if(collisionX)
        {
            player.setVelocityX(0);
            player.setPosX(oldX);
        }

        player.setPosY(player.getPosY() + player.getVelocityY());

        if(player.getVelocityY() < 0)
        {
            //bottom left tile collision test
            collisionY = collisionLayer.getCell((int)(player.getPosX()/tileWidth), (int)((player.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
            //bottom middle tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth()/2)/tileWidth), (int)((player.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");
            //bottom right tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth())/tileWidth), (int)((player.getPosY()/tileHeight))).getTile().getProperties().containsKey("blocked");

        }
        else if(player.getVelocityY() > 0)
        {
            //top left tile collision test
            collisionY = collisionLayer.getCell((int)(player.getPosX()/tileWidth), (int)((player.getPosY() + player.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //top middle tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth()/2)/tileWidth), (int)((player.getPosY() + player.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
            //top right tile collision test
            if(!collisionY)
                collisionY = collisionLayer.getCell((int)((player.getPosX() + player.getSprite().getWidth())/tileWidth), (int)((player.getPosY() + player.getSprite().getHeight())/tileHeight)).getTile().getProperties().containsKey("blocked");
        }

        if(collisionY)
        {
            player.setVelocityY(0);
            player.setPosY(oldY);
        }

        return (collisionX || collisionY);
    }
}
