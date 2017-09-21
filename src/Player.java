import java.awt.*;

class Player {
    int x = 240;
    int y = 530;
    int width = 10;
    int height = 10;


   void draw(Graphics g){
        g.drawRect(x, y, width, height);
        System.out.println(x + " " + y +" "+ width+" "+ height);
    }

}
