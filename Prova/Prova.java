/**
 * @author Júlio Antunes Estrela
 */

import java.util.Scanner;

public class Prova
{
    public static void main(String[] args)
    {
        exercicio1();
        exercicio2();
    }

    //Exercício 1
    static void exercicio1()
    {
        Scanner scan = new Scanner(System.in);
        double valor1, valor2;
        int option;

        System.out.print("Digite o primeiro valor: ");
        valor1 = scan.nextDouble();

        System.out.print("Digite o segundo valor: ");
        valor2 = scan.nextDouble();

        System.out.print("Digite a opção: ");
        option = scan.nextInt();

        System.out.println(verificarOpcao(option, valor1, valor2));
    }

    static Double verificarOpcao(int option, double valor1, double valor2)
    {
        switch (option)
        {
            case 1:
                return valor1 + valor2;
            case 2:
                return valor1 - valor2;
            case 3:
                return valor1 * valor2;
            case 4:
                return valor1 / valor2;
            default:
                System.out.println("Opção inválida!");
                return null;
        }
    }

    //Exercício2
    static void exercicio2()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o número de linhas da matriz:");
        int valor1 = scan.nextInt();

        System.out.println("Digite o número de colunas da matriz:");
        int valor2 = scan.nextInt();

        int matriz[][] = new int[valor1][valor2];


        int numero = -1;
        for (int i = 0; i < valor1; i++)
        {
            for (int j = 0; j < valor2; j++)
            {
                numero++;
                matriz[i][j] = numero;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
