package dssc.calculator;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty()) {
            return 0;
        } else if (stringOfNumbers.contains(",")) {
            return addAllNumbers(stringOfNumbers);
        } else {
            return onlyOneNumber(stringOfNumbers);
        }
    }

    public static int toInt(String string) {
        return Integer.valueOf(string);
    }

    public static String[] getAllNumbers(String numbers) {
        return numbers.split(",");
    }

    public static int addAllNumbers(String numbers) {
        int sum = 0;
        for (String number : getAllNumbers(numbers))
            sum += toInt(number);
        return sum;
    }

    public static int onlyOneNumber(String stringOfNumbers) {
        return toInt(stringOfNumbers);
    }
}
