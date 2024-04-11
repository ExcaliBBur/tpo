package org.example.math.trigonometry;

import lombok.RequiredArgsConstructor;
import org.example.math.interfaces.Calculable;

@RequiredArgsConstructor
public class Cosecans implements Calculable {
    private final Sinus sinus;
    private final double epsilon = 0.01;
    public double calculate(double x) {
        double sinResult = sinus.calculate(x);
        if (Math.abs(sinResult) < epsilon) {
            throw new ArithmeticException("zero division");
        }
        return 1 / sinResult;
    }
}
