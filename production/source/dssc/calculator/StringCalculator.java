package dssc.calculator;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty())
            return 0;
        else
            return addAllNumbers(numbers);
    }

    public static int addAllNumbers(String numbers) {
        int result = 0;
        for (String num : getAllNumbers(numbers))
            result += toInt(num);
        return result;
    }

    public static String[] getAllNumbers(String numbers) {
        if (thereAreDelimiters(numbers))
            return splitAndFilterNumbers(numbers);
        else return new String[] {numbers};
    }

    public static boolean thereAreDelimiters(String numbers) {
        return containsStandardDelimiters(numbers) || containsNewDelimiters(numbers);
    }

    public static String[] standardDelimiters = {",", "\n"};

    public static boolean containsStandardDelimiters(String numbers) {
        return numbers.contains(standardDelimiters[0]) || numbers.contains(standardDelimiters[1]);
    }

    public static boolean containsNewDelimiters(String numbers) {
        return numbers.startsWith("//") && numbers.contains("\n");
    }

    public static String[] splitAndFilterNumbers(String numbers) {
        return keepSmallerThan1000(splitNumbers(numbers));
    }

    public static String[] keepSmallerThan1000(String[] allNumbers) {
        String filteredNumbers = "";
        for (String number : allNumbers)
            if (toInt(number) < 1000)
                filteredNumbers += number + ",";
        return filteredNumbers.split(",");
    }

    public static int toInt(String string) {
        return Integer.parseInt(string);
    }

    public static String[] splitNumbers(String numbers) {
        return cleanString(numbers).split(",");
    }

    public static String cleanString(String numbers) {
        return ignoreDelimiterDeclarationLine(cleanAllDelimiters(numbers));
    }

    public static String ignoreDelimiterDeclarationLine(String numbers) {
        if (containsNewDelimiters(numbers))
            return cutFirstLine(numbers);
        else return numbers;
    }

    public static String cutFirstLine(String numbers) {
        return numbers.substring(numbers.indexOf("\n") + 1);
    }

    public static String cleanAllDelimiters(String numbers) {
        for (String delimiter : getAllDelimiters(numbers))
            numbers = numbers.replace(delimiter, ",");
        return numbers;
    }

    public static String[] getAllDelimiters(String numbers) {
        if (containsNewDelimiters(numbers))
            return getNewDelimiters(numbers);
        else return standardDelimiters;
    }

    public static String[] getNewDelimiters(String numbers) {
        if (containsManyOrLongDelimiters(numbers))
            return getManyOrLongDelimiters(numbers);
        else
            return new String[]{getOneShortDelimiter(numbers)};
    }

    public static boolean containsManyOrLongDelimiters(String numbers) {
        return numbers.contains("[") || numbers.contains("]");
    }

    public static String[] getManyOrLongDelimiters(String numbers) {
        String delimiters = "";
        do {
            delimiters = addNextDelimiter(delimiters, numbers);
            numbers = cutString(numbers);
        } while (containsManyOrLongDelimiters(numbers));
        return delimiters.split(",");
    }

    public static String addNextDelimiter(String delimiters, String numbers) {
        return delimiters + nextDelimiter(numbers) + ",";
    }

    public static String nextDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
    }

    public static String cutString(String numbers) {
        return numbers.substring(numbers.indexOf("]") + 1);
    }

    public static String getOneShortDelimiter(String numbers) {
        return numbers.substring(2, numbers.indexOf("\n"));
    }

}
