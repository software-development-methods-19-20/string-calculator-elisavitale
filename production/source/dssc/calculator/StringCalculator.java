package dssc.calculator;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty()) {
            return 0;
        } else if (containsDelimiters(stringOfNumbers)) {
            return addAllNumbers(stringOfNumbers);
        } else {
            return onlyOneNumber(stringOfNumbers);
        }
    }

    public static int toInt(String string) {
        return Integer.valueOf(string);
    }

    static String[] defaultDelimiters = {",", "\n"};

    public static String getNewDelimiter(String string) {
        if (string.startsWith("//"))
            return string.substring(3,3);
        else return "";
    }

    public static boolean containsDelimiters(String string) {
        if (string.startsWith("//"))
            return true;
        else
            return string.contains(defaultDelimiters[0]) || string.contains(defaultDelimiters[1]);
    }

    public static String[] getAllNumbers(String stringOfNumbers) {
        if (containsDelimiters(stringOfNumbers))
            return stringOfNumbers.split("[/,;\n]");
        else return stringOfNumbers.split("[,\n]");
    }

    public static int addAllNumbers(String stringOfNumbers) {
        int sum = 0;
        for (String number : getAllNumbers(stringOfNumbers))
            if (!number.equals(""))
                sum += toInt(number);
        return sum;
    }

    public static int onlyOneNumber(String stringOfNumbers) {
        return toInt(stringOfNumbers);
    }
}
