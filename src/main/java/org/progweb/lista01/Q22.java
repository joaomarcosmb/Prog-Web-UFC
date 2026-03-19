package org.progweb.lista01;

import java.util.Scanner;

public class Q22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int a = sc.nextInt();

        String aStr = String.valueOf(a);
        StringBuilder builder = new StringBuilder();
        for (int i = aStr.length() - 1; i >= 0; i--) {
            builder.append(aStr.charAt(i));
        }

        a = Integer.parseInt(builder.toString());
        System.out.println("Número invertido: " + a);

        sc.close();
    }
}