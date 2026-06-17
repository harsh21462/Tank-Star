package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.*;
public class assets {
    public static Texture texture_back;
    public static Sprite sprite_back;
    public static  Texture texture_sheet;
    public static void load(){
       texture_back = new Texture(Gdx.files.internal("lovleen.png"));
        texture_back.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        sprite_back = new Sprite(texture_back);
        sprite_back.flip(false, true);
//        texture_sheet = new Texture(Gdx.files.internal("spritesheet.png"));

    }
}
