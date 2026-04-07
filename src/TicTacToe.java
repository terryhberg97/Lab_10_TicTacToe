import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];
    public static void main() {
        Scanner in = new Scanner(System.in);


        int rowMove = SafeInput.getRangedInt(in, "Enter your row move ", 1, 100);
        int colMove = SafeInput.getRangedInt(in, "Enter your column move ", 1, 100);
    }
}
