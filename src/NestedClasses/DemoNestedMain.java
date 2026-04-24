package NestedClasses;

class ArrayOperation {
    static class Pair {
        private final double min;
        private final double max;
        public Pair(double min, double max) {
            this.min = min;
            this.max = max;
        }
        public double getMin() {
            return min;
        }

        public double getMax() {
            return max;
        }
    }
    public static Pair searchMinMax(double[] values) {
        double min = values[0];
        double max = values[0];
        for (double value : values) {
            if (min > value) {
                min = value;
            }
            if (max < value) {
                max = value;
            }
        }
        return new Pair(min, max);
    }
}


public class DemoNestedMain {
    public static void main(String[] args) {
        double[] values = new double[] {1.0, 2.0, 3.0, 4.0, 5.0};
        ArrayOperation.Pair pair = ArrayOperation.searchMinMax(values);
        System.out.println("Min: " + pair.getMin());
        System.out.println("Max: " + pair.getMax());

    }
}
