package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Draft {

    @NonNull private Cube cube;
    private List<Player> players = new ArrayList<>();
    private List<BoosterPack> boosterPacks = new ArrayList<>();

}
