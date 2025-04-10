package entity;

import graphics.Animation;
import graphics.Sprite;
import utils.KeyHandler;
import utils.MouseHandler;
import utils.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;

    protected Animation animation;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;

    protected int currentAnimation;

    protected boolean up; // this are gonna be used for movement
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected boolean attack;
    protected int attackSpeed;
    protected int attackDuration;

    protected float dx, dy;
    protected float maxSpeed;
    protected float acc; // acceleration
    protected float deacc;

    public Entity(Sprite sprite, Vector2f origin, int size) {

        this.sprite = sprite;
        this.pos = origin;
        this.size = size;

        this.animation = new Animation();
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 10);
    }

    public void setAnimation(int direction, BufferedImage[] frames, int delay) {

        currentAnimation = direction;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public void animate() {
        if( up ) {
            if ( currentAnimation != UP || animation.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 5);
            }
        }
        else if( down ) {
            if ( currentAnimation != DOWN || animation.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 5);
            }
        }
        else if( right ) {
            if ( currentAnimation != RIGHT || animation.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 5);
            }
        }
        else if( left ) {
            if ( currentAnimation != LEFT || animation.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 5);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation),5 );
        }
    }

    public void update() {
        animate();
       // setHitBoxDirection();
        animation.update();
    }

    public abstract void render(Graphics2D g);
    public void input(KeyHandler key, MouseHandler mouse) {

    }

}
