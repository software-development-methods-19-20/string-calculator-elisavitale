package dssc.calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else
            return addAllNumbers(numbers);
    }

    private static int addAllNumbers(String numbers) {
        int result = 0;
        for (String num : getAllNumbers(numbers))
            result += toInt(num);
        return result;
    }

    private static String[] getAllNumbers(String numbers) {
        if (thereAreDelimiters(numbers))
            return splitAndFilterNumbers(numbers);
        else return new String[] {numbers};
    }

    private static boolean thereAreDelimiters(String numbers) {
        return containsStandardDelimiters(numbers) || containsNewDelimiters(numbers);
    }

    private static String[] standardDelimiters = {",", "\n"};

    private static boolean containsStandardDelimiters(String numbers) {
        return numbers.contains(standardDelimiters[0]) || numbers.contains(standardDelimiters[1]);
    }

    private static boolean containsNewDelimiters(String numbers) {
        return numbers.startsWith("//") && numbers.contains("\n");
    }

    private static String[] splitAndFilterNumbers(String numbers) {
        return keepSmallerThan1000(splitNumbers(numbers));
    }

    private static String[] keepSmallerThan1000(String[] allNumbers) {
        String filteredNumbers = "";
        for (String number : allNumbers)
            if (toInt(number) < 1000)
                filteredNumbers += number + ",";
        return filteredNumbers.split(",");
    }

    private static int toInt(String string) {
        return Integer.parseInt(string);
    }

    private static String[] splitNumbers(String numbers) {
        return cleanString(numbers).split(",");
    }

    private static String cleanString(String numbers) {
        return ignoreDelimiterDeclarationLine(cleanAllDelimiters(numbers));
    }

    private static String ignoreDelimiterDeclarationLine(String numbers) {
        if (containsNewDelimiters(numbers))
            return cutFirstLine(numbers);
        else return numbers;
    }

    private static String cutFirstLine(String numbers) {
        return numbers.substring(numbers.indexOf("\n") + 1);
    }

    private static String cleanAllDelimiters(String numbers) {
        for (String delimiter : getAllDelimiters(numbers))
            numbers = numbers.replace(delimiter, ",");
        return numbers;
    }

    private static String[] getAllDelimiters(String numbers) {
        if (containsNewDelimiters(numbers))
            return getNewDelimiters(numbers);
        else return standardDelimiters;
    }

    private static String[] getNewDelimiters(String numbers) {
        if (containsManyOrLongDelimiters(numbers))
            return getManyOrLongDelimiters(numbers);
        else
            return new String[]{getOneShortDelimiter(numbers)};
    }

    private static boolean containsManyOrLongDelimiters(String numbers) {
        return numbers.contains("[") && numbers.contains("]");
    }

    private static String[] getManyOrLongDelimiters(String numbers) {
        String delimiters = "";
        do {
            delimiters = addNextDelimiter(delimiters, numbers);
            numbers = cutString(numbers);
        } while (containsManyOrLongDelimiters(numbers));
        return delimiters.split(",");
    }

    private static String addNextDelimiter(String delimiters, String numbers) {
        return delimiters + nextDelimiter(numbers) + ",";
    }

    private static String nextDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
    }

    private static String cutString(String numbers) {
        return numbers.substring(numbers.indexOf("]") + 1);
    }

    private static String getOneShortDelimiter(String numbers) {
        return numbers.substring(2, numbers.indexOf("\n"));
    }

}
