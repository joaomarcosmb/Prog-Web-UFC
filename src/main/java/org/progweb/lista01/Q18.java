package org.progweb.lista01;

import java.util.ArrayList;
import java.util.Scanner;

public class Q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.printf("(%d) Digite um número: ", i + 1);
            nums.add(sc.nextLine());
        }

        System.out.println("Os números digitados foram " + String.join(", ", nums) + ".");

        sc.close();
    }
}