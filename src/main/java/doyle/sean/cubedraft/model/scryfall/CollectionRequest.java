package doyle.sean.cubedraft.model.scryfall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CollectionRequest {

    @JsonProperty
    List<Identifier> identifiers;
}
