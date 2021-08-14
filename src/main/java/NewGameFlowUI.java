public class NewGameFlowUI implements INewGameFlowUI{
    IShuffler shuffler;
    iDealer dealer;

    public NewGameFlowUI(IShuffler shuffler, iDealer dealer) {
        this.shuffler = shuffler;
        this.dealer = dealer;
    }

    public void flow(Game game) {
        game.setPlayerHand(new Hand());
        game.setDealerHand(new Hand());
        game.setDeck(new Deck());
        shuffler = new Shuffler();
        shuffler.shuffle(game.getDeck().getDeck());

        int card;
        for (int i = 0; i < 2; i++) {
            card = dealer.dealACard(game.getDeck().getDeck());
            game.getPlayerHand().addCard(card);
        }
        card = dealer.dealACard(game.getDeck().getDeck());
        game.getDealerHand().addCard(card);
    }
}
