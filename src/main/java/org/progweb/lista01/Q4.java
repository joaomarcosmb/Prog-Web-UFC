package org.progweb.lista01;

import java.util.Arrays;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite três notas, separadas por vírgula (ex.: 2, 3, 4): ");
        String in = sc.nextLine();

        double mean = Arrays.stream(in.split(","))
                .map(String::trim)
                .mapToDouble(Double::parseDouble)
                .sum() / 3;
        System.out.printf("A média das notas é: %.2f.", mean);
    }
}

