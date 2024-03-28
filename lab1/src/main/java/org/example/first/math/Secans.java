package org.example.first.math;

import lombok.*;

@Setter
@NoArgsConstructor
public class Secans {
    private int N;

    public double calculate(double x) {
        if (Double.isInfinite(x) || Double.isNaN(x)) {
            throw new IllegalArgumentException("Argument must be a number");
        }

        if (N <= 0) {
            throw new IllegalArgumentException("Number of iterations must be >= 0");
        }

        x = getPeriod(x);

        if (x == Math.PI / 2 || x == -Math.PI / 2) {
            return Double.POSITIVE_INFINITY;
        }

        double result = 0.;
        int sign = 1;
        double factorial = 1;

        for (int i = 0; i <= N; i+=2) {
            if (i > 0) {
                factorial *= (i - 1) * i;
            }

            result = result + (sign * Math.pow(x, i) / factorial);
            sign *= -1;
        }
        return 1 / result;
    }

    public double calculateWithMath(double x) {
        if (getPeriod(x) == Math.PI / 2 || getPeriod(x) == -Math.PI / 2) {
            return Double.POSITIVE_INFINITY;
        }
        return 1 / Math.cos(x);
    }

    private double getPeriod(double x) {
        if (x >= 0) {
            while (x > Math.PI) {
                x -= Math.PI * 2;
            }
        } else {
            while (x < -Math.PI) {
                x += Math.PI * 2;
            }
        }
        return x;
    }
}
