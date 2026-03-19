package org.progweb.lista01;

import java.util.ArrayList;
import java.util.Scanner;

public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.printf("(%d) Digite um número: ", i + 1);
            nums.add(sc.nextLine());
        }

        ArrayList<String> numsReversed = new ArrayList<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            numsReversed.add(nums.get(i));
        }

        System.out.println("Os números digitados foram " + String.join(", ", numsReversed) + ".");

        sc.close();
    }
}