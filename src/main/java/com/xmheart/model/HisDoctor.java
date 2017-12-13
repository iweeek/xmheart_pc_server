package com.xmheart.model;

public class HisDoctor {

    private String name;
    private int workType;
    
    
    public HisDoctor(String name, int workType) {
        super();
        this.name = name;
        this.workType = workType;
    }
    public HisDoctor() {
        // TODO Auto-generated constructor stub
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWorkType() {
        return workType;
    }
    public void setWorkType(int workType) {
        this.workType = workType;
    }
    
    
}
