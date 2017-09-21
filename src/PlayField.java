import java.awt.Graphics;

import javax.swing.JPanel;

class PlayField extends JPanel{

    private GameControl gamecontrol;
    private Player player = new Player();

    PlayField(GameControl control){
        gamecontrol = control;
        setFocusable(true);
        requestFocusInWindow();
        PlayerInput playerInput = new PlayerInput(player);
        addKeyListener(playerInput);

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gamecontrol.redraw(player, g);
    }

}
