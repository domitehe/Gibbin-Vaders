import java.awt.*;

class Player {
    Rectangle player;
    Player(){
        player = new Rectangle(240,530,10,10);
    }
   void draw(Graphics g){
        g.drawRect(player.x, player.y, player.width, player.height);
    }
    void move(){

    }

}
