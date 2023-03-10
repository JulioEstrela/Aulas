import java.util.Arrays;
import java.util.Scanner;

public class tictac
{
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
