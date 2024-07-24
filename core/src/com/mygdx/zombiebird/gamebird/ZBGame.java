package com.mygdx.zombiebird.gamebird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.zombiebird.screens.GameScreen;
import com.mygdx.zombiebird.zbhelpers.AssetLoader;

public class ZBGame extends Game {
    @Override
    public void create() {
        Gdx.app.log("ZBGame","created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
