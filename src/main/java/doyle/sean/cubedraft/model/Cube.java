package doyle.sean.cubedraft.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cube {

    private List<Card> cards;
    private int cubeSize;

}
