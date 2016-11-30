package com.mygdx.graphics.renderer;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edward Mondragon on 11/26/2016.
 */
//comment to push
public class OrthogonalTiledMapSpriteRenderer extends OrthogonalTiledMapRenderer {

    public int randomNumberToBeAbleToPush;
    private Sprite sprite;
    private List<Sprite> sprites;
    private int spritesAfterLayer = 1;

    public OrthogonalTiledMapSpriteRenderer(TiledMap tiledMap)
    {
        super(tiledMap);
        sprites = new ArrayList<Sprite>();
    }

    public void addSprite(Sprite sprite)
    {
        sprites.add(sprite);
    }

    public void render()
    {
        beginRender();
        int currentLayer = 0;
        for(MapLayer layer : map.getLayers())
        {
            if(layer.isVisible())
            {
                if(layer instanceof TiledMapTileLayer)
                {
                    renderTileLayer((TiledMapTileLayer)layer);
                    currentLayer++;
                    if(currentLayer == spritesAfterLayer) {
                        for (Sprite sprite : sprites)
                            sprite.draw(this.getBatch());
                    }
                    else
                    {
                        for(MapObject object: layer.getObjects())
                        {
                            renderObject(object);
                        }
                    }
                }
            }
        }
        endRender();
    }
}
