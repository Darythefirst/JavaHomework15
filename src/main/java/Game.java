import java.util.ArrayList;

public class Game {

    ArrayList<Player> registratedPlayers = new ArrayList<>();

    public void register(Player player) {
        registratedPlayers.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player playerOne = null;
        Player playerTwo = null;
        for (Player player : registratedPlayers) {
            if (player.getName().equals(playerName1)) {
                playerOne = player;
            }
            if (player.getName().equals(playerName2)) {
                playerTwo = player;
            }
        }
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
}
