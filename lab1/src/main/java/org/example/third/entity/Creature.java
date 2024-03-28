package org.example.third.entity;

import lombok.Setter;
import org.example.third.entity.enums.AwarenessState;
import org.example.third.entity.enums.CreatureType;
import org.example.third.entity.enums.EmotionalState;
import org.example.third.entity.enums.PositionState;
import org.example.third.exception.IllegalAwarenessStateException;
import org.example.third.exception.IllegalEmotionalStateException;
import org.example.third.interfaces.Awarenessable;

import java.util.Objects;

public class Creature implements Awarenessable {
    private final String name;
    private CreatureType creatureType;
    private PositionState positionState;
    private AwarenessState awarenessState;
    private EmotionalState emotionalState;

    public Creature(String name, CreatureType creatureType,
                    PositionState positionState, EmotionalState emotionalState, AwarenessState awarenessState) {
        this.name = name;
        this.creatureType = creatureType;
        this.positionState = positionState;
        this.emotionalState = emotionalState;
        this.awarenessState = awarenessState;
    }

    @Override
    public String awareness(AwarenessState awarenessState) {
        if (Objects.isNull(awarenessState)) {
            throw new IllegalAwarenessStateException("Недопустимый статус осознания");
        }
        String val = String.format("%s с именем %s, который прежде осознавал себя %s, " +
                "начал осознавать себя %s", creatureType.toString(), name,
                this.awarenessState.toString(), awarenessState);
        this.awarenessState = awarenessState;
        return val;
    }

    public String realizes() {
        return String.format("%s с именем %s cвыкается, что он %s",
                creatureType.toString(), name, this.awarenessState.toString());
    }
    public String reconcile() {
        return String.format("%s с именем %s пришлось свыкнуться с осознанием того, что он стал %s",
                creatureType.toString(), name, this.awarenessState.toString());
    }

    public String updateEmotionalState(EmotionalState emotionalState) {
        if (Objects.isNull(emotionalState)) {
            throw new IllegalEmotionalStateException("Недопустимое настроение");
        }
        String val = String.format("%s с именем %s, который прежде чувствовал себя %s, " +
                        "начал чувствовать себя %s", creatureType.toString(), name,
                this.emotionalState.toString(), emotionalState);
        this.emotionalState = emotionalState;
        return val;
    }

    public String getPositionState() {
        return this.name + " находится в " + this.positionState.toString() + " положении";
    }
}
