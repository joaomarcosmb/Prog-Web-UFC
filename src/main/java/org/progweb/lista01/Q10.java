package org.progweb.lista01;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int in = sc.nextInt();

        if(in % 2 == 0) {
            System.out.println("Par!");
        } else {
            System.out.println("Ímpar!");
        }

        sc.close();
    }
}

