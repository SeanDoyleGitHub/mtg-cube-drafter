package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.Cube;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CubeService {

    private final CubeCobraService cubeCobraService;
    private final ScryfallService scryfallService;

    public CubeService(CubeCobraService cubeCobraService, ScryfallService scryfallService){
        this.cubeCobraService = cubeCobraService;
        this.scryfallService = scryfallService;
    }

    Cube initCubeFromId(String id) {
        List<String> cubeCards = cubeCobraService.getCube(id);
        List<Card>  cards = scryfallService.getCardData(cubeCards);
        return new Cube(cards, cards.size());
    }
}
