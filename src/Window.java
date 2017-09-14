import javax.swing.*;

public class Window {
    private PlayField playfield;

    public Window(PlayField playField){
        this.playfield = playField;
        createFrame();
    }
    private void createFrame(){
        JFrame frame = new JFrame();
        frame.setTitle("Gibbin' Vaders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setResizable(false);
        frame.add(playfield);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
