package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Resp")
public class NoCardRegister {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private String SickID;

    public NoCardRegister() {}
    

    public NoCardRegister(String transactionCode, String respCode, String respMessage, String sickID) {
        super();
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        SickID = sickID;
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
    @XmlElement(name = "SickID")
    public String getSickID() {
        return SickID;
    }
    public void setSickID(String sickID) {
        SickID = sickID;
    }
}
