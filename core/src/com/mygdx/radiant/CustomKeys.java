package com.mygdx.radiant;

import java.util.ArrayList;
/**
 * Created by coolc on 12/3/2016.
 */

public class CustomKeys {

    private ArrayList<Integer> upKeys;         //all the keys that can be pressed to trigger up movemnt
    private boolean moveUp;

    private ArrayList<Integer> downKeys;
    private boolean moveDown;

    private ArrayList<Integer> leftKeys;
    private boolean moveLeft;

    private ArrayList<Integer> rightKeys;
    private boolean moveRight;


    //addkey
    //  keycode: the input.keys.? code replace ? with the appropriate key
    //  keyCommand: A integer that the key is to bind to.
    //      note: if you use constants with integer bindings it will make it easier
    //            like UP = 1

    public void addkey(int keycode, int keyCommand){
        switch(keyCommand){
            case 0:
                upKeys.add(keycode);
                break;
            case 1:
                downKeys.add(keycode);
                break;
            case 2:
                leftKeys.add(keycode);
                break;
            case 3:
                rightKeys.add(keycode);
                break;

        }
    }

    //pushkey
    //simulate the keypress, use this when a key is pressed
    //  keycode: the input.keys code that was pressed
    //
    public void pushkey(int keycode){

        //incomplete
        for(int i = 0; i < upKeys.size(); i++){
            if(keycode == upKeys.get(i)){
                moveUp = true;
            }
        }
        for(int i = 0; i < downKeys.size(); i++){
            if(keycode == downKeys.get(i)){
                moveDown = true;
            }
        }
        for(int i = 0; i < leftKeys.size(); i++){
            if(keycode == leftKeys.get(i)){
                moveLeft = true;
            }
        }
        for(int i = 0; i < rightKeys.size(); i++){
            if(keycode == rightKeys.get(i)){
                moveRight = true;
            }
        }

    }


    public boolean getMoveUp(){return moveUp;}
    public boolean getMoveDown(){return moveDown;}
    public boolean getMoveLeft(){return moveLeft;}
    public boolean getMoveRight(){return moveRight;}

}
