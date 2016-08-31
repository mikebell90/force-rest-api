package com.force.api;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class RecordTypeInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6161738372725041552L;
	/*
	 * /*
     * recordTypeInfos" : [ {
    "available" : true,
    "defaultRecordTypeMapping" : true,
    "master" : true,
    "name" : "Master",
    "recordTypeId" : "012000000000000AAA",
    "urls" : {
      "layout" : "/services/data/v37.0/sobjects/Opportunity/describe/layouts/012000000000000AAA"
    }
  } ],
	 */
	private Boolean available;
	private Boolean defaultRecordTypeMapping;
	private Boolean master;
	private String name;
	private String recordTypeId;
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public Boolean getDefaultRecordTypeMapping() {
		return defaultRecordTypeMapping;
	}
	public void setDefaultRecordTypeMapping(Boolean defaultRecordTypeMapping) {
		this.defaultRecordTypeMapping = defaultRecordTypeMapping;
	}
	public Boolean getMaster() {
		return master;
	}
	public void setMaster(Boolean master) {
		this.master = master;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRecordTypeId() {
		return recordTypeId;
	}
	public void setRecordTypeId(String recordTypeId) {
		this.recordTypeId = recordTypeId;
	}
	@Override
	public String toString() {
		return "RecordTypeInfo [available=" + available + ", defaultRecordTypeMapping=" + defaultRecordTypeMapping
				+ ", master=" + master + ", name=" + name + ", recordTypeId=" + recordTypeId + "]";
	}
	

}
