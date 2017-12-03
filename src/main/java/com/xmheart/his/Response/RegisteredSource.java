package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nimon
 * <Resp>
<TransactionCode> JK2004</TransactionCode>
<RespCode></RespCode>
<RespMessage></RespMessage>
<CountNum>总记录数</CountNum>
<PreInfo>
<WorkDate>排班时间</WorkDate>
<WorkType>排班类别(1上午;2下午)</WorkType>
<DeptCode>科室代码</DeptCode>
<DocCode>医生代码</DocCode>
<DeptName>科室名称</DeptName>
<DocName>医生名称</DocName>
<STime>排班开始时间 8:00:00</STime>
<ETime>排班结束时间9:00:00</ETime>
<SpaceTime>间隔时间(分)（如5分钟一次）</SpaceTime>
<PreLimit>预约限号（可预约号数）</PreLimit>
<Status>医生排班状态（0接诊，1停诊）</Status>
<RegistCode>挂号类别代码</RegistCode>
<RegistName>挂号类别名称</RegistName>
< PreNum>当前可预约数量</ PreNum>
<Remark>备注</Remark>
<CliniqueCode>诊室</CliniqueCode>
</ PreInfo>
……
</Resp>
 */
@XmlRootElement(name = "Resp")
public class RegisteredSource {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;
    private Integer CountNum;
    private List<RegisteredSourcePreInfo> preInfo;

    public RegisteredSource() {}
    public RegisteredSource(String transactionCode, String respCode, String respMessage) {
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
    public List<RegisteredSourcePreInfo> getPreInfo() {
        return preInfo;
    }
    public void setPreInfo(List<RegisteredSourcePreInfo> preInfo) {
        this.preInfo = preInfo;
    }
    public Integer getCountNum() {
        return CountNum;
    }
    public void setCountNum(Integer countNum) {
        CountNum = countNum;
    }
}
