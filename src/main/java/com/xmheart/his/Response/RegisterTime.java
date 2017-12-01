package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nimon
 *<Resp>
<TransactionCode>JK2001</TransactionCode>
<RespCode>0</RespCode>
<RespMessage>成功</RespMessage>
<Date>
<WorkDate>20151105</WorkDate>
<WorkDate>20151112</WorkDate>
<WorkDate>20151107</WorkDate>
</Date>
</Resp>
 */
@XmlRootElement(name = "Resp")
public class RegisterTime {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private Date date;

    public RegisterTime() {}
    public RegisterTime(String transactionCode, String respCode, String respMessage) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
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
    @XmlElement(name = "date")
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
