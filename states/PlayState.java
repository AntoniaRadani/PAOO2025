package states;

import graphics.Font;
import graphics.Sprite;
import utils.KeyHandler;
import utils.MouseHandler;
import utils.Vector2f;

import java.awt.*;

public class PlayState extends GameState{

    private Font font;
    public PlayState(GameStateManager gsm){

        super(gsm);
        font = new Font("res_font/font.png", 16, 16);
    }

    public void update(){

    }



    public void input(MouseHandler mouse, KeyHandler key){
      /*  if(key.up.down){
            System.out.println("W is being pressed");
        } */
    }

    public void render(Graphics2D g){
       /* g.setColor(Color.RED);
        g.fillRect(0, 0, 64, 64); */

        Sprite.drawArray(g, font, "A B C", new Vector2f(100,100), 32,32,16,0);
    }
}
