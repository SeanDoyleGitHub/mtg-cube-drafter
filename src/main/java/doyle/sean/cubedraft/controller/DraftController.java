package doyle.sean.cubedraft.controller;

import doyle.sean.cubedraft.model.Draft;
import doyle.sean.cubedraft.model.Player;
import doyle.sean.cubedraft.service.DraftService;

import java.util.Collection;

import doyle.sean.cubedraft.service.PlayerService;
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

    @PostMapping("/draft/start")
    @ResponseStatus(HttpStatus.OK)
    public Draft createNewDraft(@RequestBody String cubeId, @RequestBody String draftId) {
        return draftService.createDraft(cubeId, draftId);
    }

    @PostMapping("/draft/join")
    @ResponseStatus(HttpStatus.OK)
    public Player joinDraft(@RequestBody String playerName, @RequestBody String draftId) {
        return playerService.createPlayer(playerName, draftId);
    }

    @GetMapping("/draft")
    public Collection<Draft> getAllDrafts(){
        return draftService.getAllDrafts();
    }

    @GetMapping("/draft/{id}")
    public Draft getDrafts(@PathVariable String id){
        return draftService.getDraft(id);
    }

    @DeleteMapping("/draft/{id}/end")
    public void deleteDraft(@PathVariable String id){
        draftService.deleteDraft(id);
    }

}
