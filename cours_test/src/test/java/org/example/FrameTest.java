package org.example;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.demomock.FakeGenerateurMot;
import org.example.demomock.LePendu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class FrameTest {

    @Test
    void testStandardSeriesFirstRollIncreasesScore() {
        Frame frame = new Frame();
        frame.roll(4);

        int[] rolls = frame.getRolls();
        assertEquals(4, rolls[0]);
    }

    @Test
    void testStandardSeriesSecondRollIncreasesScore() {
        Frame frame = new Frame();
        frame.roll(4);
        frame.roll(3);

        int[] rolls = frame.getRolls();
        assertEquals(3, rolls[1]);
    }

    @Test
    void testStrikeSeriesNoSecondRoll() {
        Frame frame = new Frame();
        frame.roll(10);

        int[] rolls = frame.getRolls();
        assertEquals(10, rolls[0]);
        assertEquals(true, frame.isStrike());
    }


    private Frame frame;

    @BeforeEach
    void setUp() {
        frame = new Frame();
        frame.roll(4);
        frame.roll(3);
    }

    @Test
    void testStandardSeriesMaxTwoRolls() {
        assertThrows(IllegalArgumentException.class, () -> frame.roll(2));
    }

}

