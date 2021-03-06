package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class ReduceSideJoinRunner {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: ReduceSideJoinRunner <input path A> <input path B> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(ReduceSideJoinRunner.class);
        job.setJobName("ReduceSideJoinRunner job");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightsJoinMapper.class); // flights
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, AirportsJoinMapper.class); // airports

        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setPartitionerClass(TextPairPartitioner.class);
        job.setGroupingComparatorClass(TextPairGroupingComparator.class);
        job.setReducerClass(JoinReducer.class);
        job.setMapOutputKeyClass(TextPair.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
