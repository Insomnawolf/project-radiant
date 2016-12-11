package com.mygdx.Inventory;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Clifford Hill on 12/5/2016.
 */

public class Coin extends Item {
    public Coin(Vector2 position){
        name = "Coin";
        description = "Nice shiny circular form of metal... can be used for money... or food for some creatures.";
        this.position = position;
        sprite.setPosition(position.x,position.y);
    }
}
