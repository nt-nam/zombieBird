package com.mygdx.zombiebird.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.zombiebird.zbhelpers.AssetLoader;

public class Bird {
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;
    private Circle boundingCircle;
    private boolean isAlive;

    public Bird(float x, float y, int width, int height){
        this.width =width;
        this.height = height;
        position= new Vector2(x,y);
        velocity = new Vector2(0,0);
        acceleration = new Vector2(0,460);
        boundingCircle = new Circle();
        isAlive = true;
    }

    public void update(float delta){
        velocity.add(acceleration.cpy().scl(delta));

//        if(velocity.y > 200)
//            velocity.y = 200;
//        if(position.y > 192) {
//            velocity.y = -10;
////            position.y = 191;
//        }
        if (position.y < -13) {
            position.y = -13;
            velocity.y = 0;
        }
        position.add(velocity.cpy().scl(delta));
        boundingCircle.set(position.x +9, position.y +6,6.5f);

        //xoay
        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -20) {
                rotation = -20;
            }
        }
        if (isFalling() || isAlive) {
            rotation += 480 * delta;
            if (rotation > 90) {
                rotation = 90;
            }

        }

    }
    public boolean isFalling() {
        return velocity.y > 110;
    }

    public boolean shouldntFlap() {
        return velocity.y > 70 || isAlive;
    }
    public void onClick(){
        if(isAlive) {
            AssetLoader.flap.play();
            velocity.y = -140;
        }
    }
    public float getX(){
        return position.x;
    }
    public float getY(){
        return position.y;
    }
    public float getWidth(){
        return width;
    }
    public float getHeight(){
        return height;
    }
    public float getRotation(){
        return rotation;
    }
    public Circle getBoundingCircle() {
        return boundingCircle;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public void die(){
        isAlive = false;
        velocity.y = 0;
    }
    public void decelerate(){
        acceleration.y = 0;
    }

    public void onRestart(int y) {
        rotation = 0;
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 460;
        isAlive = true;
    }
}
