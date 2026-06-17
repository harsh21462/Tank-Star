package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class hud {
    public static float fuel = 20;
    public static float fuel1 = 20;
    public Stage stage;
    private Viewport viewport;
    private Integer world;
    private float p1;
    private float p2;
    private float timecount;
    private Integer health;
    private Label countdownlabel;
    private Label healthlabel;
    private Label f1;
    private Label f2;
    public hud(SpriteBatch sb){
        world = 1000;
        timecount = 0;
        health = 1000;
        p1 = 20;
        p2 = 20;
        viewport = new FitViewport(1280, 720, new OrthographicCamera());
        stage = new Stage(viewport, sb);
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        countdownlabel = new Label(String.format("Health PLayer1 \n%04d", world), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthlabel =new Label(String.format("Health PLayer2 \n%04d", health), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        f1 = new Label(String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nFuel1 \n%03f: ", fuel), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        f2 = new Label(String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nFuel2: \n%03f", fuel1), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        table.add(healthlabel).expandX().padTop(10);
        table.add(countdownlabel).expandX().padTop(10);
        table.row();
        table.add(healthlabel).expandX();
        table.add(countdownlabel).expandX();
        table.row();
        table.add(f1);
        table.add(f2);
        stage.addActor(table);


    }
    public void update(float dp){
        fuel -= dp;
        if(fuel >=0 ){
            p1--;
            f1.setText(String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nFuel1 \n%03f: ",fuel));
        }
        fuel1 -= dp;
        if(fuel1 >=0 ){
            p2--;
            f2.setText(String.format("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nFuel1 \n%03f: ",fuel1));
        }
    }
}
