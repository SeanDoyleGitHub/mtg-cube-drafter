package doyle.sean.cubedraft.model;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cube {

    private List<Card> cards;
    private int cubeSize;

}
