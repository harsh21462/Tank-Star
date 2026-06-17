package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Drop extends Game {
	public AssetManager assets;
	public static final float WIDTH = 1280;
	public static final float HEIGHT = 720;
	public SpriteBatch batch;
//	public Actor font;
	Sound sound;
	Music music;
	@Override
	public void create(){
		assets = new AssetManager();
		batch = new SpriteBatch();
		this.setScreen(new loadingscreen(this));
		music = Gdx.audio.newMusic(Gdx.files.internal("sound" +".mp3"));
		music.setLooping(true);
		music.play();

	}
	@Override
	public void render(){
		super.render();
	}
	@Override
	public void dispose(){
		assets.dispose();
	}
}