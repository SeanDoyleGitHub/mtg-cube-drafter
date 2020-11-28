package doyle.sean.cubedraft.service;

import com.google.common.collect.Lists;
import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.scryfall.CardResponse;
import doyle.sean.cubedraft.model.scryfall.CollectionRequest;
import doyle.sean.cubedraft.model.scryfall.CollectionResponse;
import doyle.sean.cubedraft.model.scryfall.Identifier;
import doyle.sean.cubedraft.utils.CardResponseConverter;
import lombok.SneakyThrows;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScryfallService {

    private final RestTemplate restTemplate;

    public ScryfallService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Card> getCardData(List<String> cardNames) {
        String urlToQuery = "https://api.scryfall.com/cards/collection";
        List<Card> cards = new ArrayList<>();

        List<Identifier> identifierList = new ArrayList<>();
        for (String cardName : cardNames) {
            Identifier identifier = new Identifier(cardName);
            identifierList.add(identifier);
        }

        List<List<Identifier>> subSetsOfIdentifiersForAPIQuery = Lists.partition(identifierList, 75);
        List<CardResponse> cardsFromResponse = new ArrayList<>();
        for (List<Identifier> identifiers : subSetsOfIdentifiersForAPIQuery) {
            CollectionRequest collectionRequest = new CollectionRequest(identifiers);

            CollectionResponse response = this.restTemplate.postForObject(urlToQuery, collectionRequest, CollectionResponse.class);
            cardsFromResponse.addAll(response.getCards());
        }

        for (CardResponse cardResponse : cardsFromResponse) {
            Card card = CardResponseConverter.createFrom(cardResponse);
            cards.add(card);
        }

        return cards;
    }
}
