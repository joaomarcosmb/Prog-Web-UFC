package org.progweb.lista01;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o raio do círculo, em unidades de medida (u.m.): ");
        double r = sc.nextDouble();
        double area = Math.PI * Math.pow(r, 2);

        System.out.printf("A área do círculo é %.2f um^2.", area);
    }
}

