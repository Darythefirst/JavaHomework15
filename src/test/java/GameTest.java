import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {
    Player player1 = new Player(13, "Kesha", 6);
    Player player2 = new Player(84, "Masha", 5);
    Player player3 = new Player(2, "Dasha9", 8);
    Player player4 = new Player(23, "Goshan", 6);

    @Test
    public void testRoundFirstWins() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(1, game.round("Dasha9", "Masha"));
    }

    @Test
    public void testRoundSecondWins() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(2, game.round("Masha", "Goshan"));
    }

    @Test
    public void testRoundEquals() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertEquals(0, game.round("Goshan", "Kesha"));
    }

    @Test
    public void testRoundFirstNotRegistrated() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nina", "Kesha");
        });
    }

    @Test
    public void testRoundSecondNotRegistrated() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Masha", "Cloe");
        });
    }

    @Test
    public void testRoundBothNotRegistrated() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Nina", "Agent007");
        });
    }
}
