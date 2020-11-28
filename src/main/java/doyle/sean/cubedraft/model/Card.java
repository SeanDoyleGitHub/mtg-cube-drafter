package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Card {
    @NonNull private String name;
    @NonNull private String cmc;
    @NonNull private String rarity;
    private List<String> cardImageUrl = new ArrayList<>();
}

