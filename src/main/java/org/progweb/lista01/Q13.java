package org.progweb.lista01;

import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int NUM_A = 123;
        final int NUM_B = 456;
        final int NUM_C = 789;
        System.out.println("Canidato A - " + NUM_A);
        System.out.println("Canidato B - " + NUM_B);
        System.out.println("Canidato C - " + NUM_C);

        int contA = 0;
        int contB = 0;
        int contC = 0;

        System.out.print("Qual o tamanho deste eleitorado? ");
        final int VOTERS = sc.nextInt();
        sc.nextLine();

        System.out.println("\n-------- Início da votação --------\n");

        int invalids = 0;
        int nulls = 0;
        for (int i = 0; i < VOTERS; i++) {
            System.out.printf("Eleitor %d, digite o número do seu candidato: ", i + 1);
            String vote = sc.nextLine();

            if (vote.isBlank()) {
                nulls++;
            } else {
                int voteNum = -1;
                try {
                    voteNum = Integer.parseInt(vote);
                } catch (NumberFormatException e) {
                    invalids++;
                    continue;
                }

                if(voteNum == NUM_A) {
                    contA++;
                } else if(voteNum == NUM_B) {
                    contB++;
                } else if(voteNum == NUM_C) {
                    contC++;
                } else {
                    invalids++;
                }
            }
        }

        System.out.println("\n-------- Resultado da votação --------");

        System.out.println("Canidato A - " + contA + " votos");
        System.out.println("Canidato B - " + contB + " votos");
        System.out.println("Canidato C - " + contC + " votos");
        System.out.println("Brancos/nulos - " + nulls + " votos");
        System.out.println("Anulados/inválidos - " + invalids + " votos");

        sc.close();
    }
}

