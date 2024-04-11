package org.example.math.trigonometry;

import lombok.RequiredArgsConstructor;
import org.example.math.interfaces.Calculable;

@RequiredArgsConstructor
public class Tangens implements Calculable {
    private final Sinus sinus;
    private final Cosinus cosinus;

    private final double epsilon = 0.01;
    public double calculate(double x) {
        double cosResult = cosinus.calculate(x);
        if (Math.abs(cosResult) < epsilon) {
            throw new ArithmeticException("zero division");
        }
        return sinus.calculate(x) / cosResult;
    }
}
