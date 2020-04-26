package doyle.sean.cubedraft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class BoosterPack {

    Set<Card> cards;

}
