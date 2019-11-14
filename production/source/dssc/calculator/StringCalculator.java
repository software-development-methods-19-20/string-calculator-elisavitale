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

    public static String[] getAllNumbers(String stringOfNumbers) {
        return stringOfNumbers.split(",");
    }

    public static int addAllNumbers(String stringOfNumbers) {
        int sum = 0;
        for (String number : getAllNumbers(stringOfNumbers))
            sum += toInt(number);
        return sum;
    }

    public static int onlyOneNumber(String stringOfNumbers) {
        return toInt(stringOfNumbers);
    }
}
