package org.progweb.lista01;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int num = sc.nextInt();

        System.out.printf("O número informado foi: %d.", num);
        sc.close();
    }
}

