import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    HashMap<Player, String> registratedPlayers = new HashMap<>();

    public void register(Player player) {
        registratedPlayers.put(player, player.getName());
    }

    public int round(String playerName1, String playerName2) {
        Player playerOne = findByName(playerName1);
        Player playerTwo = findByName(playerName2);
        if (playerOne == null || playerTwo == null) {
            throw new NotRegisteredException("Кто-то из пользователей не зарегистрирован :) Для турнира нужна регистрация");
        }
        if (playerOne.getStrength() > playerTwo.getStrength()) {
            return 1;
        }
        if (playerOne.getStrength() < playerTwo.getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String playerName) {
        for (Player key : registratedPlayers.keySet()) {
            if (key.getName().equals(playerName)) {
                return key;
            }
        }
        return null;
    }
}
