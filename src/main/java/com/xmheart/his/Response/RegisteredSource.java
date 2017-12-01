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
    private List<PreInfos> preInfo;

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
    public List<PreInfos> getPreInfo() {
        return preInfo;
    }
    public void setPreInfo(List<PreInfos> preInfo) {
        this.preInfo = preInfo;
    }
    public Integer getCountNum() {
        return CountNum;
    }
    public void setCountNum(Integer countNum) {
        CountNum = countNum;
    }
    
}

@XmlRootElement(name = "PreInfo")
class PreInfos {
    private String WorkDate;
    private String WorkType;
    private String DeptCode;
    private String DeptName;
    private String DocName;
    private String DocCode;
    private String STime;
    private String ETime;
    private Integer SpaceTime;
    private Integer PreLimit;
    private Integer Status;
    private String RegistCode;
    private String RegistName;
    private Integer PreNum;
    private String Remark;
    private String CliniqueCode;
    
    public PreInfos() {}

    public PreInfos(String workDate, String workType, String deptCode, String deptName, String docName, String docCode,
            String sTime, String eTime, Integer spaceTime, Integer preLimit, Integer status, String registCode,
            String registName, Integer preNum, String remark, String cliniqueCode) {
        super();
        WorkDate = workDate;
        WorkType = workType;
        DeptCode = deptCode;
        DeptName = deptName;
        DocName = docName;
        DocCode = docCode;
        STime = sTime;
        ETime = eTime;
        SpaceTime = spaceTime;
        PreLimit = preLimit;
        Status = status;
        RegistCode = registCode;
        RegistName = registName;
        PreNum = preNum;
        Remark = remark;
        CliniqueCode = cliniqueCode;
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

    @XmlElement(name = "Remark")
    public String getRemark() {
        return Remark;
    }
    public void setRemark(String remark) {
        Remark = remark;
    }
    @XmlElement(name = "ETime")
    public String getETime() {
        return ETime;
    }

    public void setETime(String eTime) {
        ETime = eTime;
    }
    @XmlElement(name = "SpaceTime")
    public Integer getSpaceTime() {
        return SpaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        SpaceTime = spaceTime;
    }
    @XmlElement(name = "PreLimit")
    public Integer getPreLimit() {
        return PreLimit;
    }

    public void setPreLimit(Integer preLimit) {
        PreLimit = preLimit;
    }
    @XmlElement(name = "RegistCode")
    public String getRegistCode() {
        return RegistCode;
    }

    public void setRegistCode(String registCode) {
        RegistCode = registCode;
    }
    @XmlElement(name = "RegistName")
    public String getRegistName() {
        return RegistName;
    }

    public void setRegistName(String registName) {
        RegistName = registName;
    }
    @XmlElement(name = "PreNum")
    public Integer getPreNum() {
        return PreNum;
    }

    public void setPreNum(Integer preNum) {
        PreNum = preNum;
    }
    @XmlElement(name = "CliniqueCode")
    public String getCliniqueCode() {
        return CliniqueCode;
    }

    public void setCliniqueCode(String cliniqueCode) {
        CliniqueCode = cliniqueCode;
    }
}
