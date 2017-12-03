package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PreInfo")
public class RegisterPreInfo {
    private String CardNo;
    private String Mobile;
    private String Name;
    private Integer Sex;
    private String WorkDate;
    private String WorkType;
    private String DeptCode;
    private String DeptName;
    private String DocName;
    private String DocCode;
    private String STime;
    private Integer Status;
    private String SeqNumber;
    private String Remark;
    
    public RegisterPreInfo() {}
    public RegisterPreInfo(String cardNo, String mobile, String name, Integer sex, String workDate, String workType,
            String deptCode, String deptName, String docName, String docCode, String sTime, Integer status,
            String seqNumber, String remark) {
        super();
        CardNo = cardNo;
        Mobile = mobile;
        Name = name;
        Sex = sex;
        WorkDate = workDate;
        WorkType = workType;
        DeptCode = deptCode;
        DeptName = deptName;
        DocName = docName;
        DocCode = docCode;
        STime = sTime;
        Status = status;
        SeqNumber = seqNumber;
        Remark = remark;
    }
    @XmlElement(name = "CardNo")
    public String getCardNo() {
        return CardNo;
    }
    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }
    @XmlElement(name = "Mobile")
    public String getMobile() {
        return Mobile;
    }
    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    @XmlElement(name = "Sex")
    public Integer getSex() {
        return Sex;
    }
    public void setSex(Integer sex) {
        Sex = sex;
    }
    @XmlElement(name = "WorkDate")
    public String getWorkDate() {
        return WorkDate;
    }
    public void setWorkDate(String workDate) {
        WorkDate = workDate;
    }
    @XmlElement(name = "WorkType")
    public String getWorkType() {
        return WorkType;
    }
    public void setWorkType(String workType) {
        WorkType = workType;
    }
    @XmlElement(name = "DeptCode")
    public String getDeptCode() {
        return DeptCode;
    }
    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }
    @XmlElement(name = "DeptName")
    public String getDeptName() {
        return DeptName;
    }
    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
    @XmlElement(name = "DocName")
    public String getDocName() {
        return DocName;
    }
    public void setDocName(String docName) {
        DocName = docName;
    }
    @XmlElement(name = "DocCode")
    public String getDocCode() {
        return DocCode;
    }
    public void setDocCode(String docCode) {
        DocCode = docCode;
    }
    @XmlElement(name = "STime")
    public String getSTime() {
        return STime;
    }
    public void setSTime(String sTime) {
        STime = sTime;
    }
    @XmlElement(name = "Status")
    public Integer getStatus() {
        return Status;
    }
    public void setStatus(Integer status) {
        Status = status;
    }
    @XmlElement(name = "SeqNumber")
    public String getSeqNumber() {
        return SeqNumber;
    }
    public void setSeqNumber(String seqNumber) {
        SeqNumber = seqNumber;
    }
    @XmlElement(name = "Remark")
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String remark) {
        Remark = remark;
    }
}
