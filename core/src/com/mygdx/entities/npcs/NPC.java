package com.mygdx.entities.npcs;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.entities.Entity;
import com.mygdx.radiant.CollisionDetector;

public class NPC extends Entity {

    public NPC(TiledMapTileLayer collisionLayer, Vector2 position, Sprite sprite) {
        super(collisionLayer, position, sprite);
    }

}
