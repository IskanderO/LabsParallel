package com.github.IskanderO.LabsParallel.lab2;

import org.apache.hadoop.io.WritableComparator;

public class TextPairGroupingComparator extends WritableComparator {

    public int compare(Object obj1, Object obj2) {
        TextPair textPair1 = (TextPair)obj1;
        TextPair textPair2 = (TextPair)obj2;
        return Integer.compare(textPair1.getDestAirportId(), textPair2.getDestAirportId());
    }

}
