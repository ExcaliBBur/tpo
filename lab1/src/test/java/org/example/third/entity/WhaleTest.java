package org.example.third.entity;

import org.example.third.entity.enums.AwarenessState;
import org.example.third.entity.enums.EmotionalState;
import org.example.third.entity.enums.PositionState;
import org.example.third.exception.IllegalAwarenessStateException;
import org.example.third.exception.IllegalEmotionalStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WhaleTest {
    private Whale whale;

    @BeforeEach
    public void initWhale() {
        whale = new Whale("Китёнок", PositionState.ARTIFICIAL, EmotionalState.HAPPY);
    }

    @Test
    public void checkAwareness() {
        Assertions.assertEquals("WHALE с именем Китёнок, который прежде осознавал " +
                "себя WHALE, начал осознавать себя HUMAN", whale.awareness(AwarenessState.HUMAN));
    }

    @Test
    public void checkUpdateEmotionalState() {
        Assertions.assertEquals("WHALE с именем Китёнок, который прежде чувствовал себя HAPPY, " +
                "начал чувствовать себя NERVOUS", whale.updateEmotionalState(EmotionalState.NERVOUS));
    }

    @Test
    public void checkRealizes() {
        Assertions.assertEquals("WHALE с именем Китёнок cвыкается, что он WHALE", whale.realizes());
    }

    @Test
    public void checkReconcile() {
        whale.awareness(AwarenessState.NOT_WHALE);
        Assertions.assertEquals("WHALE с именем Китёнок пришлось свыкнуться с осознанием того, " +
                "что он стал NOT_WHALE", whale.reconcile());
    }

    @Test
    public void checkPositionState() {
        Assertions.assertEquals("Китёнок находится в ARTIFICIAL положении", whale.getPositionState());
    }
    @Test
    public void checkIllegalAwarenessState() {
        Assertions.assertThrows(IllegalAwarenessStateException.class, () -> whale.awareness(null));
    }

    @Test
    public void checkIllegalEmotionalState() {
        Assertions.assertThrows(IllegalEmotionalStateException.class, () -> whale.updateEmotionalState(null));
    }

}
