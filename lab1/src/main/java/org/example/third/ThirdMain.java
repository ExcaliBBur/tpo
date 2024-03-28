package org.example.third;

import org.example.third.entity.enums.AwarenessState;
import org.example.third.entity.enums.EmotionalState;
import org.example.third.entity.enums.PositionState;
import org.example.third.entity.Whale;

public class ThirdMain {
    public static void main(String[] args) {
        Whale whale = new Whale("Китёнок", PositionState.ARTIFICIAL, EmotionalState.HAPPY);

        System.out.println(whale.getPositionState());
        System.out.println(whale.updateEmotionalState(EmotionalState.UNFORTUNATE));

        System.out.println(whale.realizes());
        System.out.println(whale.awareness(AwarenessState.NOT_WHALE));
        System.out.println(whale.reconcile());
    }
}
