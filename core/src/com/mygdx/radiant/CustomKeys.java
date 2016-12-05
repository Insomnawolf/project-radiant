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

    private ArrayList<Integer> upKeys = new ArrayList<Integer>();         //all the keys that can be pressed to trigger up movemnt
    private ArrayList<Boolean> upKeysdown = new ArrayList<Boolean>();
    private boolean moveUp = false;

    private ArrayList<Integer> downKeys= new ArrayList<Integer>();
    private ArrayList<Boolean> downKeysdown = new ArrayList<Boolean>();

    private boolean moveDown;

    private ArrayList<Integer> leftKeys = new ArrayList<Integer>();
    private ArrayList<Boolean> leftKeysdown = new ArrayList<Boolean>();
    private boolean moveLeft;

    private ArrayList<Integer> rightKeys = new ArrayList<Integer>();
    private ArrayList<Boolean> rightKeysdown = new ArrayList<Boolean>();
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
                downKeysdown.add(false);
                break;
            case 2:
                leftKeys.add(keycode);
                leftKeysdown.add(false);
                break;
            case 3:
                rightKeys.add(keycode);
                rightKeysdown.add(false);
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
                        downKeysdown.set(i, true);
                        return;
                    }
                }
            //    break;
            //case 2:
                for(int i = 0; i < leftKeys.size(); i++){
                    if(keycode == leftKeys.get(i)){
                        moveLeft = true;
                        leftKeysdown.set(i, true);
                        return;
                    }
                }
            //    break;
            //case 3:
                for(int i = 0; i < rightKeys.size(); i++){
                    if(keycode == rightKeys.get(i)){
                        moveRight = true;
                        rightKeysdown.set(i, true);
                        return;
                    }
                }
    }
    public void releasekey(int keycode){

        //******for the up key

        //check each entry if an upkey matches the key pressed (keycode)
        for(int i = 0; i < upKeys.size(); i++) {

            //if a match is found
            if(keycode == upKeys.get(i)) {
                //set that specific key to false
                upKeysdown.set(i,false);

                //check if any other keys of same value are still pressed
                for(int j = 0; j < upKeysdown.size();j++ ){
                    //if there are any keys left still down, do not change boolean value
                    if(upKeysdown.get(j)== true){
                        return;
                    }
                }
                //if you get to here that means all keys are released
                moveUp = false;
            }
        }
        //////down
        for(int i = 0; i < downKeys.size(); i++) {

            //if a match is found
            if(keycode == downKeys.get(i)) {
                //set that specific key to false
                downKeysdown.set(i,false);

                //check if any other keys of same value are still pressed
                for(int j = 0; j < downKeysdown.size();j++ ){
                    //if there are any keys left still down, do not change boolean value
                    if(downKeysdown.get(j)== true){
                        return;
                    }
                }
                //if you get to here that means all keys are released
                moveDown = false;
            }
        }
        ///////left
        for(int i = 0; i < leftKeys.size(); i++) {

            //if a match is found
            if(keycode == leftKeys.get(i)) {
                //set that specific key to false
                leftKeysdown.set(i,false);

                //check if any other keys of same value are still pressed
                for(int j = 0; j < leftKeysdown.size();j++ ){
                    //if there are any keys left still down, do not change boolean value
                    if(leftKeysdown.get(j)== true){
                        return;
                    }
                }
                //if you get to here that means all keys are released
                moveLeft = false;
            }
        }
        ///////right
        for(int i = 0; i < rightKeys.size(); i++) {

            //if a match is found
            if(keycode == rightKeys.get(i)) {
                //set that specific key to false
                rightKeysdown.set(i,false);

                //check if any other keys of same value are still pressed
                for(int j = 0; j < rightKeysdown.size();j++ ){
                    //if there are any keys left still down, do not change boolean value
                    if(rightKeysdown.get(j)== true){
                        return;
                    }
                }
                //if you get to here that means all keys are released
                moveRight = false;
            }
        }
        //////

    }



    public boolean getMoveUp(){return moveUp;}
    public boolean getMoveDown(){return moveDown;}
    public boolean getMoveLeft(){return moveLeft;}
    public boolean getMoveRight(){return moveRight;}

}
