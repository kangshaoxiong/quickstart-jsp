package com.my.quickstart.base;

public class Sort {
    private static String DEFAULT_SORTTYPE="DESC";
    private static String DEFAULT_SORTBY="id";
    private String sortType;
    private String sortBy;
    public Sort() {
        this(DEFAULT_SORTBY,DEFAULT_SORTTYPE);
    }
    public Sort(String sortBy,String sortType){
        this.sortType=sortType;
        this.sortBy=sortBy;
    }
    public String getSortType() {
        return sortType;
    }
    public String getSortBy() {
        return sortBy;
    }
    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
