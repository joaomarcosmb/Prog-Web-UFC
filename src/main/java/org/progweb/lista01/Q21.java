package org.progweb.lista01;

import java.util.ArrayList;
import java.util.Scanner;

public class Q21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.printf("(%d) Digite um número inteiro: ", i + 1);
            nums.add(sc.nextInt());
        }

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        System.out.println("Os números pares são: " + even.toString().replaceAll("[\\[\\]]", "") + ".");
        System.out.println("O produto dos números digitados é " + odd.toString().replaceAll("[\\[\\]]", "") + ".");
        System.out.println("Os números digitados foram " + nums.toString().replaceAll("[\\[\\]]", "") + ".");

        sc.close();
    }
}