package dssc.calculator;

public class StringCalculator {

    public static int add(String stringOfNumbers) {
        if (stringOfNumbers.isEmpty())
            return 0;
        else
            return addAllNumbers(stringOfNumbers);
    }

    public static int addAllNumbers(String string) {
        int sum = 0;
        for (String number : getAllNumbers(string))
            sum += toInt(number);
        return sum;
    }

    public static String[] getAllNumbers(String string) {
        if (thereAreDelimiters(string))
            return splitAndFilterNumbers(string);
        else return new String[] {string};
    }

    public static boolean thereAreDelimiters(String string) {
        return string.contains(",") || string.contains("\n") || containsNewDelimiter(string);
    }

    public static boolean containsNewDelimiter(String string) {
        if (string.startsWith("//") && string.contains("\n"))
            return true;
        else return false;
    }

    public static String[] splitAndFilterNumbers(String string) {
        return ignoreLargerThan1000(splitNumbers(string));
    }

    public static String[] ignoreLargerThan1000(String[] allNumbers) {
        String filteredNumbers = "";
        for (String number : allNumbers)
            if (toInt(number) < 1000)
                filteredNumbers += number + ",";
        return filteredNumbers.split(",");
    }

    public static String[] splitNumbers(String string) {
        return ignoreFirstLine(string).split(getAllDelimiters(string));
    }

    public static String ignoreFirstLine(String string) {
        if (containsNewDelimiter(string))
            return string.substring(string.indexOf("\n") + 1);
        else return string;
    }

    public static String getAllDelimiters(String string) {
        if (containsNewDelimiter(string))
            return getNewDelimiter(string);
        else return "[,\n]";
    }

    public static String getNewDelimiter(String string) {
        if (string.contains("[") && string.contains("]"))
            return string.substring(3, string.indexOf("]"));
        else return string.substring(2, string.indexOf("\n"));
    }

    public static int toInt(String string) {
        return Integer.valueOf(string);
    }

}
