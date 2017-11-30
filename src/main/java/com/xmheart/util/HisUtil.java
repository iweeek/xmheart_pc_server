package com.xmheart.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xmheart.util.soap.*;

import com.xmheart.his.Response.*;


/**
 * His系统对接层
 */
public class HisUtil {

    private static final Log log = LogFactory.getLog(HisUtil.class);

    private static String handleResp(String resp){
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" + resp;
    }

    public static TestDb testDb() {
        String requestXml = "<Req>" +
          "<oracode>00002</oracode>" +
          "<oraauthcode>cs20171011</oraauthcode>" +
          "<TransactionCode>JK1001</TransactionCode>" +
          "</Req>";
        String tradeCode = "JK1001";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);

        return (TestDb)XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), TestDb.class);
    }

    /**
     * 查询门诊科室
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
                "<oraauthcode>cs20171011</oraauthcode>" +
                "<TransactionCode> JK2002</TransactionCode>" +
                "<Type>" + type +"</Type>" +
                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
                "<WorkTime>" + workTime + "</WorkTime>" +
                "</Req>";
        String tradeCode = "JK2002";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        return (Departments) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Departments.class);
    }

    /**
     * 查询科室医生
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
                "<oraauthcode>cs20171011</oraauthcode>" +
                "<TransactionCode>JK2003</TransactionCode>" +
                "<Type>" + type + "</Type>" +
                "<DeptCode>" + deptCode +  "</DeptCode>" +
                "<DeptName>" + DeptName + "</DeptName>" +
                "<WorkDateStart>" + workDateStart + "</WorkDateStart>" +
                "<WorkDateEnd>" + workDateEnd + "</WorkDateEnd>" +
                "</Req>";
        String tradeCode = "JK2002";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        return (Doctors) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Doctors.class);
    }

    /**
     * 挂号预约
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
                "<oraauthcode>cs20171011</oraauthcode>" +
                "<TransactionCode> JK2006</TransactionCode>" +
                "<OrderID>"+orderId+"</OrderID>" +
                "<IDCardNo>"+idCardNo+"</IDCardNo>" +
                "<CardNo>"+cardNo+"</CardNo>" +
                "<Mobile>"+mobile+"</Mobile>" +
                "<Name>"+name+"</Name>" +
                "<WorkDate>"+workdate+"</WorkDate>" +
                "<WorkType>"+workType+"</WorkType>" +
                "<DeptCode>"+deptCode+"</DeptCode>" +
                "<DocCode>"+docCode+"生代码</DocCode>" +
                "<STime>"+stime+"</STime>" +
                "<UserId>"+userid+"</UserId>" +
                "<CustomTime>"+customTime+"</CustomTime>" +
                "<SickID>"+sickId+"</SickID>" +
                "</Req>";
        String tradeCode = "JK2002";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        return (Registered)XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), Registered.class);
    }

    /**
     * 取消挂号预约
     */
    public static UnRegistered  unRegistered(String orderId, String seqNumber, String reason, String cardNo, String name, String workdate, String workType, String deptCode,
                                             String docCode, String userid, String customTime, String sickId) {
        String requestXml = "<Req>" +
                "<oracode>00002</oracode>" +
                "<oraauthcode>cs20171011</oraauthcode>" +
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
        String tradeCode = "JK2002";
        Service1 service = new Service1();
        Service1Soap service1Soap =  service.getService1Soap();
        String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
        return (UnRegistered) XmlUtil.xmlToObject(HisUtil.handleResp(retMsg), UnRegistered.class);
    }


}
