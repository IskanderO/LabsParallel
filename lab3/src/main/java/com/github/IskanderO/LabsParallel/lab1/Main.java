package com.github.IskanderO.LabsParallel.lab1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Map;

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
                    String resultStr = "";
                    Long airportId = Long.parseLong(columns[0].replaceAll("\"", ""));
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < columns.length; i++)
                        sb.append(columns[i]);
                    resultStr = sb.toString();
                    return new Tuple2<>(airportId, resultStr);
                }
        );

        JavaPairRDD<Tuple2<Long, Long>, Flights> flightsRDD = flightsDataRDD.mapToPair(
                s -> {
                    String[] columns = s.replaceAll(" ","").split(",");
                    Long originAirportId = Long.parseLong(columns[11].replaceAll("\"",""));
                    Long destAirportId =  Long.parseLong(columns[14].replaceAll("\"",""));

                    String delay = columns[18];
                    String cancelled = columns[19];
                    return new Tuple2<>(new Tuple2<Long, Long>(originAirportId, destAirportId), new Flights(delay, cancelled));
                }
        );

        JavaPairRDD<Tuple2<Long, Long>, Flights> flightsStatisticRDD =flightsRDD.reduceByKey(Flights::update);

        Map<Long, String> airportsDescriptionMap = airportsRDD.collectAsMap();

        JavaPairRDD<String, String> result = flightsStatisticRDD.mapToPair()
        airportsDescriptionMap.saveAsTextFile("lab3");
    }
}
