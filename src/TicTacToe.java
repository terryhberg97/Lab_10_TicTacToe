import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean repeat;

        do
        {
            clearBoard();
            boolean done = false;
            String player = "X";
            int moveCounter = 0;

            do
            {
                display();
                int rowMove = SafeInput.getRangedInt(in, "Enter your row move ", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(in, "Enter your column move ", 1, 3) - 1;

                if (isValidMove(rowMove, colMove))
                {
                    board[rowMove][colMove] = player;
                    moveCounter++;

                    if (isWin(player))
                    {
                        display();
                        System.out.println();
                        System.out.println("Player " + player + " wins!");
                        done = true;
                    }
                    else if (isTie(moveCounter))
                    {
                        display();
                        System.out.println();
                        System.out.println("Tie!");
                        done = true;
                    }
                    else if (player.equals("X"))
                    {
                        player = "O";
                    }
                    else
                    {
                        player = "X";
                    }
                }
                else
                {
                    System.out.println();
                    System.out.println("Spot is taken. Go again.");
                }
            } while (!done);
            repeat = SafeInput.getYNConfirm(in, "Do you want to play again? [Y/N]");
        } while (repeat);
    }
    private static void clearBoard()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                board[row][col] = " ";
            }
        }
    }
    private static void display()
    {
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                System.out.print(board[row][col]);
                if (col < COLS - 1)
                {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
        {
            retVal = true;
        }
        return retVal;
    }
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COLS; col++)
        {
            if(board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player))
            {
                return true;
            }
        }

        return false;
    }
    private static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROWS; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagonalWin(String player)
    {
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
        {
            return true;
        }
        if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private static boolean isTie(int moveCounter)
    {
        return moveCounter == 9;
    }
}