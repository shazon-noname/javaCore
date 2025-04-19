package Working_with_files_and_networking;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovementsParser {
    public static void main() {
        Path path = Path.of("Working_with_files_and_networking/movementList.csv");
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HashMap<String, Double> incomeByType = new HashMap<>();
        HashMap<String, Double> expenseByType = new HashMap<>();
        String firstLine = null;

        for (String line : lines) {
            if (firstLine == null) {
                firstLine = line;
                continue;
            }
            String[] tokens = line.split(",");

            // Processing of revenue
            double income = Double.parseDouble(tokens[6]);
            if (income > 0) {
                String incomeType = getPaymentType(tokens[5]);
                incomeByType.merge(incomeType, income, Double::sum);
            }

            // Processing of expenses
            double expense = Double.parseDouble(tokens[7]);
            if (expense > 0) {
                String expenseType = getPaymentType(tokens[5]);
                expenseByType.merge(expenseType, expense, Double::sum);
            }
        }

        // Display of the income table
        System.out.println("\nincome:");
        printSummaryTable(incomeByType);

        // Displaying the cost table
        System.out.println("\nexpenses:");
        printSummaryTable(expenseByType);

        // Total amounts
        double totalIncome = incomeByType.values().stream().mapToDouble(Double::doubleValue).sum();
        double totalExpense = expenseByType.values().stream().mapToDouble(Double::doubleValue).sum();

        System.out.printf("\nTotal income: %.2f %n", totalIncome);
        System.out.printf("Total expenses: %.2f %n%n", totalExpense);


        printTable(lines);
    }

    private static void printSummaryTable(Map<String, Double> data) {
        if (data.isEmpty()) {
            System.out.println("No data to display\n");
            return;
        }

        // Determine the width of the columns
        int typeWidth = 30;
        int amountWidth = 15;

        for (String type : data.keySet()) {
            typeWidth = Math.max(typeWidth, type.length());
        }

        String horizontalLine = createHorizontalLine(typeWidth, amountWidth);
        System.out.println(horizontalLine);
        System.out.printf("| %-" + (typeWidth - 1) + "s | %" + (amountWidth - 1) + "s |\n", "Type Operation", "Sum");
        System.out.println(horizontalLine);

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            System.out.printf("| %-" + (typeWidth - 1) + "s | %" + (amountWidth - 1) + ".2f |\n",
                    entry.getKey(), entry.getValue());
        }
        System.out.println(horizontalLine);
    }

    private static String createHorizontalLine(int typeWidth, int amountWidth) {
        return "+" + "-".repeat(typeWidth + 1) + "+" + "-".repeat(amountWidth + 1) + "+";
    }

    private static void printTable(List<String> table) {
        List<String[]> parseRow = table.stream().map(line -> line.split(",")).toList();

        int columnCount = parseRow.getFirst().length;

        int[] columnWidths = new int[columnCount];
        for (String[] row : parseRow) {
            for (int i = 0; i < row.length; i++) {
                String clean = row[i].replace("\"", "").trim();
                columnWidths[i] = Math.max(columnWidths[i], clean.length());
            }
        }

        String horizontalLine = buildHorizontalLine(columnWidths);

        System.out.println(horizontalLine);
        for (String[] row : parseRow) {
            for (int j = 0; j < row.length; j++) {
                String clean = row[j].replace("\"", "").trim();
                System.out.printf("| %-" + columnWidths[j] + "s ", clean);
            }
            System.out.println("|");
            System.out.println(horizontalLine);

        }
    }

    private static String buildHorizontalLine(int[] columnWidths) {
        StringBuilder sb = new StringBuilder();
        for (int width : columnWidths) {
            sb.append("+").append("-".repeat(width + 2));
        }
        sb.append("+");
        return sb.toString();
    }

    private static String getPaymentType(String string) {
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\\s]+)[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.find() ? matcher.group(1).trim() : null;
    }
}
