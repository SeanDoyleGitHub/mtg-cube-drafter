package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Player {
    @NonNull private String id;
    @NonNull private String name;
    private List<Card> cards = new ArrayList<>();
}
