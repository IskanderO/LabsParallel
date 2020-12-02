package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class FlightsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {

    private static final int DEST_AIRPORT_ID_COLUMN_NUMBER = 14; // DEST_AIRPORT_ID — Идентификатор аэропорта

    private static final int ARR_DELAY_NEW_COLUMN_NUMBER = 18; // ARR_DELAY_NEW - разница в минутах между расчетным временем приземления и реальным (>=0)
    
    private static final int ARR_DELAY_NEW_COLUMN_NUMBER = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!key.equals(new LongWritable(0))) { // Пропускаем первую строку csv файла (наименования столбцов)
            String[] columns = value.toString().split(",");

            Integer destAirportId = Integer.parseInt(columns[14]);
            ServiceCall call = new ServiceCall(value);

            context.write(new TextPair(call.getSystemA().toString(), "1"), new Text(call.toString())); // key, value
        }
    }
}
