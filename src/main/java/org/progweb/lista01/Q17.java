package org.progweb.lista01;

import java.util.Scanner;

public class Q17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int in = sc.nextInt();

        if(in < 0 || in > 16) {
            throw new IllegalArgumentException("O número deve estar entre 0 <= x <= 16.");
        }

        int val = 1;
        for (int i = in; i >= 1; i--) {
            val *= i;
        }

        System.out.println("O fatorial de " + in + " é " + val);

        sc.close();
    }
}