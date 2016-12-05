package com.mygdx.radiant;

import java.util.ArrayList;
/**
 * Created by coolc on 12/3/2016.
 */

public class CustomKeys {
    public static final int UPKEY = 0;
    public static final int DOWNKEY = 1;
    public static final int LEFTKEY = 2;
    public static final int RIGHTKEY = 3;

    private ArrayList<Integer> upKeys;         //all the keys that can be pressed to trigger up movemnt
    private ArrayList<Boolean> upKeysdown;
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
    //      note: Use the constants declared within this class, should make it easier
    //

    public void addkey(int keycode, int keyCommand){
        switch(keyCommand){
            case 0:
                upKeys.add(keycode);
                upKeysdown.add(false);
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
    //  keyCommand: constant to determin which key is pressed

    public void pushkey(int keycode){


        //as more keys are added, make sure to add  the for loop for it?
        //if there is a more efficient way be my guest and edit it in.

        //switch(keyCommand){
          //  case 0:
                for(int i = 0; i < upKeys.size(); i++){
                    if(keycode == upKeys.get(i)){
                        moveUp = true;
                        upKeysdown.set(i, true);
                        return;
                    }
                }
            //    break;
            //case 1:
                for(int i = 0; i < downKeys.size(); i++){
                    if(keycode == downKeys.get(i)){
                        moveDown = true;
                        return;
                    }
                }
            //    break;
            //case 2:
                for(int i = 0; i < leftKeys.size(); i++){
                    if(keycode == leftKeys.get(i)){
                        moveLeft = true;
                        return;
                    }
                }
            //    break;
            //case 3:
                for(int i = 0; i < rightKeys.size(); i++){
                    if(keycode == rightKeys.get(i)){
                        moveRight = true;
                        return;
                    }
                }
    }
    public void releasekey(int keycode){

        //check each entry if an upkey matches the key pressed (keycode)
        for(int i = 0; i < upKeys.size(); i++) {

            //if a match is found
            if(keycode == upKeys.get(i)) {
            //set that specific key to false
            upKeysdown.set(i,false);

                //check if any other keys of same value are still pressed
                for(int ii = 0; ii < upKeysdown.size();i++ ){
                    //if there are any keys left still down, do not change boolean value
                    if(upKeysdown.get(i)){
                        return;
                    }
                }
                //if you get to here that means all keys are released
                moveUp = false;
            }
        }
    }



    public boolean getMoveUp(){return moveUp;}
    public boolean getMoveDown(){return moveDown;}
    public boolean getMoveLeft(){return moveLeft;}
    public boolean getMoveRight(){return moveRight;}

}
