package Java.hw5;

public class Chess {
    private static final int BOARD_SIZE = 8;
    private static int[] positions = new int[BOARD_SIZE];
    private static int VariantCount = 0;
 
    public static void main(String[] args) {
        findQueens(0);
        System.out.println("Нашли " + VariantCount + " вариант(а)");
    }
 
    private static void findQueens(int row) {
        if (row == BOARD_SIZE) {
            printVariant();
            VariantCount++;
        } else {
            for (int col = 0; col < BOARD_SIZE; col++) {
                positions[row] = col;
                if (isValid(row)) {
                    findQueens(row + 1);
                }
            }
        }
    }
 
    private static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(positions[row] - positions[i]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }
 
    private static void printVariant() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (positions[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
 }
