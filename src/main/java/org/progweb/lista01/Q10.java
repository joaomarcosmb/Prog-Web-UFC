package org.progweb.lista01;

import java.util.Arrays;
import java.util.Scanner;

import static org.progweb.lista01.utils.ScanToNumArray.toDoubleArray;

public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite as notas, separadas por vírgula (ex.: 2, 3.4, 4): ");
        String in = sc.nextLine();
        double[] nums = toDoubleArray(in);

        var max = Arrays.stream(nums).max();

        if(max.isPresent()) {
            System.out.printf("O maior número é %.2f", max.getAsDouble());
        } else {
            System.out.println("Não há um maior número.");
        }
    }
}

