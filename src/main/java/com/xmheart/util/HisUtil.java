package com.xmheart.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xmheart.util.soap.*;

import com.xmheart.his.Response.*;


/**
 * His系统对接层
 */
public class HisUtil {

	private static boolean isDevelop = false;
	
    private static final Log log = LogFactory.getLog(HisUtil.class);
//    private static final String AUTHCODE = "cs20171011";
    private static final String AUTHCODE = "ZS20171211";
    
    public static String handleResp(String resp){
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" + resp;
    }

    public static TestDb testDb() {
        String requestXml = "<Req>" +
          "<oracode>00002</oracode>" +
          "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
          "<TransactionCode>JK1001</TransactionCode>" +
          "</Req>";
        String tradeCode = "JK1001";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        System.out.println(retMsg);
        return (TestDb)XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), TestDb.class);
    }
    
    public static Hospitals hospitalInfo(String hostID) {
        String requestXml = "<Req>" +
          "<oracode>00002</oracode>" +
          "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
          "<TransactionCode>JK1002</TransactionCode>" +
          "<HosID>" + hostID + "</HosID>" +
          "</Req>";
        String tradeCode = "JK1002";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        System.out.println(retMsg);
        return (Hospitals)XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Hospitals.class);
    }
    
    /**
     * 4.1 查询门诊可预约时间
     * <Req>
        <oracode>交易厂商代码</oracode>
        <oraauthcode>厂商授权码 </oraauthcode>
        <TransactionCode> JK2001</TransactionCode>
        <DeptCode>科室代码</DeptCode>
        <DeptName>科室名称</DeptName>
        <DoctorCode>医生编码</DoctorCode>
        <DoctorName>医生姓名</DoctorName>
        <WorkDateStart>查询有出诊日期范围 开始</WorkDateStart>
        <WorkDateEnd>查询有出诊日期范围 结束</WorkDateEnd>
        <WorkTime>查询有出诊日期范围 时段0-全天 1-上午 2-下午</WorkTime>
        </Req>
     */
    public static RegisterTime registerTime(String deptCode, String deptName, String doctorCode, String doctorName,
            String workTime, String workDateStart, String workDateEnd) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK2001</TransactionCode>" +
                "<DeptCode>" + deptCode +"</DeptCode>" +
                "<DeptName>" + deptName + "</DeptName>" +
                "<DoctorCode>" + doctorCode + "</DoctorCode>" +
                "<DoctorName>" + doctorName + "</DoctorName>" +
                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
                "<WorkTime>" + workTime + "</WorkTime>" +
                "</Req>";
        
        System.out.println("requestXml: \n" + requestXml + "\n");
        String tradeCode = "JK2001";
        
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
//        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        System.out.println("4.1 RegisterTime \n" + retMsg);
        return (RegisterTime) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), RegisterTime.class);
    }
    
    /**
     * 4.2 查询门诊科室
     * <Req>
     <oracode>交易厂商代码</oracode>
     <oraauthcode>厂商授权码 </oraauthcode>
     <TransactionCode> JK2002</TransactionCode>
     <Type>类型：0所有科室，1有排班科室</Type>
     <WorkDateStart>查询有出诊日期范围 开始</WorkDateStart>
     <WorkDateEnd>查询有出诊日期范围 结束</WorkDateEnd>
     <WorkTime>查询有出诊日期范围 时段0-全天 1-上午 2-下午</WorkTime>
     </Req>
     */
    public static Departments departments(String type, String workTime, String workDateStart, String workDateEnd) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK2002</TransactionCode>" +
                "<Type>" + type +"</Type>" +
                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
                "<WorkTime>" + workTime + "</WorkTime>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2002";

        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.2 \n" + retMsg);
        return (Departments) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Departments.class);
    }

    /**
     * 4.3 查询门诊医生
     *
     * <Req>
        <oracode>交易厂商代码</oracode>
        <oraauthcode>厂商授权码 </oraauthcode>
        <TransactionCode> JK2003</TransactionCode>
        <Type>类型：0所有医生，1有排班医生</Type>
        <DeptCode>科室代码</DeptCode>
        <DeptName>科室名称（支持模糊检索）</DeptName>
        <WorkDateStart>查询有出诊日期范围 开始</WorkDateStart>
        <WorkDateEnd>查询有出诊日期范围 结束</WorkDateEnd>
        </Req>
     */
    public static Doctors doctors(String type, String deptCode, String DeptName, String workDateStart, String workDateEnd) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK2003</TransactionCode>" +
                "<Type>" + type + "</Type>" +
                "<DeptCode>" + deptCode +  "</DeptCode>" +
                "<DeptName>" + DeptName + "</DeptName>" +
                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2003";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.3 Doctors \n" + retMsg);
        return (Doctors) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Doctors.class);
    }

    /**
     * 4.4 查询门诊排班号源
     *
     * <Req>
        <oracode>交易厂商代码</oracode>
        <oraauthcode>厂商授权码 </oraauthcode>
        <TransactionCode> JK2004</TransactionCode>
        <WorkDateStart>查询预约日期范围 开始</WorkDateStart>
        <WorkDateEnd>查询预约日期范围 结束</WorkDateEnd>
        <DoctorCode>医生编码</DoctorCode>
        <DeptCode>科室编码</DeptCode>
        <WorkTime>查询有出诊日期范围 时段0-全天 1-上午 2-下午</WorkTime>
        <Status>医生排班状态（0接诊，1停诊,2所有）</Status>
        </Req>
     */
    public static RegisteredSource registeredSource(String deptCode, String doctorCode, String status,
            String workTime, String workDateStart, String workDateEnd) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK2004</TransactionCode>" +
                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
                "<DoctorCode>" + doctorCode + "</DoctorCode>" +
                "<DeptCode>" + deptCode + "</DeptCode>" +
                "<WorkTime>" + workTime + "</WorkTime>" +
                "<Status>" + status + "</Status>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2004";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.4 RegisteredSource \n" + retMsg);
        return (RegisteredSource)XmlUtil.xmlToObject(retMsg, RegisteredSource.class);
    }
    
    /**
     * 4.5 查询门诊号源对应的预约时间点
     *
     * <Req>
        <oracode>交易厂商代码</oracode>
        <oraauthcode>厂商授权码 </oraauthcode>
        <TransactionCode> JK2005</TransactionCode>
        <WorkDate>排班时间</WorkDate>
        <WorkType>排班类别(1上午;2下午)</WorkType>
        <DeptCode>科室代码</DeptCode>
        <DocCode>医生代码</DocCode>
        </Req>
     */
    public static RegisteredSourceTime registeredSourceTime(String workDate, String workType, String deptCode,
            String docCode) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK2005</TransactionCode>" +
                "<WorkDate>" + workDate + "</WorkDate>" +
                "<WorkType>" + workType + "</WorkType>" +
                "<DeptCode>" + deptCode + "</DeptCode>" +
                "<DocCode>" + docCode + "</DocCode>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2005";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.5 RegisteredSourceTime \n" + retMsg);
        return (RegisteredSourceTime)XmlUtil.xmlToObject(retMsg, RegisteredSourceTime.class);
    }
    
    /**
     * 4.6 挂号预约
     *
     * <Req>
     <oracode>交易厂商代码</oracode>
     <oraauthcode>厂商授权码 </oraauthcode>
     <TransactionCode> JK2006</TransactionCode>
     <OrderID>订单号（健康之路订单号）</OrderID>
     <IDCardNo>身份证号</IDCardNo>
     <CardNo>就诊卡号</CardNo>
     <Mobile>联系电话</Mobile>
     <Name>患者姓名</Name>
     <WorkDate>预约日期</WorkDate>
     <WorkType>预约的排班类别(1上午;2下午)</WorkType>
     <DeptCode>科室代码</DeptCode>
     <DocCode>医生代码</DocCode>
     <STime>号源开始时间（如08：00：00）</STime>
     <UserId>微信号</UserId>
     <CustomTime>第三方当前系统时间</CustomTime>
     <SickID>病人唯一号</SickID>
     </Req>
     */
    public static Registered  registered(String orderId, String idCardNo, String cardNo, String mobile, String name, String workdate, String workType, String deptCode,
                                         String docCode, String stime, String userid, String customTime, String sickId) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode> JK2006</TransactionCode>" +
                "<OrderID>"+orderId+"</OrderID>" +
                "<IDCardNo>"+idCardNo+"</IDCardNo>" +
                "<CardNo>"+cardNo+"</CardNo>" +
                "<Mobile>"+mobile+"</Mobile>" +
                "<Name>"+name+"</Name>" +
                "<WorkDate>"+workdate+"</WorkDate>" +
                "<WorkType>"+workType+"</WorkType>" +
                "<DeptCode>"+deptCode+"</DeptCode>" +
                "<DocCode>"+docCode+"</DocCode>" +
                "<STime>"+stime+"</STime>" +
                "<UserId>"+userid+"</UserId>" +
                "<CustomTime>"+customTime+"</CustomTime>" +
                "<SickID>"+sickId+"</SickID>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2006";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.6 Registered \n" + retMsg);
        return (Registered)XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Registered.class);
    }

    /**
     * 4.7 取消挂号预约
     */
    public static UnRegistered  unRegistered(String orderId, String seqNumber, String reason, String cardNo, String name, String workdate, String workType, String deptCode,
                                             String docCode, String userid, String customTime, String sickId) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode> JK2007</TransactionCode>" +
                "<OrderID>"+orderId+"</OrderID>" +
                "<Reason>"+reason+"</Reason>" +
                "<SeqNumber>"+seqNumber+"</SeqNumber>" +
                "<Name>"+name+"</Name>" +
                "<CardNo>"+cardNo+"</CardNo>" +
                "<WorkDate>"+workdate+"</WorkDate>" +
                "<WorkType>"+workType+"</WorkType>" +
                "<DeptCode>"+deptCode+"</DeptCode>" +
                "<DocCode>"+docCode+"</DocCode>" +
                "<UserId>"+userid+"</UserId>" +
                "<CustomTime>"+customTime+"</CustomTime>" +
                "<SickID>"+sickId+"</SickID>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2007";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.7 UnRegistered \n" + retMsg);
        return (UnRegistered) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), UnRegistered.class);
    }

    /**
     * 4.8 预约信息查询
     */
    public static RegisterInfo registerInfo(String IDCardNo, String seqNumber,
            String workdate, String cardNo, String deptCode,
            String docCode, String status, String sickId) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode> JK2008</TransactionCode>" +
                "<IDCardNo>"+IDCardNo+"</IDCardNo>" +
                "<CardNo>"+cardNo+"</CardNo>" +
                "<WorkDate>"+workdate+"</WorkDate>" +
                "<SeqNumber>"+seqNumber+"</SeqNumber>" +
                "<DocCode>"+docCode+"</DocCode>" +
                "<DeptCode>"+deptCode+"</DeptCode>" +
                "<Status>"+status+"</Status>" +
                "<SickID>"+sickId+"</SickID>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK2008";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("4.8 RegisterInfo \n" + retMsg);
        return (RegisterInfo) XmlUtil.xmlToObject(retMsg, RegisterInfo.class);
    }

    
    /**
     * 5.1 获取患者基本信息
     * <Req>
        <oracode>交易厂商代码</oracode>
        <oraauthcode>厂商授权码 </oraauthcode>
        <TransactionCode> JK5001</TransactionCode>
            <CardNo>就诊卡号</CardNo>
            <IDCardID>身份证号</IDCardID>
            <Mobile>手机号</Mobile>
            <Name>姓名</Name>
        <McardNo>医疗保险号</McardNo>
        <SickID>病人唯一号</SickID>
        </Req>
     */
    public static PatientInfo patientInfo(String IDCardNo, String mobile,
            String name, String cardNo, String mcardNo, String sickId) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK5001</TransactionCode>" +
                "<IDCardNo>"+IDCardNo+"</IDCardNo>" +
                "<CardNo>"+cardNo+"</CardNo>" +
                "<Mobile>"+mobile+"</Mobile>" +
                "<Name>"+name+"</Name>" +
                "<McardNo>"+mcardNo+"</McardNo>" +
                "<SickID>"+sickId+"</SickID>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK5001";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("5.1 PatientInfo \n" + retMsg);
        return (PatientInfo) XmlUtil.xmlToObject(retMsg, PatientInfo.class);
    }
    
    /**
     * 5.3 无卡预注册
     * <Req>
        <oracode>交易厂商代码</oracode>
        <oraauthcode>厂商授权码 </oraauthcode>
        <TransactionCode>JK5003</TransactionCode>
        <IDCardID>身份证号</IDCardID>
        <Mobile>手机号</Mobile>
        <Name>姓名</Name>
        <Address>联系地址</Address>
        <BirthDay>出生日期</BirthDay>
        <Sex>性别</Sex>
        <UserID>微信号</UserID>
        </Req>
     */
    public static NoCardRegister noCardRegister(String IDCardNo, String mobile,
            String name, String address, String birthDay, String sex, String userID) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>" + AUTHCODE + "</oraauthcode>" +
                "<TransactionCode>JK5003</TransactionCode>" +
                "<IDCardID>"+IDCardNo+"</IDCardID>" +
                "<Mobile>"+mobile+"</Mobile>" +
                "<Name>"+name+"</Name>" +
                "<Address>"+address+"</Address>" +
                "<BirthDay>"+birthDay+"</BirthDay>" +
                "<Sex>"+sex+"</Sex>" +
                "<UserID>"+userID+"</UserID>" +
                "</Req>";
        System.out.println("requestXml: \n" + requestXml + "\n");
        
        String tradeCode = "JK5003";
        
        String retMsg = "";
        if (isDevelop) {
        		retMsg = "";
        } else {
        		Service1 service = new Service1();
            Service1Soap service1Soap =  service.getService1Soap();
        		retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        }
        
        System.out.println("5.3 NoCardRegister \n" + retMsg);
        return (NoCardRegister) XmlUtil.xmlToObject(retMsg, NoCardRegister.class);
    }
}
