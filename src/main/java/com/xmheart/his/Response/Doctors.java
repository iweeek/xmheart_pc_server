package com.xmheart.his.Response;

import java.util.List;

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
public class Doctors {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private List<_Doctor> Doctor;

    public Doctors(String transactionCode, String respCode, String respMessage, List<_Doctor> doctor) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        Doctor = doctor;
    }

    public String getTransactionCode() {
        return TransactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        TransactionCode = transactionCode;
    }

    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String respCode) {
        RespCode = respCode;
    }

    public String getRespMessage() {
        return RespMessage;
    }

    public void setRespMessage(String respMessage) {
        RespMessage = respMessage;
    }

    public List<_Doctor> getDoctor() {
        return Doctor;
    }

    public void setDoctor(List<_Doctor> doctor) {
        Doctor = doctor;
    }
}

class _Doctor{
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
    private  _date Date;

    public _Doctor(String deptCode, String docCode, String docName, String spec, String remark, String titleName, String titleCode, String sex, String deptName, String clinicFee, _date date) {
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

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getDocCode() {
        return DocCode;
    }

    public void setDocCode(String docCode) {
        DocCode = docCode;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public String getSpec() {
        return Spec;
    }

    public void setSpec(String spec) {
        Spec = spec;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getTitleName() {
        return TitleName;
    }

    public void setTitleName(String titleName) {
        TitleName = titleName;
    }

    public String getTitleCode() {
        return TitleCode;
    }

    public void setTitleCode(String titleCode) {
        TitleCode = titleCode;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getClinicFee() {
        return ClinicFee;
    }

    public void setClinicFee(String clinicFee) {
        ClinicFee = clinicFee;
    }

    public _date getDate() {
        return Date;
    }

    public void setDate(_date date) {
        Date = date;
    }
}

