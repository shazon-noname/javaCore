package algos;

public class RecursiveDescentParser {
    private String[] tokens;
    private int pos = 0;

    public RecursiveDescentParser(String expressions) {
        this.tokens = expressions.split(" ");
    }
    /*
    E -> T + E | T - E | T
    T -> F * T | F / T | F
    F -> N     | (E)
     */
    public static void main(String[] args) {
        String expressionText = "22 + 2 * ( 2 + 2 ) * 4";
        RecursiveDescentParser recursiveDescentParser = new RecursiveDescentParser(expressionText);
        System.out.println(recursiveDescentParser.parse());
    }

    public Double parse() {
        Double result = expression();
        if (pos != tokens.length) {
            throw new IllegalStateException("Error in expression at " + tokens[pos]);
        }
        return result;
    }

    private Double expression() {
        Double first = term();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            Double second = term();
            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }
        }
        return first;
    }

    private Double term() {
        Double first = factor();

        while (pos < tokens.length) {
            String operator = tokens[pos];
            if (!operator.equals("*") && !operator.equals("/")) {
                break;
            } else {
                pos++;
            }

            Double second = factor();
            if (operator.equals("*")) {
                first *= second;
            } else {
                first /= second;
            }
        }
        return first;
    }

    private Double factor() {
        String next = tokens[pos];
        Double result;
        if (next.equals("(")) {
            pos++;
            result = expression();
            String closingBracket;
            if (pos < tokens.length) {
                closingBracket = tokens[pos];
            } else {
                throw new IllegalStateException("Unexpected end of expression");
            }
            if (pos < tokens.length && closingBracket.equals(")")) {
                pos++;
                return result;
            }
            throw new IllegalStateException("')' expected but " + closingBracket);
        }
        pos++;
        return Double.parseDouble(next);
    }
}

