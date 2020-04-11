
public class Game {
    public enum GameMode {
        ACTIVE,
        BLACK_WIN,
        WHITE_WIN,
        TIE
    }
    private Board board;
    private GameMode status;
}
