package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {

    private static final int DEST_AIRPORT_ID_COLUMN_NUMBER = 14;

    private static final int ARR_DELAY_NEW_COLUMN_NUMBER = 18;

    private static final Integer FILE_NUMBER = 1;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!key.equals(new LongWritable(0))) { // Пропускаем первую строку csv файла
            String[] columns = value.toString().split(",");

            Integer destAirportId = Integer.parseInt(columns[DEST_AIRPORT_ID_COLUMN_NUMBER]);
            String delay = columns[ARR_DELAY_NEW_COLUMN_NUMBER];

            context.write(new TextPair(destAirportId, 1), new Text(delay)); // key, value        }
        }
    }
}
