import com.sun.media.jfxmedia.events.PlayerStateEvent;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerInput extends JPanel implements KeyListener{

    Player player;

    public PlayerInput(Player p){
        this.player = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 37) /*player.x -= 1*/ System.out.println(".");
        else if (key == 38) player.y -= 1;
        else if (key == 39) player.x += 1;
        else if (key == 40) player.y += 1;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
