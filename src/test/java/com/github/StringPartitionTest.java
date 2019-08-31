package com.github;

import org.junit.Test;

import java.util.List;

public class StringPartitionTest {
    @Test
    public void test() {
        StringPartition stringPartition = new StringPartition();
        String str = "eccbbbbdec";
        List<Integer> partitions = stringPartition.partitionLabels(str);
        System.out.println(partitions);
    }
}