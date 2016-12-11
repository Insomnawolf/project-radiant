package com.mygdx.Inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Cliff on 12/5/2016.
 */

public abstract class Item {
    protected String name;
    protected Texture imgUI;                      // the image to display on the UI
    protected Texture imgMap;                     // use this for displaying it on the map
    protected String description;                 // Items description
    protected Sprite sprite;                      // Sprite to represent the item
    protected Vector2 position;



    public String getName(){return name;}
    public String getDescription(){return description;}
    public void dispose(){
        imgMap.dispose();
        imgUI.dispose();
    }

    public void update(){
        sprite.setPosition(position.x, position.y);
    }
    public Sprite getSprite(){
        return sprite;
    }

}
