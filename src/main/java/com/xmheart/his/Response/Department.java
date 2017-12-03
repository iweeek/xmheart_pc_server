package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UpperDept")
public class Department {
    private String upperDeptCode;
    private String upperDeptName;
    private HisDept dept;

    public Department(String upperDeptCode, String upperDeptName, HisDept dept) {
        super();
        this.upperDeptCode = upperDeptCode;
        this.upperDeptName = upperDeptName;
        this.dept = dept;
    }

    public Department() {
    }

    @XmlElement(name = "UpperDeptCode")
    public String getUpperDeptCode() {
        return upperDeptCode;
    }

    public void setUpperDeptCode(String upperDeptCode) {
        this.upperDeptCode = upperDeptCode;
    }

    @XmlElement(name = "UpperDeptName")
    public String getUpperDeptName() {
        return upperDeptName;
    }

    public void setUpperDeptName(String upperDeptName) {
        this.upperDeptName = upperDeptName;
    }

    @XmlElement(name = "Dept")
    public HisDept getDept() {
        return dept;
    }

    public void setDept(HisDept dept) {
        this.dept = dept;
    }

}
