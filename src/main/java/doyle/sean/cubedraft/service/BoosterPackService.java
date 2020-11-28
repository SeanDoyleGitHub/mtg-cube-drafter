package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.model.BoosterPack;
import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.Cube;
import doyle.sean.cubedraft.model.Draft;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

@Service
public class BoosterPackService {

    public HashMap<String, BoosterPack> createBoostersForDraft(Draft draft) {
        int playerTotal = draft.getPlayers().size();
        int boosterPackSize = 15;
        int boostersRequired = 3 * playerTotal;
        int totalCardsRequiredForDraft = boosterPackSize * boostersRequired;
        Cube cubeToDraftFrom = draft.getCube();

        HashSet<Card> cardsToDraftFrom = createCardPoolForBoosters(cubeToDraftFrom, totalCardsRequiredForDraft);

        return createBoostersFromCards(cardsToDraftFrom, boostersRequired, boosterPackSize);
    }

    private HashSet<Card> createCardPoolForBoosters(Cube cubeToDraftFrom, int totalCardsRequiredForDraft){
        Random rng = new Random();
        HashSet<Card> cardsToDraftFrom = new HashSet<>();

        while (cardsToDraftFrom.size() < totalCardsRequiredForDraft) {
            int cubeSize = cubeToDraftFrom.getCards().size();
            int randomCardNumber = rng.nextInt(cubeSize);

            Card card = cubeToDraftFrom.getCards().get(randomCardNumber);

            cardsToDraftFrom.add(card);
            cubeToDraftFrom.getCards().remove(randomCardNumber);
        }

        return cardsToDraftFrom;
    }

    private HashMap<String, BoosterPack> createBoostersFromCards(HashSet<Card> cards, int boostersRequired, int boosterPackSize){
        HashMap<String, BoosterPack> boosterPacks = new HashMap<>();

        for (int currentPack = 0; currentPack < boostersRequired; currentPack++) {
            BoosterPack boosterPack = new BoosterPack();
            for(int cardCount = 0; cardCount < boosterPackSize; cardCount++){
                Card card = cards.iterator().next();
                boosterPack.getCards().put(card.getName(), card);
                cards.remove(card);
            }
            boosterPacks.put(String.valueOf(currentPack), boosterPack);
        }

        return boosterPacks;
    }
}
