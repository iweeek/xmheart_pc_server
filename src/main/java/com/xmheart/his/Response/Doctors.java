package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <Resp>
 <TransactionCode>JK2003</TransactionCode>
 <RespCode>0</RespCode>
 <RespMessage>成功</RespMessage>
 <Doctor>
 <DeptCode>10600</DeptCode>
 <DocCode>267110</DocCode>
 <DocName>yxj1</DocName>
 <Spec></Spec>
 <Remark></Remark>
 <TitleName>主任医师</TitleName>
 <TitleCode>022</TitleCode>
 <Sex>0</Sex>
 <DeptName>肾内科门诊</DeptName>
 <ClinicFee>23</ClinicFee>
 <Date>
 <WorkDate>20151117</WorkDate>
 <WorkDate>20151110</WorkDate>
 </Date>
 </Doctor>
 ……
 </Resp>
 */
@XmlRootElement(name = "Resp")
public class Doctors {
    public String TransactionCode;
    public String RespCode;
    public String RespMessage;
    private List<Doctor> doctor;
    
    public Doctors() {}

    public Doctors(String transactionCode, String respCode, String respMessage, List<Doctor> doctor) {
        this.RespCode = respCode;
        this.TransactionCode = transactionCode;
        this.RespMessage = respMessage;
        this.doctor = doctor;
    }


    @XmlElement(name = "TransactionCode")
    public String getTransactionCode() {
        return TransactionCode;
    }
    public void setTransactionCode(String transactionCode) {
        this.TransactionCode = transactionCode;
    }
    @XmlElement(name = "RespCode")
    public String getRespCode() {
        return RespCode;
    }
    public void setRespCode(String respCode) {
        this.RespCode = respCode;
    }
    @XmlElement(name = "RespMessage")
    public String getRespMessage() {
        return RespMessage;
    }
    public void setRespMessage(String respMessage) {
        this.RespMessage = respMessage;
    }
    @XmlElement(name = "Doctor")
    public List<Doctor> getDoctor() {
        return doctor;
    }
    
    public void setDoctor(List<Doctor> doctor) {
        this.doctor = doctor;
    }
}
@XmlRootElement(name = "Doctor")
class Doctor{
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

