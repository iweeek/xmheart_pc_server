package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PreInfo")
public class RegisteredSourcePreInfo {
    private String WorkDate;
    private String WorkType;
    private String DeptCode;
    private String DeptName;
    private String DocName;
    private String DocCode;
    private String STime;
    private String ETime;
    private Integer SpaceTime;
    private Integer PreLimit;
    private Integer Status;
    private String RegistCode;
    private String RegistName;
    private Integer PreNum;
    private String Remark;
    private String CliniqueCode;
    
    public RegisteredSourcePreInfo() {}

    public RegisteredSourcePreInfo(String workDate, String workType, String deptCode, String deptName, String docName, String docCode,
            String sTime, String eTime, Integer spaceTime, Integer preLimit, Integer status, String registCode,
            String registName, Integer preNum, String remark, String cliniqueCode) {
        super();
        WorkDate = workDate;
        WorkType = workType;
        DeptCode = deptCode;
        DeptName = deptName;
        DocName = docName;
        DocCode = docCode;
        STime = sTime;
        ETime = eTime;
        SpaceTime = spaceTime;
        PreLimit = preLimit;
        Status = status;
        RegistCode = registCode;
        RegistName = registName;
        PreNum = preNum;
        Remark = remark;
        CliniqueCode = cliniqueCode;
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

    @XmlElement(name = "Remark")
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String remark) {
        Remark = remark;
    }
    @XmlElement(name = "ETime")
    public String getETime() {
        return ETime;
    }

    public void setETime(String eTime) {
        ETime = eTime;
    }
    @XmlElement(name = "SpaceTime")
    public Integer getSpaceTime() {
        return SpaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        SpaceTime = spaceTime;
    }
    @XmlElement(name = "PreLimit")
    public Integer getPreLimit() {
        return PreLimit;
    }

    public void setPreLimit(Integer preLimit) {
        PreLimit = preLimit;
    }
    @XmlElement(name = "RegistCode")
    public String getRegistCode() {
        return RegistCode;
    }

    public void setRegistCode(String registCode) {
        RegistCode = registCode;
    }
    @XmlElement(name = "RegistName")
    public String getRegistName() {
        return RegistName;
    }

    public void setRegistName(String registName) {
        RegistName = registName;
    }
    @XmlElement(name = "PreNum")
    public Integer getPreNum() {
        return PreNum;
    }

    public void setPreNum(Integer preNum) {
        PreNum = preNum;
    }
    @XmlElement(name = "CliniqueCode")
    public String getCliniqueCode() {
        return CliniqueCode;
    }

    public void setCliniqueCode(String cliniqueCode) {
        CliniqueCode = cliniqueCode;
    }
}
