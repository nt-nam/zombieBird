package com.mygdx.zombiebird.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.zombiebird.gameobjects.Bird;
import com.mygdx.zombiebird.gameobjects.ScrollHandler;
import com.mygdx.zombiebird.zbhelpers.AssetLoader;

public class GameWorld {
    private Bird bird;
    private ScrollHandler scroller;
    private Rectangle ground;
    private int score = 0;

    private int midPointY;

    private GameState currentState;
    public enum GameState {
        READY, RUNNING, GAMEOVER
    }
    public GameWorld(int midPointY){
        this.midPointY =  midPointY;
        bird = new Bird(33,midPointY -5,17,12);
//        grass should start 66 pixels below midPointY
        scroller = new ScrollHandler(this,midPointY + 66);
        ground = new Rectangle(0,midPointY+66,136,11);
        currentState = GameState.READY;

    }
    public void update(float delta){

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;

            case RUNNING:
            default:
                updateRunning(delta);
                break;
        }

//        if (delta>.15f){
//            delta = .15f;
//        }
//
//        bird.update(delta);
//        scroller.update(delta);
//
//        if (scroller.collides(bird) && bird.isAlive()) {
//            scroller.stop();
//            bird.die();
////            AssetLoader.dead.play();
////            isAlive = false;
//        }
//
//        if (Intersector.overlaps(bird.getBoundingCircle(),ground)){
//            scroller.stop();
//            bird.die();
////            AssetLoader.dead.play();
//            bird.decelerate();
//
//        }
    }

    private void updateReady(float delta) {

    }

    public void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }

        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;
        }
    }

    public Bird getBird() {
        return bird;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPointY - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }
}
