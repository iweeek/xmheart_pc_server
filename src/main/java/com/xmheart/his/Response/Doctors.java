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
    private String transactionCode; // public 会出现重复的属性
    private String respCode;
    private String respMessage;
    private List<Doctor> doctor;
    
    public Doctors() {}

    public Doctors(String transactionCode, String respCode, String respMessage, List<Doctor> doctor) {
        this.respCode = respCode;
        this.transactionCode = transactionCode;
        this.respMessage = respMessage;
        this.doctor = doctor;
    }

    @XmlElement(name = "TransactionCode")
    public String getTransactionCode() {
        return transactionCode;
    }
    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }
    @XmlElement(name = "RespCode")
    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    @XmlElement(name = "RespMessage")
    public String getRespMessage() {
        return respMessage;
    }
    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
    @XmlElement(name = "Doctor")
    public List<Doctor> getDoctor() {
        return doctor;
    }
    
    public void setDoctor(List<Doctor> doctor) {
        this.doctor = doctor;
    }
}



