package com.github;

import org.junit.Test;

import java.util.Arrays;

public class DistinctBarcodeTest {
    @Test
    public void test() {
        int[] arr = {1, 1, 1, 1, 2, 2, 3, 3};
        DistinctBarcode barcode = new DistinctBarcode();
        int[] arranged = barcode.rearrangeBarcodes(arr);
        System.out.println(Arrays.toString(arranged));
    }
}