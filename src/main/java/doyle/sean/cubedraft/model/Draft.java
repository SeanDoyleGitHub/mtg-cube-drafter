package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Draft {

    @NonNull private Cube cube;
    private List<Player> players;
    private List<BoosterPack> boosterPacks;

}
