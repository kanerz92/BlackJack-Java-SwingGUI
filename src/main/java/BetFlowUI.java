public class BetFlowUI implements IBetFlowUI{
    iBettingValidator validator;

    public BetFlowUI(iBettingValidator validator) {
        this.validator = validator;
    }
    public boolean flow(int bet, Game game) {
        if(validator.checkFunds(game.getPlayer(), bet)){
            game.setBet(bet);
            return true;

        }
        else return false;
    }
}