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
    private List<PreInfo> preInfo;

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
    public List<PreInfo> getPreInfo() {
        return preInfo;
    }
    public void setPreInfo(List<PreInfo> preInfo) {
        this.preInfo = preInfo;
    }
    
}

@XmlRootElement(name = "PreInfo")
class PreInfo {
    private String CardNo;
    private String Mobile;
    private String Name;
    private Integer Sex;
    private String WorkDate;
    private String WorkType;
    private String DeptCode;
    private String DeptName;
    private String DocName;
    private String DocCode;
    private String STime;
    private Integer Status;
    private String SeqNumber;
    private String Remark;
    
    public PreInfo() {}
    public PreInfo(String cardNo, String mobile, String name, Integer sex, String workDate, String workType,
            String deptCode, String deptName, String docName, String docCode, String sTime, Integer status,
            String seqNumber, String remark) {
        super();
        CardNo = cardNo;
        Mobile = mobile;
        Name = name;
        Sex = sex;
        WorkDate = workDate;
        WorkType = workType;
        DeptCode = deptCode;
        DeptName = deptName;
        DocName = docName;
        DocCode = docCode;
        STime = sTime;
        Status = status;
        SeqNumber = seqNumber;
        Remark = remark;
    }
    @XmlElement(name = "CardNo")
    public String getCardNo() {
        return CardNo;
    }
    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }
    @XmlElement(name = "Mobile")
    public String getMobile() {
        return Mobile;
    }
    public void setMobile(String mobile) {
        Mobile = mobile;
    }
    @XmlElement(name = "Name")
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    @XmlElement(name = "Sex")
    public Integer getSex() {
        return Sex;
    }
    public void setSex(Integer sex) {
        Sex = sex;
    }
    @XmlElement(name = "WorkDate")
    public String getWorkDate() {
        return WorkDate;
    }
    public void setWorkDate(String workDate) {
        WorkDate = workDate;
    }
    @XmlElement(name = "WorkType")
    public String getWorkType() {
        return WorkType;
    }
    public void setWorkType(String workType) {
        WorkType = workType;
    }
    @XmlElement(name = "DeptCode")
    public String getDeptCode() {
        return DeptCode;
    }
    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }
    @XmlElement(name = "DeptName")
    public String getDeptName() {
        return DeptName;
    }
    public void setDeptName(String deptName) {
        DeptName = deptName;
    }
    @XmlElement(name = "DocName")
    public String getDocName() {
        return DocName;
    }
    public void setDocName(String docName) {
        DocName = docName;
    }
    @XmlElement(name = "DocCode")
    public String getDocCode() {
        return DocCode;
    }
    public void setDocCode(String docCode) {
        DocCode = docCode;
    }
    @XmlElement(name = "STime")
    public String getSTime() {
        return STime;
    }
    public void setSTime(String sTime) {
        STime = sTime;
    }
    @XmlElement(name = "Status")
    public Integer getStatus() {
        return Status;
    }
    public void setStatus(Integer status) {
        Status = status;
    }
    @XmlElement(name = "SeqNumber")
    public String getSeqNumber() {
        return SeqNumber;
    }
    public void setSeqNumber(String seqNumber) {
        SeqNumber = seqNumber;
    }
    @XmlElement(name = "Remark")
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String remark) {
        Remark = remark;
    }
}
