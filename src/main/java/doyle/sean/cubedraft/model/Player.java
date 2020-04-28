package doyle.sean.cubedraft.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {

    @NonNull private String id;
    @NonNull private String name;
    private List<Card> cards = new ArrayList<>();

}
