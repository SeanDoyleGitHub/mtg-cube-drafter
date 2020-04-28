package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.CubeDraftApplication;
import doyle.sean.cubedraft.model.*;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class DraftService {

    private final CubeService cubeService;
    private final BoosterPackService boosterPackService;

    public DraftService(CubeService cubeService, BoosterPackService boosterPackService) {
        this.cubeService = cubeService;
        this.boosterPackService = boosterPackService;
    }

    public Draft createDraft(String cubeId, String draftId) {
        Cube cube = cubeService.initCubeFromId(cubeId);
        Draft draft = new Draft(cube);

        CubeDraftApplication.draftsAvailable.put(draftId, draft);

        return draft;
    }

    public Draft startDraft(String draftId) {
        Draft draft = CubeDraftApplication.draftsAvailable.get(draftId);
        draft.setBoosterPacks(boosterPackService.createBoostersForDraft(draft));

        return getDraft(draftId);
    }

    public Collection<Draft> getAllDrafts() {
        return CubeDraftApplication.draftsAvailable.values();
    }

    public Draft getDraft(String draftId) {
        return CubeDraftApplication.draftsAvailable.get(draftId);
    }

    void joinDraft(Player player, String draftId) {
        Draft draft = CubeDraftApplication.draftsAvailable.get(draftId);
        draft.getPlayers().put(player.getId(), player);
    }

    public void deleteDraft(String draftId) {
        CubeDraftApplication.draftsAvailable.remove(draftId);
    }

    public Draft draftCard(String draftId, String playerId, String boosterPackId, String cardName) {
        Draft draft = CubeDraftApplication.draftsAvailable.get(draftId);
        BoosterPack boosterPack = draft.getBoosterPacks().get(boosterPackId);
        Card card = boosterPack.getCards().get(cardName);
        Player player = draft.getPlayers().get(playerId);

        player.getCards().add(card);
        boosterPack.getCards().remove(cardName);

        return draft;
    }

    public Map<String, Player> getAllPlayersFromDraft(String draftId) {
        return CubeDraftApplication.draftsAvailable.get(draftId).getPlayers();
    }

    public Player getPlayerFromDraft(String draftId, String playerId) {
        return CubeDraftApplication.draftsAvailable.get(draftId).getPlayers().get(playerId);
    }

    public Map<String, BoosterPack> getAllBoosterPacksFromDraft(String draftId) {
        return CubeDraftApplication.draftsAvailable.get(draftId).getBoosterPacks();
    }

    public BoosterPack getBoosterPackFromDraft(String draftId, String boosterPackId) {
        return CubeDraftApplication.draftsAvailable.get(draftId).getBoosterPacks().get(boosterPackId);
    }

}

