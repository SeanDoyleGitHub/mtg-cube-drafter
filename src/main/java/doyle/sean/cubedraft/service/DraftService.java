package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.CubeDraftApplication;
import doyle.sean.cubedraft.model.Cube;
import doyle.sean.cubedraft.model.Draft;

import doyle.sean.cubedraft.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DraftService {

    @Autowired
    CubeService cubeService;

    public DraftService(){}

    public Draft createDraft(String cubeId, String draftId){
        Cube cube = cubeService.initCubeFromId(cubeId);
        Draft draft = new Draft(cube);

        CubeDraftApplication.draftsAvailable.put(draftId, draft);

        return draft;
    }

    public Collection<Draft> getAllDrafts(){
        return CubeDraftApplication.draftsAvailable.values();
    }

    public Draft getDraft(String draftId){
        return CubeDraftApplication.draftsAvailable.get(draftId);
    }

    public Draft joinDraft(Player player, String draftId) {
        Draft draft = CubeDraftApplication.draftsAvailable.get(draftId);
        draft.getPlayers().add(player);

        return draft;
    }

    public void deleteDraft(String draftId){
        CubeDraftApplication.draftsAvailable.remove(draftId);
    }
}
