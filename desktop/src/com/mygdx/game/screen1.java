package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class screen1 implements Screen{
    Drop game;
    Texture back;
    Texture mode;
    Texture select;
    Texture mode1;
    Texture select1;
    Texture back1;

    public static final float width = 410;
    public static final float heigth = 90;
    public screen1(Drop game){
        this.game= game;
        back = new Texture("hs.png");
        mode = new Texture("mode.png");
        select = new Texture("select.png");
        select1 = new Texture("select1.png");
        mode1 = new Texture("mode1.png");
        back1 = new Texture("back.png");
    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        float x = 829;
        float y = 250;
        float y2 = 350;
        float x2 = 829;
        float b1 = 17;
        float b2 = 600;
        game.batch.draw(back,0,0);
        if(Gdx.input.getY() < 113 && Gdx.input.getX()< 130 && Gdx.input.getY() > 36 && Gdx.input.getX() > 46){
            game.batch.draw(back1,b1+10, b2, 400, 80);
            if(Gdx.input.isTouched()){
                game.setScreen(new mainmenuscreen(game));
            }
        }else{
            game.batch.draw(back1,b1, b2, width , heigth);
        }
        if(Gdx.input.getX() < 1230 && Gdx.input.getX() > 845 && Gdx.input.getY() < 451 && Gdx.input.getY() > 393){
            game.batch.draw(select, x,y, width, heigth);
            if(Gdx.input.isTouched()){
                game.setScreen(new tankselector(game));
            }
        }else{
            game.batch.draw(select1, x, y,  width, heigth);
        }
        if( Gdx.input.getX() <1230 && Gdx.input.getX() > 845 && Gdx.input.getY() > 294 && Gdx.input.getY() <356){
            game.batch.draw(mode, x2,y2,  width, heigth);
            if(Gdx.input.isTouched()){
                game.setScreen(new GameScreen(game));
            }
        }else{
            game.batch.draw(mode1, x2, y2, width, heigth);
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
