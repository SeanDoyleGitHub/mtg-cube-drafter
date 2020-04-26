package doyle.sean.cubedraft.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class Card {

    @NonNull private String cardName;
    private boolean isDrafted = false;

}
