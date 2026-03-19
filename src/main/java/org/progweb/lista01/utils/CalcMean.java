package org.progweb.lista01.utils;

import java.util.Arrays;

public class CalcMean {

    public static double mean(double nums[]) {
        return Arrays.stream(nums).sum() / nums.length;
    }
}
