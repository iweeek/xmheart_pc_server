package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <Resp>
 <TransactionCode>JK1001</TransactionCode>
 <RespCode></RespCode>
 <RespMessage></RespMessage>
 <SysDateTime><SysDateTime>
 </Resp>
 */
@XmlRootElement(name = "Resp")
public class TestDb {

    private String TransactionCode;


    private String RespCode;


    private String RespMessage;


    private String SysDateTime;

    public  TestDb(){}

    @XmlElement(name = "TransactionCode")
    public String getTransactionCode() {
        return TransactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        TransactionCode = transactionCode;
    }

    @XmlElement(name = "RespCode")
    public String getRespCode() {
        return RespCode;
    }

    public void setRespCode(String respCode) {
        RespCode = respCode;
    }

    @XmlElement(name = "RespMessage")
    public String getRespMessage() {
        return RespMessage;
    }

    public void setRespMessage(String respMessage) {
        RespMessage = respMessage;
    }

    @XmlElement(name = "SysDateTime")
    public String getSysDateTime() {
        return SysDateTime;
    }

    public void setSysDateTime(String sysDateTime) {
        SysDateTime = sysDateTime;
    }
}
