package doyle.sean.cubedraft.model.scryfall;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashMap;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class CardFace {
    @JsonProperty
    private String name;

    @JsonProperty("image_uris")
    private LinkedHashMap<String, String> imageUris;

}
