package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class Draft {

    @NonNull private Cube cube;
    private List<Player> players = new ArrayList<>();
    private Set<BoosterPack> boosterPacks = new HashSet<>();

}
