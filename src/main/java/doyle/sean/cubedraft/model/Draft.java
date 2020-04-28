package doyle.sean.cubedraft.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class Draft {

    @NonNull private Cube cube;
    private Map<String, Player> players = new HashMap<>();
    private Map<String, BoosterPack> boosterPacks = new HashMap<>();

}
