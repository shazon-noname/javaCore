package Collections.CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.initPlayers();
        ArrayList<String> winners = game.getPlayers();

        for (String winner : winners) {
            System.out.println(winner);
        }
    }

    ArrayList<String> players;
    public static final int WINNERS_CONT = 3;

    public Game() {
        this.players = new ArrayList<>() ;
    }

    public void initPlayers() {
        players.add("Player1");
        players.add("Player2");
        players.add("Player3");
        players.add("Player4");
        players.add("Player5");
    }

    public ArrayList<String> getPlayers() {
        Collections.shuffle(players);
        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < WINNERS_CONT; i++) {
            winners.add(players.get(i));
        }
        return winners;
    }
}
