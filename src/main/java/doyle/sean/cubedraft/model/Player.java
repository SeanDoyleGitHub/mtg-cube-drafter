package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {

    @NonNull private int id;
    @NonNull private String name;
    private List<String> cards;

}
