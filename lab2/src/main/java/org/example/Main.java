package org.example;

import org.example.csv.CsvWriter;
import org.example.math.logarithm.Logarithm;
import org.example.math.logarithm.NaturalLogarithm;
import org.example.math.function.Function;
import org.example.math.trigonometry.*;

public class Main {
    public static void main(String[] args) {
        Sinus sinus = new Sinus();
        sinus.setN(50);

        Cosinus cosinus = new Cosinus(sinus);

        Tangens tangens = new Tangens(sinus, cosinus);
        Cotangens cotangens = new Cotangens(sinus, cosinus);
        Cosecans cosecans = new Cosecans(sinus);

        NaturalLogarithm naturalLogarithm = new NaturalLogarithm();
        naturalLogarithm.setN(100);

        Logarithm logarithm2 = new Logarithm(naturalLogarithm, 2);
        Logarithm logarithm3 = new Logarithm(naturalLogarithm, 3);
        Logarithm logarithm5 = new Logarithm(naturalLogarithm, 5);


        Function function = new Function(sinus, cosinus, tangens, cotangens, cosecans,
                naturalLogarithm, logarithm2, logarithm3, logarithm5);

        CsvWriter csvWriter = new CsvWriter(-5.1, 5.1, 0.26);

        csvWriter.write("src/main/resources/csv/sinus.csv", sinus);
        csvWriter.write("src/main/resources/csv/cosinus.csv", cosinus);
        csvWriter.write("src/main/resources/csv/tangens.csv", tangens);
        csvWriter.write("src/main/resources/csv/cotangens.csv", cotangens);
        csvWriter.write("src/main/resources/csv/cosecans.csv", cosecans);
        csvWriter.write("src/main/resources/csv/function.csv", function);
//        csvWriter.write("src/main/resources/csv/natural_log.csv", naturalLogarithm);
//        csvWriter.write("src/main/resources/csv/log2.csv", logarithm2);
//        csvWriter.write("src/main/resources/csv/log3.csv", logarithm3);
//        csvWriter.write("src/main/resources/csv/log5.csv", logarithm5);
    }
}