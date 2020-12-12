package com.github.IskanderO.LabsParallel.lab1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class Main {

    private static final String FILE_NAME_1 = "airports.csv";
    private static final String FILE_NAME_2 = "flights.csv";



    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> airportsDescriptionDataRDD = sc.textFile(FILE_NAME_1);
        JavaRDD<String> flightsDataRDD = sc.textFile(FILE_NAME_2);

        JavaPairRDD<Long, String> airportsRDD = airportsDescriptionDataRDD.filter(s -> !s.startsWith("Code")).mapToPair(
                s -> {
                    String[] columns = s.split(",");
                    Long airportId = Long.parseLong(columns[0].replaceAll("\"", ""));
                    return new Tuple2<>();
                }
        )
    }
}
