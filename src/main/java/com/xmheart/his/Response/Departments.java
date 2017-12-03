package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
<Resp>
<TransactionCode>JK2002</TransactionCode>
<RespCode>0</RespCode>
<RespMessage>成功</RespMessage>
<UpperDept>
<UpperDeptCode>31100</UpperDeptCode>
<UpperDeptName>妇产科门诊</UpperDeptName>
<Dept>
<DeptCode>31100001</DeptCode>
<DeptName>产科门诊</DeptName>
<DeptLocus>地理位置</DeptLocus>
<Memo>科室介绍</Memo>
<Date>
<WorkDate>20151105</WorkDate>
<WorkDate>20151112</WorkDate>
  ….
</Date>
</Dept>
<Dept>
<DeptCode>31100002</DeptCode>
<DeptName>妇科门诊</DeptName>
<Date>
<WorkDate>20151117</WorkDate>
<WorkDate>20151110</WorkDate>
</Date>
</Dept>
</UpperDept>
…
</Resp>
 */
@XmlRootElement(name = "Resp")
public class Departments {
    private String transactionCode;
    private String respCode;
    private String respMessage;
    
    private List<Department> upperDept;

    public Departments() {}
    
    public Departments(String transactionCode, String respCode, String respMessage, List<Department> upperDept) {
        this.respCode = respCode;
        this.transactionCode = transactionCode;
        this.respMessage = respMessage;
        this.upperDept = upperDept;
    }
    
    @XmlElement(name = "UpperDept")
    public List<Department> getUpperDept() {
        return upperDept;
    }

    public void setUpperDept(List<Department> upperDept) {
        this.upperDept = upperDept;
    }
    
    @XmlElement(name = "TransactionCode")
    public String getTransactionCode() {
        return transactionCode;
    }
    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }
    @XmlElement(name = "RespCode")
    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    @XmlElement(name = "RespMessage")
    public String getRespMessage() {
        return respMessage;
    }
    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
    
}

