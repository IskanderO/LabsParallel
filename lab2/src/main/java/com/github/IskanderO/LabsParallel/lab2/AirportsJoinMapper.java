package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {


    private static final int DEST_AIRPORT_ID_COLUMN_NUMBER = 0;

    private static final int AIRPORT_DESCRIPTION_COLUMN_NUMBER = 1;

    private static final int FILE_NUMBER = 0;


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!key.equals(new LongWritable(0))) { // Пропускаем первую строку csv файла (наименования столбцов)
            String[] columns = value.toString().split(",");

            Integer destAirportId = Integer.parseInt(columns[DEST_AIRPORT_ID_COLUMN_NUMBER].replaceAll("\"", ""));

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < columns.length; i++) {
                sb.append(columns[i]);
            }

            String airportDescription = sb.toString();

            context.write(new TextPair(destAirportId, FILE_NUMBER), new Text(airportDescription));  
        }
    }
}
