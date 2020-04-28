package doyle.sean.cubedraft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BoosterPack {

    private Map<String, Card> cards = new HashMap<>();

}
