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
public class CardResponse {
    @JsonProperty
    private String name;

    @JsonProperty
    private String layout;

    @JsonProperty
    private String cmc;

    @JsonProperty
    private String rarity;

    @JsonProperty("image_uris")
    private LinkedHashMap<String, String> imageUris;

    @JsonProperty("card_faces")
    private CardFace[] cardFaces;
}
