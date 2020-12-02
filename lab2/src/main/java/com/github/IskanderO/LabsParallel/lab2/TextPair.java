package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.io.WritableComparable;

import javax.xml.soap.Text;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TextPair implements WritableComparable<TextPair> {
    
    private Integer destAirportId;

    private Integer fileNumber;

    public TextPair() {
    }

    public TextPair(Integer destAirportId, Integer fileNumber ) {
        this.destAirportId = destAirportId;
        this.fileNumber = fileNumber;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }

    @Override
    public int compareTo(TextPair o) {
        return 0;
    }
}
