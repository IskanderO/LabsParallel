package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class JoinReducer extends Reducer<TextPair, Text, Text, Text> {

    @Override
    protected void reduce(TextPair key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iter = values.iterator();
        String airportDescription = iter.next().toString();
        Statistics statistics = new Statistics(values);
        if (statistics.getCountOfDelays()) {

        }


    }
}

class Statistics {

    private double minDelay = Double.MAX_VALUE;

    private double maxDelay = 0.0;

    private double sumOfDelays = 0.0;

    private int countOfDelays = 0;

    private double averageDelay = 0.0;

    public Statistics() {
    }

    public double getMinDelay() {
        return minDelay;
    }

    public double getMaxDelay() {
        return maxDelay;
    }

    public double getSumOfDelays() {
        return sumOfDelays;
    }

    public int getCountOfDelays() {
        return countOfDelays;
    }

    public double getAverageDelay() {
        return averageDelay;
    }


}
