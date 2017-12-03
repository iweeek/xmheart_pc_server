package com.xmheart.his.Response;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Date")
public class HisDate {
    private List<String> workDate;

    public HisDate() {}
    
    @XmlElement(name = "WorkDate")
    public List<String> getWorkDate() {
        return workDate;
    }

    public void setWorkDate(List<String> workDate) {
        this.workDate = workDate;
    }
}