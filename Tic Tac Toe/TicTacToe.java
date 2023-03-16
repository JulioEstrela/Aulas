import java.util.Arrays;
import java.util.Scanner;

public class tictac
{
    
    final char[][][] WINNINGS =
        {
                {{'0', '0'}, {'0', '1'}, {'0','2'}}, //first col
                {{'1', '0'}, {'1', '1'}, {'1', '2'}}, // second col
                {{'2', '0'}, {'2', '1'}, {'2', '2'}}, //trd col

                {{'0', '0'}, {'1', '0'}, {'2','0'}}, //first row
                {{'0', '1'}, {'1', '1'}, {'2', '1'}}, // second row
                {{'0', '2'}, {'1', '2'}, {'2', '2'}}, //trd row

                //diagonal
                {{'0', '0'}, {'1', '1'}, {'2','2'}}, //left-right
                {{'0', '2'}, {'1', '1'}, {'2', '0'}} // right-left
        };
    
    
    public static void main(String[] args)
    {
        char[][] board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }

        while (!victory(board) || !draw())
        {
            ShowBoard(board);
        }

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();



        ShowBoard(board);


    }

    public static boolean victory(char[][] board)
    {
        for (char[] line: board)
        {
            for (char position: line)
            {

            }
        }

        if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
        {
            return true;
        }

        return false;
    }

    public static  boolean draw()
    {
        return  false;
    }

    public static void ShowBoard(char[][] board)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
