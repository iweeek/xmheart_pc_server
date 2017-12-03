package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dept")
public class HisDept {
    private String deptCode;
    private String deptName;
    private String deptLocus;
    private String memo;
    private HisDate date;

    public HisDept() {}
    
    public HisDept(String deptCode, String deptName, HisDate date) {
        this.deptCode = deptCode;
        this.deptName = deptName;
        this.date = date;
    }
    @XmlElement(name = "DeptCode")
    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
    @XmlElement(name = "DeptName")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    @XmlElement(name = "Date")
    public HisDate getDate() {
        return date;
    }

    public void setDate(HisDate date) {
        this.date = date;
    }
    @XmlElement(name = "DeptLocus")
    public String getDeptLocus() {
        return deptLocus;
    }

    public void setDeptLocus(String deptLocus) {
        this.deptLocus = deptLocus;
    }
    @XmlElement(name = "Memo")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}