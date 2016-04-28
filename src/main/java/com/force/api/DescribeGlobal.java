package com.force.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class DescribeGlobal  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9204790055181957199L;
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
