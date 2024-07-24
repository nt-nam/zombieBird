package com.mygdx.zombiebird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.zombiebird.gameobjects.Bird;
import com.mygdx.zombiebird.gameobjects.ScrollHandler;
import com.mygdx.zombiebird.zbhelpers.AssetLoader;

public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;

    private boolean isAlive = true;
    public GameWorld(int midPointY){
        bird = new Bird(33,midPointY -5,17,12);
        scroller = new ScrollHandler(midPointY + 66);
    }
    public void update(float delta){
        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && isAlive) {
            scroller.stop();
            AssetLoader.dead.play();
            isAlive = false;
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }
}
