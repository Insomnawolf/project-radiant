package com.mygdx.graphics.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.entities.Player;

/**
 * Created by Edward Mondragon on 11/23/2016.
 */

public class GameScreenInput implements InputProcessor {

    private OrthographicCamera camera;
    private Player player;
    private TiledMapTileLayer collisionLayer;
    private float mobileScale = 1;
    private boolean isPressedUp, isPressedDown, isPressedRight, isPressedLeft;

    public GameScreenInput(Player player, TiledMapTileLayer collisionLayer)
    {
        this.collisionLayer = collisionLayer;
        this.player = player;
        this.camera = player.getCamera();
    }

    public void processInput()
    {
        if(isPressedRight)
            player.setVelocityX(player.getMovementSpeed());
        if(isPressedLeft )
            player.setVelocityX(-player.getMovementSpeed());
        if(isPressedUp)
            player.setVelocityY(player.getMovementSpeed());
        if(isPressedDown)
            player.setVelocityY(-player.getMovementSpeed());
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A || keycode == Input.Keys.LEFT)
            isPressedLeft = true;
        if (keycode == Input.Keys.D || keycode == Input.Keys.RIGHT)
            isPressedRight = true;
        if (keycode == Input.Keys.W || keycode == Input.Keys.UP)
            isPressedUp = true;
        if(keycode == Input.Keys.S || keycode == Input.Keys.DOWN)
            isPressedDown = true;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.A|| keycode == Input.Keys.LEFT)
        {
            player.setVelocityX(0);
            isPressedLeft = false;
        }
        if(keycode == Input.Keys.D || keycode == Input.Keys.RIGHT)
        {
            player.setVelocityX(0);
            isPressedRight = false;
        }
        if(keycode == Input.Keys.W || keycode == Input.Keys.UP)
        {
            player.setVelocityY(0);
            isPressedUp = false;
        }
        if(keycode == Input.Keys.S || keycode == Input.Keys.DOWN)
        {
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
