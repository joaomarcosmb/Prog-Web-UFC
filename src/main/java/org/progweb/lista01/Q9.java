package org.progweb.lista01;

import java.util.Scanner;

public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        float n1 = sc.nextFloat();

        System.out.print("Digite o segundo número: ");
        float n2 = sc.nextFloat();

        System.out.print("Digite o terceiro número: ");
        float n3 = sc.nextFloat();

        if (n1 == n2 && n2 == n3) {
            System.out.println("Os números são iguais.");
        } else if ((n1 == n2 && n2 < n3) || (n1 < n2 && n2 < n3) || (n2 < n1 && n1 < n3)) {
            System.out.printf("O número %.2f é o maior.", n3);
        } else if ((n1 == n3 && n3 < n2) || (n1 < n3 && n3 < n2) || (n3 < n1 && n1 < n2)) {
            System.out.printf("O número %.2f é o maior.", n2);
        } else {
            System.out.printf("O número %.2f é o maior.", n1);
        }

        sc.close();
    }
}

