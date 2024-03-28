package org.example.first.math;

import org.example.first.math.Secans;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SecansTest {

    private final Secans secans = new Secans();

    @ParameterizedTest
    @ValueSource(doubles = {
            -Math.PI, -Math.PI / 2, 0, Math.PI / 2, Math.PI,
            Math.PI / 6, Math.PI / 4, Math.PI / 3, 3 * Math.PI / 2, 2 * Math.PI,
            -Math.PI / 6, -Math.PI / 4, -Math.PI / 3, 3 * -Math.PI / 2, 2 * -Math.PI,
            10 * -Math.PI, 5 * -Math.PI, 5 * Math.PI, 10 * Math.PI
    })
    public void checkCalculate(double x) {
        secans.setN(30);
        Assertions.assertEquals(secans.calculateWithMath(x), secans.calculate(x), 0.0001);
    }

    @Test
    public void calculateWithIllegalIterations() {
        secans.setN(-5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> secans.calculate(Math.PI));
    }

    @Test
    public void calculateWithNan() {
        secans.setN(30);
        Assertions.assertThrows(IllegalArgumentException.class, () -> secans.calculate(Double.NaN));
    }

    @Test
    public void calculateWithInfinity() {
        secans.setN(30);
        Assertions.assertThrows(IllegalArgumentException.class, () -> secans.calculate(Double.POSITIVE_INFINITY));
    }
}
