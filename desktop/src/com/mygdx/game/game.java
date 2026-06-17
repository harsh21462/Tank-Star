package com.mygdx.game;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
public class game {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Mygame");
        config.useVsync(true);
        config.setForegroundFPS(30);
        config.setWindowedMode((int) Drop.WIDTH, (int) Drop.HEIGHT);
        config.setResizable(false);
        new Lwjgl3Application(new Drop(), config);
    }
}
