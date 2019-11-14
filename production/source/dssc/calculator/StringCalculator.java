package dssc.calculator;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty()) {
            return 0;
        } else
            return addAllNumbers(stringOfNumbers);
    }

    public static int toInt(String string) {
        return Integer.valueOf(string);
    }

    public static boolean thereAreDelimiters(String string) {
        return containsNewDelimiters(string) || string.contains(",") || string.contains("\n");
    }

    public static boolean containsNewDelimiters(String string) {
        if (string.startsWith("//") && string.contains("\n"))
            return true;
        else return false;
    }

    public static String getNewDelimiter(String string) {
        return string.substring(2, string.indexOf("\n"));
    }

    public static String ignoreFirstLine(String string) {
        if (containsNewDelimiters(string)) {
            return string.substring(string.indexOf("\n") + 1);
        } else return string;
    }

    public static String getSplittingString(String stringOfNumbers) {
        if (containsNewDelimiters(stringOfNumbers)) {
            return "[" + getNewDelimiter(stringOfNumbers) + ",\n]";
        } else return "[,\n]";
    }

    public static String[] getAllNumbers(String stringOfNumbers) {
        if (thereAreDelimiters(stringOfNumbers)) {
            return ignoreFirstLine(stringOfNumbers).split(getSplittingString(stringOfNumbers));
        } else return new String[] {stringOfNumbers};
    }

    public static int addAllNumbers(String stringOfNumbers) {
        int sum = 0;
        for (String number : getAllNumbers(stringOfNumbers))
            sum += toInt(number);
        return sum;
    }

}
