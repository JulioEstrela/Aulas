import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Exercicio1 exercicio1 = new Exercicio1();
        double doubleValues[] = new double[3];

        //get names and add to 'nomes'; show names
        for (int i = 0; i < exercicio1.nomes.length; i++)
        {
            System.out.println(String.format("Digite o %d° nome", i+1));
            exercicio1.nomes[i] = scanner.next();
        }
        exercicio1.showNames();

        //get option from user and use 'verifyChosenValue' method
        for (int i = 0; i < 4; i++)
        {
            System.out.print("Digite um número inteiro de opção: ");
            int opcao = scanner.nextInt();
            exercicio1.verifyChosenValue(opcao);
        }
        exercicio1.fillDoubles();
        exercicio1.showDoubles();

        //Removed
        /*
            //first row
            exercicio1.contas[1][1] = doubleValues[0] * doubleValues[0];
            exercicio1.contas[1][2] = doubleValues[0] - doubleValues[1];
            exercicio1.contas[1][3] = doubleValues[0] - doubleValues[2];

            //second row
            exercicio1.contas[2][1] = doubleValues[1] - doubleValues[0];
            exercicio1.contas[2][2] = doubleValues[1] * doubleValues[1];
            exercicio1.contas[2][3] = doubleValues[1] - doubleValues[2];

            //third row
            exercicio1.contas[3][1] = doubleValues[2] - doubleValues[0];
            exercicio1.contas[3][2] = doubleValues[2] - doubleValues[1];
            exercicio1.contas[3][3] = doubleValues[2] * doubleValues[2];*/
    }
}
