package org.progweb.lista01;

import java.util.Scanner;

import static org.progweb.lista01.utils.CalcMean.mean;
import static org.progweb.lista01.utils.ScanToNumArray.toDoubleArray;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite as notas, separadas por vírgula (ex.: 2, 3.4, 4): ");
        String in = sc.nextLine();
        double[] nums = toDoubleArray(in);
        double mean = mean(nums);

        System.out.printf("A média aritmética simples das notas é: %.2f.", mean);

        if (mean >= 7) {
            System.out.println("\nAprovado!");
        } else {
            System.out.println("\nReprovado!");
        }

        sc.close();
    }
}

