package test;

import dssc.calculator.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersTest {

    @Test
    void emptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void oneNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    void twoNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    void fiveNumbers() {
        assertEquals(15, StringCalculator.add("1,2,3,4,5"));
    }

    @Test
    void newLineBetweenTwoNumbers() {
        assertEquals(7, StringCalculator.add("3\n4"));
    }

    @Test
    void newLineAndComma() {
        assertEquals(7, StringCalculator.add("3\n3,1"));
    }

    @Test
    void semicolonDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    void largerThanOneThousand() {
        assertEquals(2, StringCalculator.add("2,1001"));
    }
}
