package com.mygdx.radiant.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.radiant.RadiantCore;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        // Borderless windowed
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");

        // Size of window when windowed, or resolution when fullscreen
        config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
        config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;

        config.fullscreen = false;

		new LwjglApplication(new RadiantCore(), config);
	}
}
