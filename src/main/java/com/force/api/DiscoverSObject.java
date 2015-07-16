package com.force.api;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ryan Brainard
 */
public class DiscoverSObject<T> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4415136166834317930L;
	private DescribeSObjectBasic describeSObjectBasic;
    private List<T> recentItems;

    DiscoverSObject(DescribeSObjectBasic describeSObjectBasic, List<T> recentItems) {
        this.describeSObjectBasic = describeSObjectBasic;
        this.recentItems = recentItems;
    }

    public DescribeSObjectBasic getObjectDescribe() {
        return describeSObjectBasic;
    }

    public List<T> getRecentItems() {
        return recentItems;
    }
}
