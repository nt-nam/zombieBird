package com.mygdx.zombiebird.zbhelpers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.zombiebird.gameobjects.Bird;
import com.mygdx.zombiebird.gameworld.GameWorld;

public class InputHandler implements InputProcessor {
    private Bird bird;
    private GameWorld gameWorld;
    public InputHandler(GameWorld gameWorld){
        this.gameWorld = gameWorld;
        bird = gameWorld.getBird();

    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(gameWorld.isReady())
            gameWorld.start();
        bird.onClick();
        if (gameWorld.isGameOver())
            gameWorld.restart();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
