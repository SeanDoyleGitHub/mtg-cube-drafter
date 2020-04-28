package doyle.sean.cubedraft.controller;

import doyle.sean.cubedraft.model.BoosterPack;
import doyle.sean.cubedraft.model.Draft;
import doyle.sean.cubedraft.model.Player;
import doyle.sean.cubedraft.service.DraftService;
import doyle.sean.cubedraft.service.PlayerService;

import java.util.Collection;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DraftController {

    private final DraftService draftService;
    private final PlayerService playerService;

    public DraftController(DraftService draftService, PlayerService playerService) {
        this.draftService = draftService;
        this.playerService = playerService;
    }

    @PostMapping("/draft/new")
    @ResponseStatus(HttpStatus.OK)
    public Draft createNewDraft(@RequestBody Map<String, String> json) {
        String cubeId = json.get("cubeId");
        String draftId = json.get("draftId");
        return draftService.createDraft(cubeId, draftId);
    }

    @PutMapping("/draft/start")
    @ResponseStatus(HttpStatus.OK)
    public Draft startDraft(@RequestBody Map<String, String> json){
        String draftId = json.get("draftId");
        return draftService.startDraft(draftId);
    }

    @PostMapping("/draft/join")
    @ResponseStatus(HttpStatus.OK)
    public Player joinDraft(@RequestBody Map<String, String> json) {
        String draftId = json.get("draftId");
        String playerName = json.get("playerName");
        return playerService.createPlayer(playerName, draftId);
    }

    @GetMapping("/drafts")
    public Collection<Draft> getAllDrafts(){
        return draftService.getAllDrafts();
    }

    @GetMapping("/draft/{id}")
    public Draft getDrafts(@PathVariable String id){
        return draftService.getDraft(id);
    }

    @GetMapping("/draft/{draftId}/players")
    public Map<String, Player> getAllDraftPlayers(@PathVariable String draftId){
        return draftService.getAllPlayersFromDraft(draftId);
    }

    @GetMapping("/draft/{draftId}/player/{playerId}")
    public Player getDraftPlayer(@PathVariable String draftId, @PathVariable String playerId){
        return draftService.getPlayerFromDraft(draftId, playerId);
    }

    @GetMapping("/draft/{draftId}/boosterPacks")
    public Map<String, BoosterPack> getAllDraftBoosterPacks(@PathVariable String draftId){
        return draftService.getAllBoosterPacksFromDraft(draftId);
    }

    @GetMapping("/draft/{draftId}/boosterPack/{boosterPackId}")
    public BoosterPack getDraftBoosterPack(@PathVariable String draftId, @PathVariable String boosterPackId){
        return draftService.getBoosterPackFromDraft(draftId, boosterPackId);
    }

    @DeleteMapping("/draft/{id}/end")
    public void deleteDraft(@PathVariable String id){
        draftService.deleteDraft(id);
    }

}
