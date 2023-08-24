import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe
{
    int round = 0;

    char[][] boardTemplate = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    
    char player;

    public void play()
    {
        while(!victory() && !draw())
        {
            showBoard();
            resetBoard();
            getPlayerPosition();
        }
    }
    
    void resetBoard() 
    {
        if(round > 0)
        return;
        
        for (int i = 0; i < board.length; i++) 
        {
            Arrays.fill(board[i], ' ');
        }
    }
    
    
    //victory check function
    boolean victory()
    {
        //rows
        for (char[] row : board) 
        {
            if(row[0] != 'X' && row[0] != 'O') break;

            if(row[0] == row[1] && row[1] == row[2])
            {
                showBoard();
                return true;
            }
        }

        //columns
        for (int i = 0; i < 3; i++) 
        {
            if(board[0][i] != 'X' && board[0][i] != 'O') break;

            if(board[0][i] == board[1][i] && board[1][i] == board[2][i])
            {
                showBoard();
                return true;
            }  
        }

        if(board[1][1] != 'X' && board[1][1] != 'O') return false;

        //left-right diagonal
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
        {
            showBoard();
            return true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
        {
            showBoard();
            return true;
        }
        
        return false;
    }
    
    boolean draw()
    {
        if(round >= 9)
        {
            showBoard();
            return true;
        }
        
        return false;
    }

    void showTemplate()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.print("+-+-+-+\n|");
            
            for (int j = 0; j < 3; j++)
            {
                System.out.print(boardTemplate[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("+-+-+-+");
    }

    void showBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.print("+-+-+-+\n|");

            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println("+-+-+-+");
    }

    void getPlayerPosition()
    {
        char chosenPosition;

        Scanner scan = new Scanner(System.in);
        chosenPosition = scan.next().charAt(0);

        //checking if position played is valid
        for (char[] row : board) 
        {
            for (char position : row) 
            {
                if(chosenPosition == position)
                    getPlayerPosition();
            }
        }
        
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++) 
            {
                if(chosenPosition == boardTemplate[i][j])
                {
                    if(round % 2 == 0)
                        player = 'X';
                    else
                        player = 'O';
                    boardTemplate[i][j] = player;
                    board[i][j] = player;
                    round++;
                    return;
                }
            }
        }

    }
}
