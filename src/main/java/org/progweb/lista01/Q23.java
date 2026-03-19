package org.progweb.lista01;

import java.util.Scanner;

public class Q23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========= Calculadora básica =========");
        System.out.println("Operações disponíveis:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.print("Escolha uma operação (1 - 4): ");
        int option = sc.nextInt();

        System.out.println("\nDigite dois números:");
        System.out.print("Primeiro número: ");
        double num1 = sc.nextDouble();

        System.out.print("Segundo número: ");
        double num2 = sc.nextDouble();

        System.out.println();

        double result;
        switch (option) {
            case 1:
                result = num1 + num2;
                System.out.printf("Resultado: %.2f + %.2f = %.2f", num1, num2, result);
                break;
            case 2:
                result = num1 - num2;
                System.out.printf("Resultado: %.2f - %.2f = %.2f", num1, num2, result);
                break;
            case 3:
                result = num1 * num2;
                System.out.printf("Resultado: %.2f * %.2f = %.2f", num1, num2, result);
                break;
            case 4:
                if (num2 != 0) {
                    result = num1 / num2;
                    System.out.printf("Resultado: %.2f / %.2f = %.2f", num1, num2, result);
                } else {
                    System.out.println("Erro: Divisão por zero não é permitida.");
                }
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma operação entre 1 e 4.");
        }

        sc.close();
    }
}