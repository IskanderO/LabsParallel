package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.mapreduce.Partitioner;

public class TextPairPartitioner<K, V> extends Partitioner<K, V> {

    @Override
    public int getPartition(TextPair key, Text value, int numReduceTasks) {
        return (key.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }

}
