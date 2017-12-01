package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nimon
 *
 */
@XmlRootElement(name = "Resp")
public class PatientInfo {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private List<SickInfo> sickInfo;

    public PatientInfo() {}

    public PatientInfo(String transactionCode, String respCode, String respMessage, List<SickInfo> sickInfo) {
        super();
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        this.sickInfo = sickInfo;
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
    @XmlElement(name = "SickInfo")
    public List<SickInfo> getSickInfo() {
        return sickInfo;
    }

    public void setSickInfo(List<SickInfo> sickInfo) {
        this.sickInfo = sickInfo;
    }
   
}
@XmlRootElement(name = "SickInfo")
class SickInfo {
    private String PatientID;
    private String CardNo;
    private String McardNo;
    private Integer dispbala;
    private String resibala;
    private String CardStatus;
    private String Name;
    private String Sex;
    private String Age;
    private String Mobile;
    private String RateType;
    private String IDCardID;
    private Date BirthDay;
    private String ResiNo;
    private String ResiState;
    
    public SickInfo() {}
    
    public SickInfo(String patientID, String cardNo, String mcardNo, Integer dispbala, String resibala,
            String cardStatus, String name, String sex, String age, String mobile, String rateType, String iDCardID,
            Date birthDay, String resiNo, String resiState) {
        super();
        PatientID = patientID;
        CardNo = cardNo;
        McardNo = mcardNo;
        this.dispbala = dispbala;
        this.resibala = resibala;
        CardStatus = cardStatus;
        Name = name;
        Sex = sex;
        Age = age;
        Mobile = mobile;
        RateType = rateType;
        IDCardID = iDCardID;
        BirthDay = birthDay;
        ResiNo = resiNo;
        ResiState = resiState;
    }
    
    @XmlElement(name = "PatientID")
    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }
    @XmlElement(name = "CardNo")
    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }
    @XmlElement(name = "McardNo")
    public String getMcardNo() {
        return McardNo;
    }

    public void setMcardNo(String mcardNo) {
        McardNo = mcardNo;
    }
    @XmlElement(name = "dispbala")
    public Integer getDispbala() {
        return dispbala;
    }

    public void setDispbala(Integer dispbala) {
        this.dispbala = dispbala;
    }
    @XmlElement(name = "SickInfo")
    public String getResibala() {
        return resibala;
    }

    public void setResibala(String resibala) {
        this.resibala = resibala;
    }
    @XmlElement(name = "CardStatus")
    public String getCardStatus() {
        return CardStatus;
    }

    public void setCardStatus(String cardStatus) {
        CardStatus = cardStatus;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    @XmlElement(name = "Sex")
    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }
    @XmlElement(name = "Age")
    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
    @XmlElement(name = "Mobile")
    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    @XmlElement(name = "RateType")
    public String getRateType() {
        return RateType;
    }

    public void setRateType(String rateType) {
        RateType = rateType;
    }
    @XmlElement(name = "IDCardID")
    public String getIDCardID() {
        return IDCardID;
    }

    public void setIDCardID(String iDCardID) {
        IDCardID = iDCardID;
    }
    @XmlElement(name = "BirthDay")
    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }
    @XmlElement(name = "ResiNo")
    public String getResiNo() {
        return ResiNo;
    }

    public void setResiNo(String resiNo) {
        ResiNo = resiNo;
    }
    @XmlElement(name = "ResiState")
    public String getResiState() {
        return ResiState;
    }

    public void setResiState(String resiState) {
        ResiState = resiState;
    }
}
