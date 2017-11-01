package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amoroz
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void topScorerIsTheGreatOne() {
        Player player = stats.topScorers(1).get(0);
        assertEquals(player, stats.search("Gretzky"));
    }

    @Test
    public void playersNotInNHLNotIncluded() {
        assertEquals(null, stats.search("Tretiak"));
    }

    @Test
    public void onlyOnePlayerInPittsburgh() {
        if (stats.team("PIT").size() > 1) {
            fail();
        }
        assertEquals("Lemieux", stats.team("PIT").get(0).getName());
    }
}
