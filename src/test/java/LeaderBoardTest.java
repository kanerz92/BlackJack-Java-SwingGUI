import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.Mockito.*;

public class LeaderBoardTest {
    IMongoDB mockMongoDB = mock(MongoDB.class);
    ILeaderboard leaderboard = new Leaderboard(mockMongoDB);
    Player mockPlayer = mock(Player.class);
    ArrayList<Player> allPlayers = mock(ArrayList.class);

    @Test
    void testRetrievePlayersIsCalledOnce() {
        //Given: I am a user
        //When: I call returnLeaderboard
        leaderboard.returnLeaderboard(mockPlayer);
        //Then: retrieveAllPlayers is called once
        verify(mockMongoDB, times(1)).retrieveAllPlayers();
    }

    @Test
    void testPlayersAreSorted() {
        //Given: I have players in the database
        ArrayList<Player> allPlayers = mock(ArrayList.class);
        given(mockMongoDB.retrieveAllPlayers()).willReturn(allPlayers);
        //When: I call returnLeaderboard
        leaderboard.returnLeaderboard(mockPlayer);
        //Then: Players are sorted
        verify(allPlayers, times(1)).sort(anyObject());
    }

    @Test
    void testGivenMyDBIsEmptyThenArrayWithOnePlayerReturned() {
        //Given: I have no players
        given(mockMongoDB.retrieveAllPlayers()).willReturn(new ArrayList<Player>());
        //When: I call returnLeaderboard
        int sizeOfLeaderboard = leaderboard.returnLeaderboard(mockPlayer).size();
        //Then: An array of 1 player is returned
        assertEquals(1, sizeOfLeaderboard);
    }

    @Test
    void testGivenMyDBHas1PlayerThenArrayWith2PlayersReturned() {
        //Given: I have 1 player
        ArrayList allPlayers = new ArrayList<Player>();
        for (int i = 0; i < 1; i++) {
            allPlayers.add(mockPlayer);
        }
        given(mockMongoDB.retrieveAllPlayers()).willReturn(allPlayers);
        //When: I call returnLeaderboard
        int sizeOfLeaderboard = leaderboard.returnLeaderboard(mockPlayer).size();
        //Then: An array of 2 players is returned
        assertEquals(2, sizeOfLeaderboard);
    }

    @Test
    void testGivenMyDBHas2PlayersThenArrayWith3PlayersReturned() {
        //Given: I have 2 players
        ArrayList allPlayers = new ArrayList<Player>();
        for (int i = 0; i < 2; i++) {
            allPlayers.add(mockPlayer);
        }
        given(mockMongoDB.retrieveAllPlayers()).willReturn(allPlayers);
        //When: I call returnLeaderboard
        int sizeOfLeaderboard = leaderboard.returnLeaderboard(mockPlayer).size();
        //Then: An array of 3 players is returned
        assertEquals(3, sizeOfLeaderboard);
    }

    @Test
    void testGivenMyDBHas3PlayersThenArrayWith4PlayersReturned() {
        ArrayList allPlayers = new ArrayList<Player>();
        for (int i = 0; i < 3; i++) {
            allPlayers.add(mockPlayer);
        }
        given(mockMongoDB.retrieveAllPlayers()).willReturn(allPlayers);
        //When: I call returnLeaderboard
        int sizeOfLeaderboard = leaderboard.returnLeaderboard(mockPlayer).size();
        //Then: An array of 4 players is returned
        assertEquals(4, sizeOfLeaderboard);
    }

    @Test
    void testGivenMyDBHas4PlayersThenArrayWith4PlayersReturned() {
        ArrayList allPlayers = new ArrayList<Player>();
        for (int i = 0; i < 4; i++) {
            allPlayers.add(mockPlayer);
        }
        given(mockMongoDB.retrieveAllPlayers()).willReturn(allPlayers);
        //When: I call returnLeaderboard
        int sizeOfLeaderboard = leaderboard.returnLeaderboard(mockPlayer).size();
        //Then: An array of 4 players is returned
        assertEquals(4, sizeOfLeaderboard);
    }
}
