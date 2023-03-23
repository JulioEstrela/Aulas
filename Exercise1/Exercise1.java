import java.util.Scanner;

public class Exercicio1
{
    String nomes[] = new String[3];
    double contas[][] = new double[4][4];
    Scanner scanner = new Scanner(System.in);

    void verifyChosenValue(int value)
    {
        if (value == 1)
            System.out.println(nomes[0]);
        else if(value >= 2 && value <= 10)
            System.out.println(nomes[1]);
        else if (value > 10)
            System.out.println(nomes[2]);
        else
            System.out.println("Opção Inválida!");

    }

    void showNames()
    {
        for (int i = 0; i < nomes.length; i++)
        {
            System.out.println(nomes[i]);
        }
    }

    void fillDoubles()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if(i == 0 && j == 0)
                    contas[i][j] = 0;
                else if (i == 0) {
                    System.out.println(String.format("Digite o %d° double", j));
                    contas[i][j] = scanner.nextDouble();
                }
                else if(j == 0)
                    contas[i][j] = contas[j][i];
                else if (i == j)
                    contas[i][j] = contas[0][j] * contas[i][0];

                else
                    contas[i][j] = contas[0][j] - contas[i][0];
            }
        }
    }

    void showDoubles()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                System.out.print(contas[i][j] + " ");
            }
            System.out.println();
        }
    }

}
