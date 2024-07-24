package com.mygdx.zombiebird.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.zombiebird.gameworld.GameRenderer;
import com.mygdx.zombiebird.gameworld.GameWorld;
import com.mygdx.zombiebird.zbhelpers.InputHandler;

public class GameScreen implements Screen {
    private GameRenderer gameRenderer;
    private GameWorld gameWorld;
    private float runTime;
    public GameScreen(){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        Gdx.app.log("GameScreen",gameHeight+"");
        int midPointY = (int) (gameHeight / 2);

        gameWorld = new GameWorld(midPointY);
        gameRenderer = new GameRenderer(gameWorld, (int) gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld.getBird()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen","show called");
    }

    @Override
    public void render(float delta) {
//        Gdx.app.log("GameScreen FPS",(1/delta) + "");
        runTime += delta;
        gameWorld.update(delta);
        gameRenderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen","pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen","resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen","hide called");
    }

    @Override
    public void dispose() {
        //??
    }
}
