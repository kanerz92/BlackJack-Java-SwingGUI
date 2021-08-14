import java.util.Collections;
import java.util.List;

public class Shuffler implements IShuffler{

    @Override
    public void shuffle(List<Integer> deck) {
        Collections.shuffle(deck);
    }

}
