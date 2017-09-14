import javax.swing.*;
import java.awt.*;

class PlayField extends JPanel {
    private Player player;
    PlayField(Player player){
        this.player = player;

    }
    public void paint(Graphics g) {
        player.draw(g);
    }
}
