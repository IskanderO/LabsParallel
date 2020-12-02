package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class AirportsJoinMapper extends Mapper<LongWritable, Text, TextPair, Text> {

    //т.к. отсчет с нуля, то индексы на единицу меньше, чем в самом csv файле
    private static final int DEST_AIRPORT_ID_COLUMN_NUMBER = 0; // DEST_AIRPORT_ID — Идентификатор аэропорта

    private static final int AIRPORT_DESCRIPTION_COLUMN_NUMBER = 1; // DEST_AIRPORT_ID — Идентификатор аэропорта

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (!key.equals(new LongWritable(0))) { // Пропускаем первую строку csv файла (наименования столбцов)
            SystemInfo system = new SystemInfo(value);
            context.write(new TextPair(system.getSystemCode().toString(), "0"), new Text(system.toString()));  // key, value
        }
    }
}
