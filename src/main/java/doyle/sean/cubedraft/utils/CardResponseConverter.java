package doyle.sean.cubedraft.utils;

import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.scryfall.CardFace;
import doyle.sean.cubedraft.model.scryfall.CardResponse;

import java.util.ArrayList;
import java.util.List;

public class CardResponseConverter {

    public static Card createFrom(CardResponse cardResponse){
        Card card = new Card(
                cardResponse.getName(),
                cardResponse.getCmc(),
                cardResponse.getRarity()
        );

        card.setCardImageUrl(getImageFromCardResponse(cardResponse));

        return card;
    }

    private static List<String> getImageFromCardResponse(CardResponse cardResponse){
        List<String> cardImages = new ArrayList<>();
        String cardLayout = cardResponse.getLayout().toLowerCase();
        if(cardLayout.equals("normal") ||
                cardLayout.equals("saga") ||
                cardLayout.equals("adventure") ||
                cardLayout.equals("leveler") ||
                cardLayout.equals("split")) {
            cardImages.add(cardResponse.getImageUris().get("large"));
        } else if (cardLayout.equals("transform")) {
            for (CardFace cardFace : cardResponse.getCardFaces()) {
                cardImages.add(cardFace.getImageUris().get("large"));
            }
        } else {
            System.out.println("ERROR - UNKNOWN LAYOUT - " + cardResponse.getLayout() + " \n " + cardResponse.toString());
        }
        return  cardImages;
    }

}
