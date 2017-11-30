package com.xmheart.his.Response;

/**
 * <Resp>
 <TransactionCode> JK2006</TransactionCode>
 <RespCode></RespCode>
 <RespMessage>成功</RespMessage>
 <MemoTips>预约成功</ MemoTips >
 < SeqNumber> HIS序号</ SeqNumber>
 </Resp>
 */
public class Registered {

    private String TransactionCode;
    private String RespCode;
    private String RespMessage;

    private String MemoTips;

    private String SeqNumber;

    public Registered(String transactionCode, String respCode, String respMessage, String memoTips, String seqNumber) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        MemoTips = memoTips;
        SeqNumber = seqNumber;
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

    public String getMemoTips() {
        return MemoTips;
    }

    public void setMemoTips(String memoTips) {
        MemoTips = memoTips;
    }

    public String getSeqNumber() {
        return SeqNumber;
    }

    public void setSeqNumber(String seqNumber) {
        SeqNumber = seqNumber;
    }
}
