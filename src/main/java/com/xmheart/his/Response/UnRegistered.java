package com.xmheart.his.Response;

/**
 * <Resp>
 <TransactionCode> JK2007</TransactionCode>
 <RespMessage></RespMessage>
 <RespCode></RespCode>
 </Resp>
 */
public class UnRegistered {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;

    public UnRegistered(String transactionCode, String respCode, String respMessage) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
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
}
