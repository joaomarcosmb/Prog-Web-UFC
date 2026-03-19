package org.progweb.lista01;

import java.util.Scanner;

import static org.progweb.lista01.Q3.calcMean;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite as notas, separadas por vírgula (ex.: 2, 3.4, 4): ");
        String in = sc.nextLine();
        double mean = calcMean(in);

        System.out.printf("A média aritmética simples das notas é: %.2f.", mean);

        if (mean >= 7) {
            System.out.println("\nAprovado!");
        } else {
            System.out.println("\nReprovado!");
        }
    }
}

