package doyle.sean.cubedraft.controller;

import doyle.sean.cubedraft.model.Draft;
import doyle.sean.cubedraft.service.DraftService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PlayerController {

    private final DraftService draftService;

    public PlayerController(DraftService draftService) {
        this.draftService = draftService;
    }

    @PutMapping("/player/draft/card")
    @ResponseStatus(HttpStatus.OK)
    public Draft draftCard(@RequestBody Map<String, String> json) {
        String draftId = json.get("draftId");
        String playerId = json.get("playerId");
        String boosterPackId = json.get("boosterPackId");
        String cardName = json.get("cardName");

        return draftService.draftCard(draftId, playerId, boosterPackId, cardName);
    }


}
