package org.example.first;

import org.example.first.math.Secans;

public class FirstMain {
    public static void main(String[] args) {
        Secans secans = new Secans();
        secans.setN(30);
        double x = -3.15;

        System.out.println(secans.calculate(x));
    }
}
