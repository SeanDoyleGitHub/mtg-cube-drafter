package doyle.sean.cubedraft.model.scryfall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Identifier {
    @JsonProperty
    String name;
}
