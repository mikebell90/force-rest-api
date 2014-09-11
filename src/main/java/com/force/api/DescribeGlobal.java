package com.force.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DescribeGlobal {

    private String encoding;
    private int maxBatchSize;
    private List<DescribeSObjectBasic> sobjects;

    public String getEncoding() {
        return encoding;
    }

    public int getMaxBatchSize() {
        return maxBatchSize;
    }

    public List<DescribeSObjectBasic> getSObjects() {
        return sobjects;
    }
}
