package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.Cube;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CubeService {

    private final CubeCobraService cubeCobraService;

    public CubeService(CubeCobraService cubeCobraService){
        this.cubeCobraService = cubeCobraService;
    }

    Cube initCubeFromId(String id) {
        List<String> cubeCardList = cubeCobraService.getCube(id);
        List<Card> cards = new ArrayList<>();

        for (String cardName : cubeCardList ) {
            cards.add(new Card(cardName));
        }

        return new Cube(cards, cards.size());
    }
}
