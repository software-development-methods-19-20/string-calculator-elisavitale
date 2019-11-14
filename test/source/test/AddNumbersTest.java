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
}
