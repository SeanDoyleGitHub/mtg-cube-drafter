package doyle.sean.cubedraft;

import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.Cube;
import doyle.sean.cubedraft.model.Draft;
import doyle.sean.cubedraft.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtils {

    public Draft createMockDraft(int cubeSize){
        return new Draft(createMockCube(cubeSize));
    }

    public Draft createMockDraftWithPlayers(int cubeSize, int playerCount){
        Draft draft = new Draft(createMockCube(cubeSize));
        draft.setPlayers(createPlayersForDraft(playerCount));

        return draft;
    }

    public Cube createMockCube(int cubeSize){
        List<Card> cards = createMockListOfCards(cubeSize);
        Cube cube = new Cube(cards, cubeSize);

        return cube;
    }

    private List<Card> createMockListOfCards(int cubeSize) {
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < cubeSize; i++){
            Card card = new Card("fakeCard_" + i, "10", "unicorn");
            cards.add(card);
        }

        return cards;
    }

    private Map<String, Player> createPlayersForDraft(int playerCount){
        Map<String, Player> players = new HashMap<>();

        for(int i = 0; i < playerCount; i++){
            Player player = createPlayer(String.valueOf(i), "Player_" + i);
            players.put(player.getId(), player);
        }

        return players;
    }

    public Player createPlayer(String playerId, String playerName){
        return new Player(playerId, playerName);
    }

}
