package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.CubeDraftApplication;
import doyle.sean.cubedraft.TestUtils;
import doyle.sean.cubedraft.model.Card;
import doyle.sean.cubedraft.model.Draft;
import doyle.sean.cubedraft.model.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class DraftServiceTest {

    @MockBean
    private CubeService cubeService;

    @Autowired
    private BoosterPackService boosterPackService;

    @Autowired
    private DraftService sut;

    private TestUtils testUtils = new TestUtils();

    @BeforeEach
    private void setup(){
        given(cubeService.initCubeFromId("testCube")).willReturn(testUtils.createMockCube(360));
    }

    @Test
    void createDraft() {
        //when
        Draft draft = sut.createDraft("testCube", "testDraft");

        //then
        assertEquals(draft.getCube().getCubeSize(), 360);
    }

    @Test
    void startAndGetDraft() {
        //given
        sut.createDraft("testCube", "testDraft");

        //when
        Draft draft = sut.startDraft("testDraft");

        //then
        assertEquals(sut.getDraft("testDraft"), draft);
    }

    @Test
    void joinDraft() {
        //given
        sut.createDraft("testCube", "testDraft");
        Player player = testUtils.createPlayer("0", "test_player");

        //when
        sut.joinDraft(player, "testDraft");

        //then
        assert(sut.getDraft("testDraft").getPlayers().containsValue(player));
    }

    @Test
    void draftCard() {
        //given
        Draft draft = testUtils.createMockDraftWithPlayers(45, 1);
        CubeDraftApplication.draftsAvailable.put("testDraft", draft);

        sut.startDraft("testDraft");

        Map<String, Card> cards = sut.getDraft("testDraft").getBoosterPacks().get("0").getCards();
        Card cardToDraft = (Card) cards.values().toArray()[0];

        //when
        sut.draftCard("testDraft", "0", "0", cardToDraft.getCardName());

        //then
        List<Card> expectedPlayerCards = sut.getDraft("testDraft").getPlayers().get("0").getCards();
            //player has correct card
        assertEquals(expectedPlayerCards.size(), 1);
        assertEquals(expectedPlayerCards.get(0).getCardName(), cardToDraft.getCardName());

            //booster pack no longer has card
        assertFalse(draft.getBoosterPacks().get("0").getCards().containsValue(cardToDraft));
    }

}