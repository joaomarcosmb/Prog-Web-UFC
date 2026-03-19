package org.progweb.lista01;

import java.util.ArrayList;
import java.util.Scanner;

public class Q20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.printf("(%d) Digite um número: ", i + 1);
            nums.add(sc.nextLine());
        }

        double sum = 0;
        double product = 1;
        for (int i = 0; i < nums.size(); i++) {
            double num = Double.parseDouble(nums.get(i));
            sum += num;
            product *= num;
        }

        System.out.println("A soma dos números digitados é " + sum + ".");
        System.out.println("O produto dos números digitados é " + product + ".");
        System.out.println("Os números digitados foram " + String.join(", ", nums) + ".");

        sc.close();
    }
}