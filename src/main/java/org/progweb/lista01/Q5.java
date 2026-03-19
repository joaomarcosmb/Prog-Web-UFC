package org.progweb.lista01;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a medida, em metros (m): ");
        float in = sc.nextFloat();
        float cm = in * 100;

        System.out.printf("A medida informada equivale a %.2f cm.", cm);
    }
}

