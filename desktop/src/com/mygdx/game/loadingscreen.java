package com.mygdx.game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
public class loadingscreen implements Screen {
    Drop game;
    private final ShapeRenderer shapeRenderer;
    private float progress;
    Texture back;
    Texture loading;
    public loadingscreen(Drop game){
        this.game = game;
//        this.progress = 0;
        back = new Texture("hs.png");
        loading = new Texture("loading1.png");
        this.shapeRenderer = new ShapeRenderer();
        queueAssets();
    }

    private void queueAssets(){
        game.assets.load("hs.png", Texture.class);
    }


    @Override
    public void show() {
        System.out.println("screen out");
    }

    private void update(float delta){
        progress = MathUtils.lerp(progress,game.assets.getProgress(),.1f);
        if(game.assets.update() && progress+.000001f==game.assets.getProgress()){
            game.setScreen(new mainmenuscreen(game));
        }
    }
    @Override
    public void render(float delta) {
        update(delta);
        game.batch.begin();
        game.batch.draw(back,0,0);
        game.batch.draw(loading, 300, 50);
        game.batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(300, 80, 500, 50);
        shapeRenderer.setColor(Color.YELLOW);
        shapeRenderer.rect(300,80,progress*500,50);
        shapeRenderer.end();

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
        shapeRenderer.dispose();
    }
}
