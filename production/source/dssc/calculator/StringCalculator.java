package dssc.calculator;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty()) {
            return 0;
        } else if (stringOfNumbers.contains(",")) {
            return addTwoNumbers(stringOfNumbers);
        } else {
            return onlyOneNumber(stringOfNumbers);
        }
    }

    public static int toInt(String string) {
        return Integer.parseInt(string);
    }

    public static String[] getTwoNumbers(String numbers) {
        return numbers.split(",");
    }

    public static int addTwoNumbers(String numbers) {
        return toInt(getTwoNumbers(numbers)[0]) + toInt(getTwoNumbers(numbers)[1]);
    }

    public static int onlyOneNumber(String stringOfNumbers) {
        return toInt(stringOfNumbers);
    }
}
