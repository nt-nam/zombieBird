package com.mygdx.zombiebird;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.zombiebird.ZombieBird;
import com.mygdx.zombiebird.gamebird.ZBGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode((int) (272*1.5),(int)(408*1.5));
		config.setTitle("Zombie Bird");
		new Lwjgl3Application(new ZBGame(), config);
	}
}
