package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nimon
 *<Resp>
<TransactionCode> JK2005</TransactionCode>
<RespCode></RespCode>
<RespMessage></RespMessage>
<WorkDate>排班时间</WorkDate>
<WorkType>排班类别(1上午;2下午)</WorkType>
<DeptCode>科室代码</DeptCode>
<DocCode>医生代码</DocCode>
<Num>
< STime>号源开始时间（如08：00：00）</ STime>
< ETime >号源结束时间（如08：05：00）</ ETime >
<PreOrNo>是否可以预约（1可约，0不可约）</PreOrNo>
</Num>
</Resp>
 */
@XmlRootElement(name = "Resp")
public class RegisteredSourceTime {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private String WorkDate;
    private String WorkType;
    private String DeptCode;
    private String DocCode;
    private Num num;

    public RegisteredSourceTime() {}

    public RegisteredSourceTime(String transactionCode, String respCode, String respMessage, String workDate,
            String workType, String deptCode, String docCode, Num num) {
        super();
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        WorkDate = workDate;
        WorkType = workType;
        DeptCode = deptCode;
        DocCode = docCode;
        this.num =num;
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
    @XmlElement(name = "DocCode")
    public String getDocCode() {
        return DocCode;
    }

    public void setDocCode(String docCode) {
        DocCode = docCode;
    }
    @XmlElement(name = "Num")
    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }
}
@XmlRootElement(name = "Num")
class Num {
    private String STime; //号源开始时间（如08：05：00） Time
    private String ETime; //号源结束时间（如08：05：00） Time
    private Integer ProOrNo;  //是否可以预约（1可约，0不可约）
    public Num(String sTime, String eTime, Integer proOrNo) {
        super();
        STime = sTime;
        ETime = eTime;
        ProOrNo = proOrNo;
    }
    public Num() {
    }
    @XmlElement(name = "STime")
    public String getSTime() {
        return STime;
    }
    public void setSTime(String sTime) {
        STime = sTime;
    }
    @XmlElement(name = "ETime")
    public String getETime() {
        return ETime;
    }
    public void setETime(String eTime) {
        ETime = eTime;
    }
    @XmlElement(name = "ProOrNo")
    public Integer getProOrNo() {
        return ProOrNo;
    }
    public void setProOrNo(Integer proOrNo) {
        ProOrNo = proOrNo;
    }
    
}
