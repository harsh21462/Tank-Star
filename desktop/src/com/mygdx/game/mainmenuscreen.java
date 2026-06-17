package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class mainmenuscreen implements Screen {

    Drop game;
    Texture exitbuttonactive;
    Texture exitbuttoninactive;
    Texture playbuttonactive;
    Texture playbuttoninactive;
    Texture loadbuttoninactive;
    Texture loadbuttonactive;
    Texture back;
    Sound sound;
    Music music;

    private static final float exit_button_width = 410;
    private static final float exit_button_height = 90;
    private static final float play_button_width = 410;
    private static final float play_button_height = 90;
    private static final float load_button_width = 410;
    private static final float load_button_height = 90;


    public mainmenuscreen(Drop game){
        this.game= game;
        playbuttonactive = new Texture("nv.png");
        playbuttoninactive = new Texture("newgamebutton.png");
        exitbuttoninactive = new Texture("exitbutton.png");
        exitbuttonactive = new Texture("ex.png");
        loadbuttoninactive = new Texture("sv.png");
        loadbuttonactive = new Texture("sav1.png");

       // back = new Texture("hs.png");
        back = game.assets.get("hs.png", Texture.class);
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        float x = 300 + Drop.WIDTH / 2 - exit_button_width / 2 + 80;
        float y = Drop.HEIGHT/2 - exit_button_height/2 - 250 + 50;
        float y2 = Drop.HEIGHT/2 - play_button_height /2  - 100 + 50;
        float x2 = 300+ Drop.WIDTH/2 - play_button_width/2 + 80;
        float y1 = Drop.HEIGHT/2 - load_button_height /2 +50 + 50;
        float x1 = 300+ Drop.WIDTH/2 - load_button_width/2 + 80;
        game.batch.draw(back,0,0);
        if( Gdx.input.getX() < x+exit_button_width && Gdx.input.getX() > x && Gdx.input.getY() > 600 - y && Gdx.input.getY() < 600 - y + exit_button_height){
            game.batch.draw(exitbuttonactive, x,y, exit_button_width, exit_button_height);
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }else{
            game.batch.draw(exitbuttoninactive, x, y, exit_button_width, exit_button_height);
        }
        if( Gdx.input.getX() < 1216 && Gdx.input.getX() > 820 && Gdx.input.getY() < 303 && Gdx.input.getY() > 223){
            game.batch.draw(playbuttonactive, x1,y1, play_button_width, play_button_height);
            if(Gdx.input.isTouched()){
                game.setScreen(new screen1(game));
            }
        }else{
            game.batch.draw(playbuttoninactive, x1, y1, play_button_width, play_button_height);
        }
        if(Gdx.input.getY() < 437 && Gdx.input.getX() < 1213 && Gdx.input.getX() > 829 && Gdx.input.getX() < 1213 && Gdx.input.getY() > 376) {
            game.batch.draw(loadbuttonactive, x2,y2, load_button_width, play_button_height);
            if(Gdx.input.isTouched()){
                game.setScreen(new savedscreen(game));
            }
        }else{
            game.batch.draw(loadbuttoninactive, x2, y2, load_button_width,  load_button_height);
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
