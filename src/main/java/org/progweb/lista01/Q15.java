package org.progweb.lista01;

import java.util.Scanner;

public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número inteiro: ");
            int in = sc.nextInt();

            if(isPrime(in)) {
                System.out.println("Primo!");
            } else {
                System.out.println("Não primo!");
            }
        }

        sc.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}