package dssc.calculator;

import java.util.ArrayList;
import static java.util.Arrays.stream;
import static java.lang.Integer.valueOf;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else
            return addAllNumbers(numbers);
    }

    private static int addAllNumbers(String numbers) {
        return stream(getAllNumbers(numbers)).sum();
    }

    private static int[] getAllNumbers(String numbers) {
        if (thereAreDelimiters(numbers))
            return splitAndFilterNumbers(numbers);
        else return new int[] {valueOf(numbers)};
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

    private static int[] splitAndFilterNumbers(String numbers) {
        return keepSmallerThan1000(convertNumbersToInt(splitNumbersIntoArray(numbers)));
    }

    private static int[] keepSmallerThan1000(int[] allNumbers) {
        return stream(allNumbers)
                     .filter(x -> x < 1000)
                     .toArray();
    }

    private static int[] convertNumbersToInt(String[] allNumbers) {
        return stream(allNumbers)
                     .mapToInt(Integer::valueOf)
                     .toArray();
    }

    private static String[] splitNumbersIntoArray(String numbers) {
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
        ArrayList<String> delimiters = new ArrayList<>();
        while (containsManyOrLongDelimiters(numbers)) {
            delimiters.add(nextDelimiter(numbers));
            numbers = cutString(numbers);
        }
        return delimiters.toArray(new String[delimiters.size()]);
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
