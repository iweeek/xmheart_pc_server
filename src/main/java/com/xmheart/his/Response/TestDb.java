package com.xmheart.his.Response;

/**
 * <Resp>
 <TransactionCode>JK1001</TransactionCode>
 <RespCode></RespCode>
 <RespMessage></RespMessage>
 <SysDateTime><SysDateTime>
 </Resp>
 */
public class TestDb {

    public String TransactionCode;

    public String RespCode;

    public String RespMessage;

    public String SysDateTime;

    public TestDb(String transactionCode, String respCode, String respMessage, String sysDateTime) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        SysDateTime = sysDateTime;
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

    public String getSysDateTime() {
        return SysDateTime;
    }

    public void setSysDateTime(String sysDateTime) {
        SysDateTime = sysDateTime;
    }
}
