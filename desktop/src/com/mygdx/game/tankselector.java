package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
interface tank {
    void Position(float f);
    void Orientation(int i);
    void Health(int i);
    void Power();
    void Trajectory_angle();
}

class Frost implements  tank {
    private int fuel_exhaust_limit;
    private int weapon_damage;
    private int speed;
    private int health;
    private int pos;
    private int orientation;
    Frost(int f, int w, int s, int h, int p, int o){
        this.weapon_damage = w;
        this.fuel_exhaust_limit = f;
        this.speed = s;
        this.health = h;
        this.pos = p;
        this.orientation = o;
    }

    @Override
    public void Position(float f) {

    }

    @Override
    public void Orientation(int i) {

    }

    @Override
    public void Health(int i) {

    }

    @Override
    public void Power() {

    }

    @Override
    public void Trajectory_angle() {

    }


    void setWeapon_damage(int i) {
        this.weapon_damage = weapon_damage;
    }

    void getWeapon_damage() {

    }

}
class Buratino implements  tank {

    private int fuel_exhaust_limit;
    private int weapon_damage;
    private int speed;
    private int health;
    private int pos;
    private int orientation;
    Buratino(int f, int w, int s, int h, int p, int o){
        this.weapon_damage = w;
        this.fuel_exhaust_limit = f;
        this.speed = s;
        this.health = h;
        this.pos = p;
        this.orientation = o;
    }

    @Override
    public void Position(float f) {

    }

    @Override
    public void Orientation(int i) {

    }

    @Override
    public void Health(int i) {

    }

    @Override
    public void Power() {

    }

    @Override
    public void Trajectory_angle() {

    }


    void setWeapon_damage(int i) {
        this.weapon_damage = weapon_damage;
    }

    void getWeapon_damage() {

    }
}

    class Abrams implements tank {

        private int fuel_exhaust_limit;
        private int weapon_damage;
        private int speed;
        private int health;
        private int pos;
        private int orientation;
        Abrams(int f, int w, int s, int h, int p, int o){
            this.weapon_damage = w;
            this.fuel_exhaust_limit = f;
            this.speed = s;
            this.health = h;
            this.pos = p;
            this.orientation = o;
        }

        @Override
        public void Position(float f) {

        }

        @Override
        public void Orientation(int i) {

        }

        @Override
        public void Health(int i) {

        }

        @Override
        public void Power() {

        }

        @Override
        public void Trajectory_angle() {

        }


        void setWeapon_damage(int i) {
            this.weapon_damage = weapon_damage;
        }

        void getWeapon_damage() {

        }

}

    public class tankselector implements Screen {
        Drop game;
        private Texture img;
        private Texture back1;
        private Texture buratino;
        private Texture frost;
        private Texture abrams;
        private Texture resume;
        public static final float width = 310;
        public static final float heigth = 90;
        public static final float width1 = 290;
        public static final float heigth1 = 80;
        public tank finaltank = null;


        public tankselector(Drop game) {
            this.game = game;
            img = new Texture("tank.png");
            back1 = new Texture("back.png");
            buratino = new Texture("buratino.png");
            frost = new Texture("frost.png");
            abrams = new Texture("abrams.png");
            resume = new Texture("resume.png");
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
            game.batch.draw(img, 0, 0);
            if (Gdx.input.getX() < 770 && Gdx.input.getX() > 499 && Gdx.input.getY() > 508 && Gdx.input.getY() < 566) {
                game.batch.draw(buratino, 490, 126, width1, heigth1);
                if (Gdx.input.isTouched()) {
                    finaltank = new Buratino(10,10,10,10,10,10 );
                    game.setScreen(new GameScreen(game));
                }
            } else {
                game.batch.draw(buratino, 480, 126, width, heigth);
            }
            if (Gdx.input.getX() < 425 && Gdx.input.getX() > 135 && Gdx.input.getY() > 508 && Gdx.input.getY() < 576) {
                game.batch.draw(frost, 135, 126, width1, heigth1);

                if (Gdx.input.isTouched()) {
                    finaltank = new Frost(10,10,10,10,10,10 );
                    game.setScreen(new GameScreen(game));
                }
            } else {
                game.batch.draw(frost, 125, 126, width, heigth);
            }
            if (Gdx.input.getX() < 1121 && Gdx.input.getX() > 845 && Gdx.input.getY() > 508 && Gdx.input.getY() < 576) {
                game.batch.draw(abrams, 830, 126, width1, heigth1);
                if (Gdx.input.isTouched()) {
                    finaltank = new Abrams(10,10,10,10,10,10 );
                    game.setScreen(new GameScreen(game));
                }
            } else {
                game.batch.draw(abrams, 820, 126, width, heigth);
            }

            if (Gdx.input.getY() < 113 && Gdx.input.getX() < 130 && Gdx.input.getY() > 36 && Gdx.input.getX() > 46) {
                game.batch.draw(back1, b1, b2, width1, heigth1);
                if (Gdx.input.isTouched()) {
                    game.setScreen(new screen1(game));
                }
            } else {
                game.batch.draw(back1, b1, b2, width, heigth);
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

