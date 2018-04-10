package com.xmheart.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xmheart.zysoft.CallInterfaceFault_Exception;
import com.xmheart.zysoft.WSInterface;
import com.xmheart.zysoft.WSInterfacePortType;
import com.xmheart.his.Response.*;
import com.xmheart.zy.LisDetail;
import com.xmheart.zy.LisList;


/**
 * Report 系统对接层
 */
public class ReportUtil {

    private static final Log log = LogFactory.getLog(ReportUtil.class);
//    private static final String AUTHCODE = "cs20171011";
    private static final String CERTIFICATE = "gjHEQzFMJdlAjga6Ts99dg==";
    
    public static String handleResp(String resp){
        return "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>" + resp;
    }

    public static LisList getLisList(String organizationCode, 
    		String visitingType, String commonCode, String patientID, 
    		String operator, String patientname) {
        
    		String serverName = "GetLisReportList";
            
        String msgHeader = "<root>\n" + 
        		"<serverName>" + serverName + "</serverName>\n" + 
        		"<format>xml</format>\n" + 
        		"<callOperator></callOperator>\n" + 
        		"<certificate>" + CERTIFICATE + "</certificate>\n" + 
        		"</root>\n";
        System.out.println("msgHeader: " + msgHeader);
        
        String msgBody = "<root>\n" + 
        		"  <orgCode>" + organizationCode + "</orgCode>\n" +  // 机构代码
        		"  <visitType>" + visitingType + "</visitType>\n" +  // （ 就诊类型 : 1门急诊2住院 3体检）
        		"  <visitNo>" + commonCode + "</visitNo>\n" +  // 门诊挂号号/住院号(含住院序号)/体检号
        		"  <patientId>" + patientID + "</patientId>\n" +  // 病人ID
        		"  <patientname>" + patientname + "</patientname>\n" +  // 病人姓名
        		"  <reportOperator>" + operator + "</reportOperator>\n" +  // 报告查询操作人
        		"</root>\n";
        System.out.println("msgBody: " + msgBody);
        
        WSInterface wsInterface = new WSInterface();
        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
        String retMsg = "";
//        String retMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><reports soureCode=\"L01\" soureName=\"检验\"><report reportBillNo=\"L01|baaedfbb-c7c0-4e9a-81d0-76d3048053ac\" reportTitle=\"急诊血清肌钙蛋白T测定\" reportTime=\"2018-03-01 01:43:03\" reportStatus=\"7\" specimenName=\"血清\" bedNo=\"\" specimenCollectTime=\"2018-03-01 01:25:19\" labOperator=\"郭奕昌\" auditOperator=\"吴静宜\" labClass=\"4\"/></reports></root>";
		try {
			retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
			System.out.println("retMsg: " + retMsg);
		} catch (CallInterfaceFault_Exception e) {
			e.printStackTrace();
		}
        System.out.println("retMsg: " + retMsg);
//        Object object = XmlUtil.xmlToObject(retMsg, TestLIS.class);
        
        return (LisList) XmlUtil.xmlToObject(retMsg, LisList.class);
    }
    
    public static LisDetail getLisDetail(String organizationCode, 
    		String lisBillNo, String operator) {
        
    	String serverName = "GetSickLisReportByXml";
            
        String msgHeader = "<root>\n" + 
        		"<serverName>" + serverName + "</serverName>\n" + 
        		"<format>xml</format>\n" + 
        		"<callOperator></callOperator>\n" + 
        		"<certificate>" + CERTIFICATE + "</certificate>\n" + 
        		"</root>\n";
        System.out.println("msgHeader: " + msgHeader);
        
        String msgBody = "<root>\n" + 
		        "<orgCode>" + organizationCode + "</orgCode>\n" + // 机构代码
		        "<lisBillNo>" + lisBillNo + "</lisBillNo>\n" +  //LIS报告表单号
		        "<reportOperator>" + operator + "</reportOperator>\n" + 
		        "</root>\n";
        System.out.println("msgBody: " + msgBody);
        
//        WSInterface wsInterface = new WSInterface();
//        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
//        String retMsg = "";
        String retMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
        		"<root>\n" + 
        		"	<DEPT_CODE/>\n" + 
        		"	<patientId>0000289784</patientId>\n" + 
        		"	<visitNo>208080001</visitNo>\n" + 
        		"	<emerFlag/>\n" + 
        		"	<visitType>1</visitType>\n" + 
        		"	<patientName/>\n" + 
        		"	<patientSex/>\n" + 
        		"	<patientBirthDay/>\n" + 
        		"	<patientAge>1957-5-14</patientAge>\n" + 
        		"	<bedNo/>\n" + 
        		"	<diagnoseCode/>\n" + 
        		"	<diagnoseName/>\n" + 
        		"	<medicalHistory/>\n" + 
        		"	<applyNos/>\n" + 
        		"	<barcodeNos>\n" + 
        		"		<barcodeNo/>\n" + 
        		"	</barcodeNos>\n" + 
        		"	<applyOperator>曹龙兴/D140</applyOperator>\n" + 
        		"	<applyDeptCode/>\n" + 
        		"	<applyDeptName/>\n" + 
        		"	<visitDeptCode/>\n" + 
        		"	<visitDeptName>41000</visitDeptName>\n" + 
        		"	<applyTime>2018-03-01 00:49:23</applyTime>\n" + 
        		"	<reportNo>10262201803011</reportNo>\n" + 
        		"	<reportTitle>10262201803011</reportTitle>\n" + 
        		"	<subjectClass>020104</subjectClass>\n" + 
        		"	<labPurpose/>\n" + 
        		"	<labMethod/>\n" + 
        		"	<specimenCode>2</specimenCode>\n" + 
        		"	<specimenName>血清</specimenName>\n" + 
        		"	<specimenCollectPart/>\n" + 
        		"	<specimenCollectPartDesc/>\n" + 
        		"	<specimenRiskFactor/>\n" + 
        		"	<specimenRiskFactorDesc/>\n" + 
        		"	<specimenQuality>合格</specimenQuality>\n" + 
        		"	<specimenQuality_desc/>\n" + 
        		"	<labInstruments/>\n" + 
        		"	<labInstrumentName>免疫录</labInstrumentName>\n" + 
        		"	<specimenCollectTime>2018-03-01 01:25:19</specimenCollectTime>\n" + 
        		"	<specimenCollectOperator/>\n" + 
        		"	<specimenAcceptTime>2018-03-01 01:25:32</specimenAcceptTime>\n" + 
        		"	<specimenAcceptOperator/>\n" + 
        		"	<labTime/>\n" + 
        		"	<labDept/>\n" + 
        		"	<labOperator>郭奕昌</labOperator>\n" + 
        		"	<reportTime>郭奕昌</reportTime>\n" + 
        		"	<reportOperator>吴静宜</reportOperator>\n" + 
        		"	<auditTime>2018-03-01 01:43:03</auditTime>\n" + 
        		"	<auditOperator>吴静宜</auditOperator>\n" + 
        		"	<printTime/>\n" + 
        		"	<printOperator/>\n" + 
        		"	<reportTemplateCode>020104</reportTemplateCode>\n" + 
        		"	<remark1/>\n" + 
        		"	<remark2/>\n" + 
        		"	<reportPdfurl>http://192.168.102.197:8080/LIS/20180301/10262201803011/10262201803011_1.jpg</reportPdfurl>\n" + 
        		"	<labDetails>\n" + 
        		"		<labDetail>\n" + 
        		"			<masterItemCode/>\n" + 
        		"			<masterItemName/>\n" + 
        		"			<itemCode>50658</itemCode>\n" + 
        		"			<itemChiName>高敏肌钙蛋白T</itemChiName>\n" + 
        		"			<itemLoincCode/>\n" + 
        		"			<itemLoincName/>\n" + 
        		"			<itemResult>15.60</itemResult>\n" + 
        		"			<itemResultUnit>pg/ml</itemResultUnit>\n" + 
        		"			<itemResultFlag>N</itemResultFlag>\n" + 
        		"			<referenceDesc>0-100</referenceDesc>\n" + 
        		"			<referenceHighLimit/>\n" + 
        		"			<referenceLowLimit/>\n" + 
        		"			<reagentMethod>电化学发光法</reagentMethod>\n" + 
        		"			<sortNo>1</sortNo>\n" + 
        		"			<remark>orion插入</remark>\n" + 
        		"			<verify>1</verify>\n" + 
        		"			<drugAllergys/>\n" + 
        		"		</labDetail>\n" + 
        		"	</labDetails>\n" + 
        		"</root>";
//		try {
//			retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
//			System.out.println("retMsg: " + retMsg);
//		} catch (CallInterfaceFault_Exception e) {
//			e.printStackTrace();
//		}
        System.out.println("retMsg: " + retMsg);
        
        return (LisDetail) XmlUtil.xmlToObject(retMsg, LisDetail.class);
    }
    
    public static LisList GetPacsReportList(String organizationCode, 
    		String visitingType, String commonCode, String patientID,
    		String operator, String patientname) {
        
    		String serverName = "GetPacsReportList";
            
        String msgHeader = "<root>\n" + 
        		"<serverName>" + serverName + "</serverName>\n" + 
        		"<format>xml</format>\n" + 
        		"<callOperator></callOperator>\n" + 
        		"<certificate>" + CERTIFICATE + "</certificate>\n" + 
        		"</root>\n";
        System.out.println("msgHeader: " + msgHeader);
        
        String msgBody = "<root>\n" + 
        		"  <orgCode>" + organizationCode + "</orgCode>\n" +  // 机构代码
        		"  <visitType>" + visitingType + "</visitType>\n" +  // （ 就诊类型 : 1门急诊2住院 3体检）
        		"  <visitNo>" + commonCode + "</visitNo>\n" +  // 门诊挂号号/住院号(含住院序号)/体检号
        		"  <patientId>" + patientID + "</patientId>\n" +  // 病人ID
        		"  <patientname>" + patientname + "</patientname>\n" +  // 病人姓名
        		"  <reportOperator>" + operator + "</reportOperator>\n" +  // 报告查询操作人
        		"</root>\n";
        System.out.println("msgBody: " + msgBody);
        
        WSInterface wsInterface = new WSInterface();
        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
        String retMsg = "";
//        String retMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><reports soureCode=\"L01\" soureName=\"检验\"><report reportBillNo=\"L01|baaedfbb-c7c0-4e9a-81d0-76d3048053ac\" reportTitle=\"急诊血清肌钙蛋白T测定\" reportTime=\"2018-03-01 01:43:03\" reportStatus=\"7\" specimenName=\"血清\" bedNo=\"\" specimenCollectTime=\"2018-03-01 01:25:19\" labOperator=\"郭奕昌\" auditOperator=\"吴静宜\" labClass=\"4\"/></reports></root>";
		try {
			retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
			System.out.println("retMsg: " + retMsg);
		} catch (CallInterfaceFault_Exception e) {
			e.printStackTrace();
		}
        System.out.println("retMsg: " + retMsg);
//        Object object = XmlUtil.xmlToObject(retMsg, TestLIS.class);
        
        return (LisList) XmlUtil.xmlToObject(retMsg, LisList.class);
    }
    
    public static LisDetail getPacsDetail(String organizationCode, 
    		String lisBillNo, String operator) {
        
    	String serverName = "GetSickPacsReportByXml";
            
        String msgHeader = "<root>\n" + 
        		"<serverName>" + serverName + "</serverName>\n" + 
        		"<format>xml</format>\n" + 
        		"<callOperator></callOperator>\n" + 
        		"<certificate>" + CERTIFICATE + "</certificate>\n" + 
        		"</root>\n";
        System.out.println("msgHeader: " + msgHeader);
        
        String msgBody = "<root>\n" + 
		        "<orgCode>" + organizationCode + "</orgCode>\n" + // 机构代码
		        "<pacsBillNo>" + lisBillNo + "</pacsBillNo>\n" +  //LIS报告表单号
		        "<reportOperator>" + operator + "</reportOperator>\n" + 
		        "</root>\n";
        System.out.println("msgBody: " + msgBody);
        
        WSInterface wsInterface = new WSInterface();
        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
//        String retMsg = "";
        String retMsg = "";
		try {
			retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
			System.out.println("retMsg: " + retMsg);
		} catch (CallInterfaceFault_Exception e) {
			e.printStackTrace();
		}
        System.out.println("retMsg: " + retMsg);
        
        return (LisDetail) XmlUtil.xmlToObject(retMsg, LisDetail.class);
    }
}
