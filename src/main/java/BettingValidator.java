public class BettingValidator implements iBettingValidator{

    @Override
    public boolean checkFunds(Player player, int bet) {
       int funds= player.getChips();
       if(funds<=0){
           return false;
       }
       if((funds-bet)>=0){
           return true;
       }
     return false;
    }

}
