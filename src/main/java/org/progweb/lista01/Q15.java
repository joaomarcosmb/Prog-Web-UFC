package org.progweb.lista01;


import java.util.ArrayList;
import java.util.Arrays;

public class Q15 {
    public static void main(String[] args) {
        ArrayList<Integer> fibonacci = new ArrayList<>(Arrays.asList(0, 1, 1));
        for (int i = 0; i < 10; i++) {
            if (i < 1) {
                System.out.println(fibonacci.getFirst());
            } else if (i < 3) {
                System.out.println(fibonacci.get(1));
            } else {
                int num = fibonacci.get(i - 1) + fibonacci.get(i - 2);
                System.out.println(num);
                fibonacci.add(num);
            }
        }
    }
}