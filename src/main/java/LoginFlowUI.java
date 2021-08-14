public class LoginFlowUI implements ILoginFlowUI{
    IMongoDB db;
    Game game;

    public LoginFlowUI(IMongoDB db, Game game) {
        this.db = db;
        this.game = game;
    }

    public Game flow(String name) {
        Player player = db.retrievePlayer(name);
        if (player == null) {
            player = new Player(name, 100);
            db.create(player);
        }
        game = new Game();
        game.setPlayer(player);
        return game;
    }
}
