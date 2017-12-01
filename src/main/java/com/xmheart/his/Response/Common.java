package com.xmheart.his.Response;


import java.util.List;

public class Common {
}

class Date {
    private List<String> workDate;

    public Date() {}
    public Date(List<String> workDate) {
        this.workDate = workDate;
    }

    public List<String> getWorkDate() {
        return workDate;
    }

    public void setWorkDate(List<String> workDate) {
        this.workDate = workDate;
    }
}