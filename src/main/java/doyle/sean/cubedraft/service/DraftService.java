package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.CubeDraftApplication;
import doyle.sean.cubedraft.model.Cube;
import doyle.sean.cubedraft.model.Draft;

import doyle.sean.cubedraft.model.Player;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DraftService {

    private final CubeService cubeService;
    private final BoosterPackService boosterPackService;

    public DraftService(CubeService cubeService, BoosterPackService boosterPackService){
        this.cubeService = cubeService;
        this.boosterPackService = boosterPackService;
    }

    public Draft createDraft(String cubeId, String draftId){
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

    public Collection<Draft> getAllDrafts(){
        return CubeDraftApplication.draftsAvailable.values();
    }

    public Draft getDraft(String draftId){
        return CubeDraftApplication.draftsAvailable.get(draftId);
    }

    void joinDraft(Player player, String draftId) {
        Draft draft = CubeDraftApplication.draftsAvailable.get(draftId);
        draft.getPlayers().add(player);
    }

    public void deleteDraft(String draftId){
        CubeDraftApplication.draftsAvailable.remove(draftId);
    }
}
