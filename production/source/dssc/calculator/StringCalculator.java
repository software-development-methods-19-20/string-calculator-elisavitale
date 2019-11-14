package dssc.calculator;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty()) {
            return 0;
        } else if (thereAreManyNumbers(stringOfNumbers)) {
            return addAllNumbers(stringOfNumbers);
        } else {
            return onlyOneNumber(stringOfNumbers);
        }
    }

    public static int toInt(String string) {
        return Integer.valueOf(string);
    }

    public static boolean thereAreManyNumbers(String string) {
        return containsNewDelimiters(string) || string.contains(",") || string.contains("\n");
    }

    public static boolean containsNewDelimiters(String string) {
        if (string.startsWith("//"))
            return true;
        else return false;
    }

    public static String getNewDelimiter(String string) {
        if (containsNewDelimiters(string))
            return string.substring(2, string.indexOf("\n"));
        else return "";
    }

    public static String ignoreFirstLine(String string) {
        return string.substring(string.indexOf("\n") + 1);
    }

    public static String[] getAllNumbers(String stringOfNumbers) {
        if (containsNewDelimiters(stringOfNumbers)) {
            String newDelimiter = getNewDelimiter(stringOfNumbers);
            return ignoreFirstLine(stringOfNumbers).split(newDelimiter);
        }
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
