package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Doctor")
public class Doctor{
    private String DeptCode;
    private String DocCode;
    private String DocName;
    private String Spec;
    private String Remark;
    private String TitleName;
    private String TitleCode;
    private String Sex;
    private String DeptName;
    private String ClinicFee;
    private  Date Date;

    public Doctor() {}
    public Doctor(String deptCode, String docCode, String docName, String spec, String remark, String titleName, String titleCode, String sex, String deptName, String clinicFee, Date date) {
        DeptCode = deptCode;
        DocCode = docCode;
        DocName = docName;
        Spec = spec;
        Remark = remark;
        TitleName = titleName;
        TitleCode = titleCode;
        Sex = sex;
        DeptName = deptName;
        ClinicFee = clinicFee;
        Date = date;
    }
    @XmlElement(name = "DeptCode")
    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }
    @XmlElement(name = "DocCode")
    public String getDocCode() {
        return DocCode;
    }

    public void setDocCode(String docCode) {
        DocCode = docCode;
    }
    @XmlElement(name = "DocName")
    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }
    @XmlElement(name = "Spec")
    public String getSpec() {
        return Spec;
    }

    public void setSpec(String spec) {
        Spec = spec;
    }
    @XmlElement(name = "Remark")
    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }
    @XmlElement(name = "TitleName")
    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }
    @XmlElement(name = "TitleCode")
    public String getTitleCode() {
        return TitleCode;
    }

    public void setTitleCode(String titleCode) {
        TitleCode = titleCode;
    }
    @XmlElement(name = "Sex")
    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
    @XmlElement(name = "DeptName")
    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
    @XmlElement(name = "ClinicFee")
    public String getClinicFee() {
        return ClinicFee;
    }

    public void setClinicFee(String clinicFee) {
        ClinicFee = clinicFee;
    }
    @XmlElement(name = "Date")
    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }
}
