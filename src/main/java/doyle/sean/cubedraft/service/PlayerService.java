package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.model.Draft;
import doyle.sean.cubedraft.model.Player;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final DraftService draftService;

    public PlayerService(DraftService draftService) {
        this.draftService = draftService;
    }

    public Player createPlayer(String playerName, String draftId) {
        Draft draft = draftService.getDraft(draftId);
        int nextPlayerId = draft.getPlayers().size();

        Player player = new Player(nextPlayerId, playerName);
        draftService.joinDraft(player, draftId);

        return player;
    }
}
