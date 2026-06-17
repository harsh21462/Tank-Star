package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;

public class un extends Sprite {
    public World world;
    public Body b2body;
    public BodyDef bdef;
    public un(World world){
        this.world = world;
        definetank();
    }
    public void definetank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32, 32);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef= new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(20);
        fdef.shape = shape;
        b2body.createFixture(fdef);

    }

}
