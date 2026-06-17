package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class resume implements Screen {
    Drop game;
    Texture main;
    Texture play;
    Texture save;
    Texture img;
    public resume(Drop game){
        this.game= game;
        main = new Texture("mainmenu.png");
        play = new Texture("final.png");
        save = new Texture("save.png");
        img = new Texture("trrr.png");

    }
    public static final float width = 310;
    public static final float heigth = 90;
    public static final float width1 = 290;
    public static final float heigth1 = 80;
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.music.stop();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(img, 0, 0);
        if(Gdx.input.getY() < 254 && Gdx.input.getY() > 183 && Gdx.input.getX() < 776 && Gdx.input.getX() > 499){
            game.batch.draw(main, 490, 460, width1, heigth1);
            if(Gdx.input.isTouched()){
                game.music.play();
                game.setScreen(new mainmenuscreen(game));
            }
        }else{
            game.batch.draw(main, 480, 460, width, heigth);
        }
        if(Gdx.input.getY() < 355 && Gdx.input.getY() > 279 && Gdx.input.getX() < 770 && Gdx.input.getX() > 492){
            game.batch.draw(save, 490, 360, width1, heigth1);
            if(Gdx.input.isTouched()){
                game.music.play();
                game.setScreen(new mainmenuscreen(game));
            }
        }else{
            game.batch.draw(save, 480, 360, width, heigth);
        }
        if( Gdx.input.getX() <641 && Gdx.input.getX() > 581 && Gdx.input.getY() > 372 && Gdx.input.getY() <448){
            game.batch.draw(play, 570, 260, width1, heigth1);
            if(Gdx.input.isTouched()){
                game.music.play();
                game.setScreen(new GameScreen(game));
            }
        }else{
            game.batch.draw(play, 560, 260, width, heigth);
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
