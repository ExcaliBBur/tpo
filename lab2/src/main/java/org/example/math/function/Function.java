package org.example.math.function;

import lombok.RequiredArgsConstructor;
import org.example.math.interfaces.Calculable;
import org.example.math.logarithm.Logarithm;
import org.example.math.logarithm.NaturalLogarithm;
import org.example.math.trigonometry.*;

@RequiredArgsConstructor
public class Function implements Calculable {
    private final Sinus sinus;
    private final Cosinus cosinus;
    private final Tangens tangens;
    private final Cotangens cotangens;
    private final Cosecans cosecans;

    private final NaturalLogarithm naturalLogarithm;
    private final Logarithm logarithm2;
    private final Logarithm logarithm3;
    private final Logarithm logarithm5;

    public double calculate(double x) {
        double result;

        if (x <= 0) {
            result = (((((cotangens.calculate(x)) / cosecans.calculate(x)) / cosecans.calculate(x)) / (cosinus.calculate(x))
                    * (Math.pow(cosinus.calculate(x) - tangens.calculate(x), 2))
                    - (cosinus.calculate(x)) * sinus.calculate(x)));
        } else {
            result = (((((logarithm5.calculate(x) * logarithm3.calculate(x))
                    / (logarithm2.calculate(x)))
                    + naturalLogarithm.calculate(x)) / naturalLogarithm.calculate(x)) * logarithm2.calculate(x));
        }
        return result;
    }
}
