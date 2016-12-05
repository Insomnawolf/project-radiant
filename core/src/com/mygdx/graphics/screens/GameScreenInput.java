package com.mygdx.graphics.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.entities.Player;
import com.mygdx.radiant.CustomKeys;

/**
 * Created by Edward Mondragon on 11/23/2016.
 */

public class GameScreenInput implements InputProcessor {

    private OrthographicCamera camera;
    private Player player;
    private TiledMapTileLayer collisionLayer;
    private double mobileScale = 1;
    private boolean isPressedUp, isPressedDown, isPressedRight, isPressedLeft;
    private CustomKeys mykeys;
    public GameScreenInput(Player player, TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
        this.player = player;
        this.camera = player.getCamera();
        mykeys = new CustomKeys();
        mykeys.addkey(Input.Keys.UP,CustomKeys.UPKEY);
        mykeys.addkey(Input.Keys.W,CustomKeys.UPKEY);
        mykeys.addkey(Input.Keys.DOWN, CustomKeys.DOWNKEY);
        mykeys.addkey(Input.Keys.S, CustomKeys.DOWNKEY);
        mykeys.addkey(Input.Keys.RIGHT, CustomKeys.RIGHTKEY);
        mykeys.addkey(Input.Keys.D, CustomKeys.RIGHTKEY);
        mykeys.addkey(Input.Keys.LEFT, CustomKeys.LEFTKEY);
        mykeys.addkey(Input.Keys.A, CustomKeys.LEFTKEY);

    }

    public void processInput() {
        if(isPressedRight)
            player.setVelocityX(player.getMovementSpeed());
        if(isPressedLeft)
            player.setVelocityX(-player.getMovementSpeed());
        if(isPressedUp)
            player.setVelocityY(player.getMovementSpeed());
        if(isPressedDown)
            player.setVelocityY(-player.getMovementSpeed());
    }

    @Override
    public boolean keyDown(int keycode) {
        mykeys.pushkey(keycode);
            isPressedLeft = mykeys.getMoveLeft();
            isPressedRight = mykeys.getMoveRight();
            isPressedUp = mykeys.getMoveUp();
            isPressedDown = mykeys.getMoveDown();
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        mykeys.releasekey(keycode);
            if(mykeys.getMoveLeft()== false){
                player.setVelocityX(0);
                isPressedLeft = false;
            }

            if(mykeys.getMoveRight()== false){
                player.setVelocityX(0);
                isPressedRight = false;
            }

            if(mykeys.getMoveUp()== false){
                player.setVelocityY(0);
                isPressedUp = false;
            }

            if(mykeys.getMoveUp()== false){
                player.setVelocityY(0);
                isPressedDown = false;
            }


        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 touched = new Vector3(screenX, screenY, 0);
        Vector3 position = camera.unproject(touched);
        mobileScale = Math.abs(position.y/position.x);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        isPressedRight = false;
        isPressedLeft = false;
        isPressedUp = false;
        isPressedDown = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
