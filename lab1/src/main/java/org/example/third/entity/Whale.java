package org.example.third.entity;


import org.example.third.entity.enums.AwarenessState;
import org.example.third.entity.enums.CreatureType;
import org.example.third.entity.enums.EmotionalState;
import org.example.third.entity.enums.PositionState;

public class Whale extends Creature {
    public Whale(String name, PositionState positionState, EmotionalState emotionalState) {
        super(name, CreatureType.WHALE, positionState, emotionalState, AwarenessState.WHALE);
    }
}
