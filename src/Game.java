public class Game {
    public Game(){
        Player player = new Player();
        PlayField playField = new PlayField(player);
        Window framePanel = new Window(playField);
    }
}
