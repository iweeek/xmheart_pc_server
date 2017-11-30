package com.xmheart.his.Response;

import java.util.List;

/**
 * <Resp>
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
public class Departments {
    private String TransactionCode;
    private String RespCode;
    private String RespMessage;

    private List<_department> UpperDept;

    public Departments(String transactionCode, String respCode, String respMessage, List<_department> upperDept) {
        TransactionCode = transactionCode;
        RespCode = respCode;
        RespMessage = respMessage;
        UpperDept = upperDept;
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

    public List<_department> getUpperDept() {
        return UpperDept;
    }

    public void setUpperDept(List<_department> upperDept) {
        UpperDept = upperDept;
    }
}

class _department {
    private String UpperDeptCode;
    private String UpperDeptName;

    public _department(String upperDeptCode, String upperDeptName) {
        UpperDeptCode = upperDeptCode;
        UpperDeptName = upperDeptName;
    }

    public String getUpperDeptCode() {
        return UpperDeptCode;
    }

    public void setUpperDeptCode(String upperDeptCode) {
        UpperDeptCode = upperDeptCode;
    }

    public String getUpperDeptName() {
        return UpperDeptName;
    }

    public void setUpperDeptName(String upperDeptName) {
        UpperDeptName = upperDeptName;
    }
}

class _dept {
    private String DeptCode;
    private String DeptName;
    private  _date Date;

    public _dept(String deptCode, String deptName, _date date) {
        DeptCode = deptCode;
        DeptName = deptName;
        Date = date;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public _date getDate() {
        return Date;
    }

    public void setDate(_date date) {
        Date = date;
    }
}


