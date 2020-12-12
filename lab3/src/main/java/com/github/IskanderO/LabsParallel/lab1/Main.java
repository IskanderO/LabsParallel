package com.github.IskanderO.LabsParallel.lab1;

public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);
    }
}
