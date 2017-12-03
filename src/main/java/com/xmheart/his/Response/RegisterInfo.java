package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nimon
 *<Resp>
<TransactionCode> JK2008</TransactionCode>
<RespCode></RespCode>
<RespMessage></RespMessage>
<PreInfo>
<CardNo>就诊卡号</CardNo>
<Mobile>联系电话</Mobile>
<Name>患者姓名</Name>
<Sex>患者性别(0男;1女;2未知;9未定)</Sex>
<WorkDate>预约日期</WorkDate>
<WorkType>预约的排班类别(1上午;2下午)</WorkType>
<DeptCode>科室代码</DeptCode>
<DeptName>科室名称</DeptName>
<DocName>医生姓名</DocName>
<DocCode>医生工号</DocCode>
<STime>号源开始时间</STime>
<ETime>号源结束时间</ETime>
<Status>预约状态（1预约，2退号 ,3就诊，4其他,0所有）</Status>
<SeqNumber> HIS序号</SeqNumber>
<Remark>Remark</Remark>
</PreInfo>
<PreInfo>
…….
</PreInfo>
  . ……
</Resp>
 */
@XmlRootElement(name = "Resp")
public class RegisterInfo {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private List<RegisterPreInfo> preInfo;

    public RegisterInfo() {}
    public RegisterInfo(String transactionCode, String respCode, String respMessage) {
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
    @XmlElement(name = "PreInfo")
    public List<RegisterPreInfo> getPreInfo() {
        return preInfo;
    }
    public void setPreInfo(List<RegisterPreInfo> preInfo) {
        this.preInfo = preInfo;
    }
    
}

