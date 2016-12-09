package com.mygdx.Inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;

/**
 * Created by Cliff on 12/5/2016.
 */

public abstract class Item {
    protected String name;
    protected Texture imgUI;                      // the image to display on the UI
    protected Texture imgMap;                     // use this for displaying it on the map
    protected String description;                 // Items description
    protected Sprite sprite;                      // Sprite to represent the item

    public String getName(){return name;}
    public String getDescription(){return description;}
    public void dispose(){
        imgMap.dispose();
        imgUI.dispose();
    }

}
