package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Draft {
    @NonNull private Cube cube;
    private Map<String, Player> players = new HashMap<>();
    private Map<String, BoosterPack> boosterPacks = new HashMap<>();
}
