package org.progweb.lista01;

import java.util.Scanner;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma string: ");
        String strA = sc.nextLine();

        System.out.print("Digite uma string: ");
        String strB = sc.nextLine();

        System.out.printf("String A: %s (%d caracteres)", strA, strA.length());
        System.out.printf("%nString B: %s (%d caracteres)", strB, strB.length());
        System.out.println("\nAs strings são iguais? " + (strA.equals(strB) ? "Sim" : "Não"));

        sc.close();
    }
}