package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class savedscreen implements Screen{
    Texture img;
    float x;
    float y;
    private Drop game;
    Texture resume;

    public static final float width = 410;
    public static final float heigth = 90;
    Texture back1;
    public savedscreen(Drop game){
        this.game = game;
        back1 = new Texture("back.png");
        img = new Texture("Saved Games.png");
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        float b1 = 17;
        float b2 = 600;
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(img, x, y);
        if(Gdx.input.getY() < 113 && Gdx.input.getX()< 130 && Gdx.input.getY() > 36 && Gdx.input.getX() > 46){
            game.batch.draw(back1,b1-10, b2, 400, 80);
            if(Gdx.input.isTouched()){
                game.setScreen(new mainmenuscreen(game));
            }
        }else{
            game.batch.draw(back1,b1, b2, width , heigth);
        }
        if(Gdx.input.getY() < 590 && Gdx.input.getX()< 379 && Gdx.input.getY() > 335&& Gdx.input.getX() > 27){
            if(Gdx.input.isTouched()){
                game.setScreen(new GameScreen(game));
            }
        }
        if(Gdx.input.getY() < 590 && Gdx.input.getX()< 812 && Gdx.input.getY() > 335 && Gdx.input.getX() > 467){
            if(Gdx.input.isTouched()){
                game.setScreen(new GameScreen(game));
            }
        }
        if(Gdx.input.getY() < 590 && Gdx.input.getX()< 1242 && Gdx.input.getY() > 335 && Gdx.input.getX() > 896){
            if(Gdx.input.isTouched()){
                game.setScreen(new GameScreen(game));
            }
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
