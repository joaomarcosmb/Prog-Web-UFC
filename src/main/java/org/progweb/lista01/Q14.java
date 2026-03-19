package org.progweb.lista01;

import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro entre 0 e 10: ");
        int in = sc.nextInt();

        while (in < 0 || in > 10) {
            System.out.print("Digite um número inteiro entre 0 e 10: ");
            in = sc.nextInt();
        }

        sc.close();
    }
}