package src.Collections.CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
        game.initPlayers();
        game.add("Player3");
    }

    ArrayList<String> players;
    public static final int WINNERS_CONT = 3;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void initPlayers() {
        players.add("Player1");
        players.add("Player2");
        players.add("Player4");
        players.add("Player5");
        players.add("Player6");
    }

    public ArrayList<String> getPlayers() {
        Collections.shuffle(players);
        ArrayList<String> winners = new ArrayList<>();
        for (int i = 0; i < WINNERS_CONT; i++) {
            winners.add(players.get(i));
        }
        return winners;
    }

    public boolean add(String player) {
        int index = Collections.binarySearch(players, player);
        if (index >= 0) {
            return false;
        }
        players.add(-index - 1, player);
        for (String item : players) {
            System.out.println(item);
        }
        return true;
    }
}
