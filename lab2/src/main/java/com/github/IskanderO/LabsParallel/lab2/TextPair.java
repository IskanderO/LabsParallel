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
        super();
    }

    public TextPair(Integer destAirportId, Integer fileNumber ) {
        this.destAirportId = destAirportId;
        this.fileNumber = fileNumber;
    }

    public Integer getDestAirportId() {
        return destAirportId;
    }

    public Integer getFileNumber() {
        return fileNumber;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(destAirportId);
        dataOutput.writeInt(fileNumber);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.destAirportId = dataInput.readInt();
        this.fileNumber = dataInput.readInt();
    }

    @Override
    public int compareTo(TextPair o) {
        return 0;
    }

}
