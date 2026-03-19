package org.progweb.lista01.utils;

import java.util.Arrays;

public class ScanToNumArray {

    public static int[] toIntArray(String in) {
        return Arrays.stream(in.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static double[] toDoubleArray(String in) {
        return Arrays.stream(in.split(","))
                .map(String::trim)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
