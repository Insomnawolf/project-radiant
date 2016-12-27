package com.mygdx.Inventory;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Clifford Hill on 12/26/2016.
 * This class shall be the main class to take care of any type of sword.
 */

public class Sword extends Weapon {

    //constants used for declarations
    public final static int BASIC_SWORD = 0;
    public final static int BROADSWORD = 1;

    public Sword (Vector2 position, int swordType){
        super(position);
        switch(swordType){
            case 0:
                weaponClass = "Basic";
                attackPower = 1;
                break;
            case 1:
                weaponClass = "Broad Sword";
                attackPower = 2;
        }
        pElement = "Cut";

    }
}
