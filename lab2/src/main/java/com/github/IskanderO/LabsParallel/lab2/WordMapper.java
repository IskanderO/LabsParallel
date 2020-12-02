package com.github.IskanderO.LabsParallel.lab1;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String nonSymbolsRegExp = "[^a-zа-я]";
        String spacesRegExp = " +";
        
        String line = value.toString();
        String[] words = line.toLowerCase().trim().replaceAll(nonSymbolsRegExp, " ").split(spacesRegExp);

        for (String word : words) {
            context.write(new Text(word), new IntWritable(1));
        }

    }

}
