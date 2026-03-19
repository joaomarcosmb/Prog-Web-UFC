package org.progweb.lista01;

import java.util.Scanner;

public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o preço do produto 1: ");
        float p1 = sc.nextFloat();

        System.out.print("Digite o preço do produto 2: ");
        float p2 = sc.nextFloat();

        System.out.print("Digite o preço do produto 3: ");
        float p3 = sc.nextFloat();

        float menor = Math.min(p1, Math.min(p2, p3));

        if (menor == p1 && menor == p2 && menor == p3) {
            System.out.print("Todos os produtos têm o mesmo preço.");
        } else if (menor == p1 && menor == p2) {
            System.out.print("Compre o produto 1 ou 2.");
        } else if (menor == p1 && menor == p3) {
            System.out.print("Compre o produto 1 ou 3.");
        } else if (menor == p2 && menor == p3) {
            System.out.print("Compre o produto 2 ou 3.");
        } else if (menor == p1) {
            System.out.print("Compre o produto 1.");
        } else if (menor == p2) {
            System.out.print("Compre o produto 2.");
        } else {
            System.out.print("Compre o produto 3.");
        }
    }
}

