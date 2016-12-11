package com.mygdx.Inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by coolc on 12/5/2016.
 */

public class Rock extends Item {

    public Rock(Boolean onMap, Vector2 position){
        name = "Rock";
        description = "Basic stone, pretty hard ...maybe";
        imgMap = new Texture(Gdx.files.internal("RockBasic.png"));
        //if on the map render it using the map image
        if(onMap)
            sprite = new Sprite(imgMap);
        else
            sprite = new Sprite(imgUI);

        //set its position on the screen
        this.position = position;
        sprite.scale(2);
        sprite.setPosition(position.x+sprite.getWidth(),position.y+sprite.getHeight()/2);


    }
}
