package Working_with_files_and_networking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovementsParser {
    public static void main(String[] args) {
        Path path = Path.of("Working_with_files_and_networking/movementList.csv");
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HashMap<String, Double> expence2sum = new HashMap<>();
        String firstLine = null;
        for (String line : lines) {
            if (firstLine == null) {
                firstLine = line;
                continue;
            }
            String[] tokens = line.split(",");
            double expense = Double.parseDouble(tokens[7]);
            if (expense == 0) {
                continue;
            }
            String paymentType = getPaymentType(tokens[5]);
            if (!expence2sum.containsKey(paymentType)) {
                expence2sum.put(paymentType, 0.);
            }
            expence2sum.put(paymentType, expence2sum.get(paymentType) + expense
            );
        }
        assert firstLine != null;
        String[] firstLineTokens = firstLine.split(",");
        System.out.printf("%-15s %15s\n", firstLineTokens[5], firstLineTokens[7]);
        for(String paymentType : expence2sum.keySet()) {
            double sum = expence2sum.get(paymentType);
            System.out.printf("%-15s %15s\n", paymentType, sum);        }

    }

    private static String getPaymentType(String string) {
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\\s]+)[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() ? matcher.group(1).trim() : null;
    }
}
