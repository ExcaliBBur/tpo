import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.math.function.Function;
import org.example.math.logarithm.Logarithm;
import org.example.math.logarithm.NaturalLogarithm;
import org.example.math.trigonometry.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FunctionTest {
    private static Sinus mockedSinus;
    private static Cosinus mockedCosinus;
    private static Tangens mockedTangens;
    private static Cotangens mockedCotangens;
    private static Cosecans mockedCosecans;

    private static NaturalLogarithm mockedNaturalLogarithm;
    private static Logarithm mockedLogarithm2;
    private static Logarithm mockedLogarithm3;
    private static Logarithm mockedLogarithm5;

    private static Sinus sinus;

    private static Cosinus cosinus;

    private static NaturalLogarithm naturalLogarithm;
    private static Logarithm logarithm2;
    private static Logarithm logarithm3;
    private static Logarithm logarithm5;

    private final double epsilon = 0.1;

    @BeforeAll
    static void init() {
        mockedSinus = Mockito.mock(Sinus.class);
        mockedCosinus = Mockito.mock(Cosinus.class);
        mockedTangens = Mockito.mock(Tangens.class);
        mockedCotangens = Mockito.mock(Cotangens.class);
        mockedCosecans = Mockito.mock(Cosecans.class);

        mockedNaturalLogarithm = Mockito.mock(NaturalLogarithm.class);
        mockedLogarithm2 = Mockito.mock(Logarithm.class);
        mockedLogarithm3 = Mockito.mock(Logarithm.class);
        mockedLogarithm5 = Mockito.mock(Logarithm.class);

        sinus = new Sinus();
        sinus.setN(100);

        cosinus = new Cosinus(sinus);

        naturalLogarithm = new NaturalLogarithm();
        naturalLogarithm.setN(100);

        logarithm2 = new Logarithm(naturalLogarithm, 2);
        logarithm3 = new Logarithm(naturalLogarithm, 3);
        logarithm5 = new Logarithm(naturalLogarithm, 5);

        try {
            Reader cos = new FileReader("src/main/resources/csv/cosinus.csv");
            Reader sin = new FileReader("src/main/resources/csv/sinus.csv");
            Reader tan = new FileReader("src/main/resources/csv/tangens.csv");
            Reader cotan = new FileReader("src/main/resources/csv/cotangens.csv");
            Reader cosec = new FileReader("src/main/resources/csv/cosecans.csv");
            Reader ln = new FileReader("src/main/resources/csv/natural_log.csv");
            Reader log2 = new FileReader("src/main/resources/csv/log2.csv");
            Reader log3 = new FileReader("src/main/resources/csv/log3.csv");
            Reader log5 = new FileReader("src/main/resources/csv/log5.csv");

            for (CSVRecord record : CSVFormat.DEFAULT.parse(cos)) {
                Mockito.when(mockedCosinus.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(sin)) {
                Mockito.when(mockedSinus.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(tan)) {
                Mockito.when(mockedTangens.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(cotan)) {
                Mockito.when(mockedCotangens.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(cosec)) {
                Mockito.when(mockedCosecans.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(ln)) {
                Mockito.when(mockedNaturalLogarithm.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log2)) {
                Mockito.when(mockedLogarithm2.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log3)) {
                Mockito.when(mockedLogarithm3.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log5)) {
                Mockito.when(mockedLogarithm5.calculate(Double.parseDouble(record.get(0))))
                        .thenReturn(Double.parseDouble(record.get(1)));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testMock(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testSin(double value, double expected) {
        Function function = new Function(sinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testCos(double value, double expected) {
        Function function = new Function(mockedSinus, cosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testSinAndCos(double value, double expected) {
        Function function = new Function(sinus, cosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testTan(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, new Tangens(sinus, cosinus), mockedCotangens,
                mockedCosecans, mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testCot(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, new Cotangens(sinus, cosinus),
                mockedCosecans, mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testTanAndCot(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, new Tangens(sinus, cosinus), new Cotangens(sinus, cosinus),
                mockedCosecans, mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testCosec(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, new Cosecans(sinus),
                mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testAllTrig(double value, double expected) {
        Function function = new Function(sinus, cosinus, new Tangens(sinus, cosinus), new Cotangens(sinus, cosinus),
               new Cosecans(sinus), mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testLn(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                naturalLogarithm, mockedLogarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testLog2(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, logarithm2, mockedLogarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testLog3(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, mockedLogarithm2, logarithm3, mockedLogarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testLog5(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, mockedLogarithm2, mockedLogarithm3, logarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testAllLog(double value, double expected) {
        Function function = new Function(mockedSinus, mockedCosinus, mockedTangens, mockedCotangens, mockedCosecans,
                mockedNaturalLogarithm, logarithm2, logarithm3, logarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/function.csv")
    void testAll(double value, double expected) {
        Function function = new Function(sinus, cosinus, new Tangens(sinus, cosinus), new Cotangens(sinus, cosinus),
                new Cosecans(sinus), naturalLogarithm, logarithm2, logarithm3, logarithm5);
        Assertions.assertEquals(expected, function.calculate(value), epsilon);
    }
}
