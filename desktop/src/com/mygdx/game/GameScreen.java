package com.mygdx.game;
import java.util.ArrayList;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
//import static org.junit.Assert.*;
//import com.javatpoint.logic.*;
//import org.junit.Test;
import org.junit.Assert.*;import java.beans.Transient;
import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class JUnitTutorial{
    public int square(int num){
        return num*num;
    }
}
class squareTest{
    @Test
    public void test(){
        JUnitTutorial test = new JUnitTutorial();
        int fuel = test.square(20);
        int fuel1 = test.square(19);
        int fuel2 = test.square(18);
        assertEquals(20, fuel);
        assertEquals(19, fuel1);
        assertEquals(18, fuel2);
    }
}




class ArenaField{
    private int ArenaLength;
    private int InitialTankPosition;
    private tank q;
    ArenaField(int a, int t){
        this.ArenaLength = a;
        this.InitialTankPosition = t;

    }

    public int getArenaLength() {
        return ArenaLength;
    }

    public void setArenaLength(int arenaLength) {
        ArenaLength = arenaLength;
    }

    public int getInitialTankPosition() {
        return InitialTankPosition;
    }

    public void setInitialTankPosition(int initialTankPosition) {
        InitialTankPosition = initialTankPosition;
    }

    void drop(float f)
    {

    }
}
class Player extends Sprite {
    /*for tracking the movement velocity*/
//    private  Vector2 velocity = new Vector2();
//    private float speed = 60*2,gravity = 60*1.8f;
//    public Player(Sprite sprite)
//    {
//        super(sprite);
//    }
//    public void draw(SpriteBatch spriteBatch)
//    {
//        update(Gdx.graphics.getDeltaTime());
//        super.draw(spriteBatch);
//    }
//    public void update (float delta)
//    {
//        /*calculating new position*/
//
//        /*yaha gravity lag rahi he y me*/
//        velocity.y -= gravity * delta;
//        //clamp velocity
//
//        if(velocity.y>speed)
//            velocity.y = speed;
//        else if ((velocity.y<speed)) {
//            velocity.y = -speed;
//
//        }
//        setX(getX() + velocity.x * delta);
//        setY(getY() + velocity.y * delta);
//    }

    private String Name;
    private int Power;
    private int Trajectory;
    private ArenaField af;
    Player(String s, int p, int t){
        this.Name = s;
        this.Power = p;
        this.Trajectory = t;
        this.af = new ArenaField(500, 2);

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }

    public int getTrajectory() {
        return Trajectory;
    }

    public void setTrajectory(int trajectory) {
        Trajectory = trajectory;
    }
    void TankSelect()
    {

    }
    void fire()
    {

    }
    void exitGame()
    {

    }
    void saveGame()
    {

    }
    void pauseGame()
    {

    }
    void resumeGame()
    {

    }
    void RestartGame()
    {

    }
    /*mine*/
    private float gravity = 60 * 1.8f;

}
class GameMain{
    private Player player1;
    private Player player2;
    GameMain(String s1, String s2, int p1, int p2, int t1, int t2){
        player1 = new Player(s1, p1, t1);
        player2 = new Player(s2, p2, t2);
    }
    public void exitgame(){

    }
    public void savegame(){

    }
    public void pausegame(){

    }
    public void reusumegame(){

    }
    public void restartgame(){

    }
}
public class GameScreen extends InputAdapter implements Screen{
    boolean pause;
    Texture resume;
    private TiledMap map;
    public boolean remove = false;
  //  private ball playe;
    private OrthogonalTiledMapRenderer renderer;
    private TmxMapLoader mapLoader;
    private OrthographicCamera camera;
    Animation[] rolls;
    private Viewport gameport;
    Texture img;
    private Drop game;
    private hud hd;;
    private Box2DDebugRenderer b2dr;

    public static final float width = 1280;
    public static final float heigth = 720;

    Texture back1;

    /*again trying*/
    Stage stage;
    SpriteBatch batch;
    Texture player;
    Texture aim;
    Texture player1;
    Texture ground;
    float Speed = 50.0f;
    float playerx = 150;
    float playery = 73;

    float player1x =  1000;
    float player1y = 73;

    float aim1x = 500;
    float aim1y = 300;


    Rectangle player_rect;
    Rectangle ground_rect;
    boolean ty = true;
    float prevx;
    float prevy;

    float Gravity_Earth = -9.8f;
    Vector2 gravity = new Vector2(0,Gravity_Earth);

    World world = new World(gravity,true);
    BodyDef b;
    ArrayList<Bullet>  bullet;
    public GameScreen(Drop game){
        this.game = game;
        back1 = new Texture("resume.png");
        camera = new OrthographicCamera();
        gameport = new FitViewport(1280, 720, camera);
        hd = new hud(game.batch);
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("Lovleen_final_tileset.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.position.set(620, 360,0);
        world = new World(new Vector2(0,0), true);
        b2dr = new Box2DDebugRenderer();
        PolygonShape shape = new PolygonShape();
        b = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        Body body;
        bullet = new ArrayList<Bullet>();
        rolls = new Animation[5];
        rolls[0] = new Animation(2);
    }
    @Override

    /*mine*/
    public void show() {
        img = new Texture("trrr.png");
        player = new Texture("realabrams.png");
        player1 = new Texture("Frost-removebg-preview.png");

        aim = new Texture("image2.png");

        /*need to replace image*/
        ground = new Texture("temp.png");
        stage = new Stage();
        player_rect = new Rectangle(playerx,playery,player.getWidth(),player.getHeight());
        ground_rect = new Rectangle(0,0,ground.getWidth(),ground.getHeight());

        Gdx.input.setInputProcessor(stage);
        prevx = 150;
        prevy = 300;
        batch = new SpriteBatch();






    }

    public void fire(){

        //missile
        b.type = BodyDef.BodyType.DynamicBody;
        CircleShape ballshape = new CircleShape();
        ballshape.setRadius(5);
        FixtureDef bulletF = new FixtureDef();
        bulletF.shape = ballshape;
        bulletF.density = 0.3f;
        bulletF.friction = 0.4f;
        bulletF.restitution = 0f;
    }
    public void update(float dt){
        handleInput(dt);
        camera.update();
        renderer.setView(camera);
        hd.update(dt);
    }
    public void handleInput(float dt){
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
//            camera.position.x -= 100*dt;
//        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
//            camera.position.x += 100*dt;


    }

    @Override
    public void render(float delta) {
        float b1 = 17;
        float b2 = 600;
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            bullet.add(new Bullet(50));
            bullet.add(new Bullet(50-4));
        }
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
        batch.begin();
//        if(Gdx.input.getY() < 113 && Gdx.input.getX()< 130 && Gdx.input.getY() > 36 && Gdx.input.getX() > 46){
//            game.batch.draw(back1,b1-10, b2, 400, 80);
//            if(Gdx.input.isTouched()){
//                game.setScreen(new resume(game));
//            }
//        }else{
//            game.batch.draw(back1,b1, b2, width , heigth);
//        }
       // game.batch.draw(back1,b1, b2, width , heigth);


        //for saving game condition
        if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            Preferences prefs = Gdx.app.getPreferences("Game-State");

            prefs.putBoolean("soundOn", true);
            prefs.putFloat("playerx", playerx);
            prefs.putFloat("playerx", playery);
            prefs.putFloat("player1x", player1y);
            prefs.putFloat("player1x", player1x);
            prefs.putFloat("fuel",hd.fuel);
            prefs.putFloat("fuel", hd.fuel1);
            prefs.flush();
        }
        if(ty) {
            if(Gdx.input.isKeyPressed(Input.Keys.P)){
                ty = false;
                game.setScreen(new resume(game));
            }
            stage.draw();
            batch.draw(img, 0, 0);
            batch.draw(player, playerx, playery);
            batch.draw(player1, player1x, player1y);
            batch.draw(aim, aim1x, aim1y);
            batch.draw(ground, 0, 0);
            game.batch.setProjectionMatrix(hd.stage.getCamera().combined);
            hd.stage.draw();
            int t1 = 1;
            int t2 = 1;
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                aim1y += Gdx.graphics.getDeltaTime() * Speed;
                if (Gdx.input.isKeyPressed(Input.Keys.G)) {
                    fire();
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                aim1y -= Gdx.graphics.getDeltaTime() * Speed;
                if (Gdx.input.isKeyPressed(Input.Keys.G)) {
                    fire();
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                aim1x -= Gdx.graphics.getDeltaTime() * Speed;
                if (Gdx.input.isKeyPressed(Input.Keys.G)) {
                    fire();
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                aim1x += Gdx.graphics.getDeltaTime() * Speed;
                if (Gdx.input.isKeyPressed(Input.Keys.G)) {
                    fire();
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                if (t1 == 1 && hd.fuel > 0) {
                    {
                        System.out.println("A");

                        playerx -= Gdx.graphics.getDeltaTime() * Speed;
                        hd.fuel = (float) (hd.fuel - 0.5);
                    }
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                if (t1 == 1 && hd.fuel > 0) {
                    // prevx = playerx;
                    System.out.println("D");

                    playerx += Gdx.graphics.getDeltaTime() * Speed;
                    hd.fuel = (float) (hd.fuel - 0.5);
                    t2 = 1;
                    t1 = 0;
                    System.out.println("D");
                    hd.fuel1 = 20;

                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.L)) {
                if (t2 == 1 && hd.fuel1 > 0) {
                    //prevx = playerx;
                    System.out.println("A");

                    player1x += Gdx.graphics.getDeltaTime() * Speed;
                    hd.fuel1 = (float) (hd.fuel1 - 0.5);
                    t2 = 0;
                    t1 = 1;
                    System.out.println("l");
                    hd.fuel = 20;
                }
            }
            if (Gdx.input.isKeyPressed(Input.Keys.J)) {
                if (hd.fuel1 > 0 && t2 == 1) {
                    //prevx = playerx;
                    System.out.println("J");

                    player1x -= Gdx.graphics.getDeltaTime() * Speed;
                    hd.fuel1 = (float) (hd.fuel1 - 0.5);
                }
                t2 = 0;
                t1 = 1;
                System.out.println("L");
                hd.fuel = 20;

            }
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

            }

            player_rect = new Rectangle(playerx, playery, player.getWidth(), player.getHeight());
            ground_rect = new Rectangle(0, 0, ground.getWidth(), ground.getHeight());
            batch.end();
        }


    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = 720;
        camera.viewportWidth = 1280;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
    }

}
