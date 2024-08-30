package algos;

enum Number {
     N(20);

     private int number;

    Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class Matrix5x5 {
    public static void main(String[] args) {
        Number.N.setNumber(10);
        int number = Number.N.getNumber();
        int[][] matrix = new int[number][number];
        fillSpiral(matrix);
        printMatrix(matrix);
    }

    public static void fillSpiral(int[][] matrix) {
        int n = matrix.length;
        int value = 1;
        int layer = 0;

        while (value <= n * n) {
            for (int i = layer; i < n - layer; i++) {
                matrix[layer][i] = value++;
            }
            for (int i = layer + 1; i < n - layer ; i++) {
                matrix[i][n - layer - 1] = value++;
            }
            for (int i = n - layer - 2; i >= layer ; i--) {
                matrix[n - layer - 1][i] = value++;
            }
            for (int i = n - layer - 2; i > layer ; i--) {
                matrix[i][layer] = value++;
            }
            layer++;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
