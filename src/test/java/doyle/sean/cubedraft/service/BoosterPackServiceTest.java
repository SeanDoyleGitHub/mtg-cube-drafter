package doyle.sean.cubedraft.service;

import doyle.sean.cubedraft.TestUtils;
import doyle.sean.cubedraft.model.BoosterPack;
import doyle.sean.cubedraft.model.Draft;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoosterPackServiceTest {

    private static BoosterPackService sut;
    private static TestUtils testUtils;

    @BeforeAll
    static void setup(){
        sut = new BoosterPackService();
        testUtils =  new TestUtils();
    }

    @Test
    void createBoostersForDraft() {
        //given
        Draft draft = testUtils.createMockDraftWithPlayers(360, 2);

        //when
        HashMap<String, BoosterPack> boosterPacks = sut.createBoostersForDraft(draft);

        //then
        assertEquals(boosterPacks.size(), 6);
    }
}