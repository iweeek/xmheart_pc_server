package com.xmheart.his.Response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <Resp>
 <TransactionCode> JK2006</TransactionCode>
 <RespCode></RespCode>
 <RespMessage>成功</RespMessage>
 <MemoTips>预约成功</ MemoTips >
 < SeqNumber> HIS序号</ SeqNumber>
 </Resp>
 */
@XmlRootElement(name = "Resp")
public class Registered {

    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private String MemoTips;
    private String SeqNumber;

    public Registered() {}
    public Registered(String transactionCode, String respCode, String respMessage, String memoTips, String seqNumber) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        MemoTips = memoTips;
        SeqNumber = seqNumber;
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
    @XmlElement(name = "MemoTips")
    public String getMemoTips() {
        return MemoTips;
    }

    public void setMemoTips(String memoTips) {
        MemoTips = memoTips;
    }
    @XmlElement(name = "SeqNumber")
    public String getSeqNumber() {
        return SeqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        SeqNumber = seqNumber;
    }
}
