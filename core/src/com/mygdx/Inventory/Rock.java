package com.mygdx.Inventory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by coolc on 12/5/2016.
 */

public class Rock extends Item {

    public Rock(){
        name = "Rock";
        description = "Basic stone, pretty hard ...maybe";
        imgMap = new Texture(Gdx.files.internal("RockBasic.png"));
    }
}
