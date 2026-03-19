package org.progweb.lista01;

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro entre 0 e 10: ");
        int in = sc.nextInt();

        if(in < 0 || in > 10) {
            throw new IllegalArgumentException("O número deve estar entre 0 e 10!");
        }

        System.out.printf("\n=================== Tabuada do %d ===================\n", in);
        for (int i = 0; i <=10; i++) {
            int result = in * i;
            System.out.printf("%d x %d = %d\n", in, i, result);
        }

        sc.close();
    }
}

