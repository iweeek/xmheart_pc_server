package com.xmheart.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xmheart.zy.LisDetail;
import com.xmheart.zy.LisList;
import com.xmheart.zysoft.CallInterfaceFault_Exception;
import com.xmheart.zysoft.WSInterface;
import com.xmheart.zysoft.WSInterfacePortType;


/**
 * Report 系统对接层
 */
public class ReportUtil {
	
	private static boolean isDevelop = false;

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
        		"  <visitType>"  + "</visitType>\n" +  // （ 就诊类型 : 1门急诊2住院 3体检）
        		"  <visitNo>" + commonCode + "</visitNo>\n" +  // 门诊挂号号/住院号(含住院序号)/体检号
//        		"  <patientId>" + patientID + "</patientId>\n" +  // 病人ID
        		"  <patientName>" + patientname + "</patientName>\n" +  // 病人姓名
        		"  <reportOperator>" + operator + "</reportOperator>\n" +  // 报告查询操作人
        		"</root>\n";
        
        String msgBody2 = "<root>\n" + 
        		"  <orgCode>" + organizationCode + "</orgCode>\n" +  // 机构代码
        		"  <visitType>"  + "</visitType>\n" +  // （ 就诊类型 : 1门急诊2住院 3体检）
        		"  <visitNo>" + commonCode + "</visitNo>\n" +  // 门诊挂号号/住院号(含住院序号)/体检号
        		"  <patientId>" + patientID + "</patientId>\n" +  // 病人ID
//        		"  <patientName>" + patientname + "</patientName>\n" +  // 病人姓名
        		"  <reportOperator>" + operator + "</reportOperator>\n" +  // 报告查询操作人
        		"</root>\n";
        String retMsg = "";
        if (isDevelop) {
        	retMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><reports soureCode=\"L01\" soureName=\"检验\"><report reportBillNo=\"L01|baaedfbb-c7c0-4e9a-81d0-76d3048053ac\" reportTitle=\"急诊血清肌钙蛋白T测定\" reportTime=\"2018-03-01 01:43:03\" reportStatus=\"7\" specimenName=\"血清\" bedNo=\"\" specimenCollectTime=\"2018-03-01 01:25:19\" labOperator=\"郭奕昌\" auditOperator=\"吴静宜\" labClass=\"4\"/></reports></root>";
        } else {
	        WSInterface wsInterface = new WSInterface();
	        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
	
			try {
				if (patientname != null) {
					retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
					System.out.println("msgBody: " + msgBody);
				} else {
					retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody2);
					System.out.println("msgBody: " + msgBody2);
				}
				System.out.println("retMsg: " + retMsg);
			} catch (CallInterfaceFault_Exception e) {
				e.printStackTrace();
			}
        }
        
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
        
        String retMsg = "";
        if (isDevelop) {
        	retMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>\n" + 
        			"<DEPT_CODE/>\n" + 
        			"<patientId>0000294098</patientId>\n" + 
        			"<visitNo>642108001</visitNo>\n" + 
        			"<emerFlag/>\n" + 
        			"<visitType>2</visitType>\n" + 
        			"<patientName/>\n" + 
        			"<patientSex/>\n" + 
        			"<patientBirthDay/>\n" + 
        			"<patientAge>1955-10-27</patientAge>\n" + 
        			"<bedNo>34</bedNo>\n" + 
        			"<diagnoseCode/>\n" + 
        			"<diagnoseName/>\n" + 
        			"<medicalHistory/>\n" + 
        			"<applyNos/>\n" + 
        			"<barcodeNos>\n" + 
        			"<barcodeNo/>\n" + 
        			"</barcodeNos>\n" + 
        			"<applyOperator>谢鹏/D514</applyOperator>\n" + 
        			"<applyDeptCode/>\n" + 
        			"<applyDeptName/>\n" + 
        			"<visitDeptCode/>\n" + 
        			"<visitDeptName>40900</visitDeptName>\n" + 
        			"<applyTime>2018-04-02 11:05:16</applyTime>\n" + 
        			"<reportNo>102872018040311</reportNo>\n" + 
        			"<reportTitle>102872018040311</reportTitle>\n" + 
        			"<subjectClass>020101</subjectClass>\n" + 
        			"<labPurpose/>\n" + 
        			"<labMethod/>\n" + 
        			"<specimenCode>3</specimenCode>\n" + 
        			"<specimenName>随机血浆</specimenName>\n" + 
        			"<specimenCollectPart/>\n" + 
        			"<specimenCollectPartDesc/>\n" + 
        			"<specimenRiskFactor/>\n" + 
        			"<specimenRiskFactorDesc/>\n" + 
        			"<specimenQuality>合格</specimenQuality>\n" + 
        			"<specimenQuality_desc/>\n" + 
        			"<labInstruments/>\n" + 
        			"<labInstrumentName>STAGO</labInstrumentName>\n" + 
        			"<specimenCollectTime>2018-04-03 06:07:49</specimenCollectTime>\n" + 
        			"<specimenCollectOperator>蔡丽红</specimenCollectOperator>\n" + 
        			"<specimenAcceptTime>2018-04-03 06:25:41</specimenAcceptTime>\n" + 
        			"<specimenAcceptOperator/>\n" + 
        			"<labTime/>\n" + 
        			"<labDept/>\n" + 
        			"<labOperator>王莹莹</labOperator>\n" + 
        			"<reportTime>王莹莹</reportTime>\n" + 
        			"<reportOperator>陈燕双</reportOperator>\n" + 
        			"<auditTime>2018-04-03 07:58:08</auditTime>\n" + 
        			"<auditOperator>陈燕双</auditOperator>\n" + 
        			"<printTime/>\n" + 
        			"<printOperator/>\n" + 
        			"<reportTemplateCode>020101</reportTemplateCode>\n" + 
        			"<remark1/>\n" + 
        			"<remark2/>\n" + 
//        			"<reportPdfurl>http://192.168.102.197:8080/LIS/20180403/102872018040311/102872018040311_1.jpg</reportPdfurl>\n" + 
        			"<reportPdfurl>http://192.168.102.197:8080/LIS/20180417/10245201804171/10245201804171_2.jpghttp://192.168.102.197:8080/LIS/20180417/10245201804171/10245201804171_3.jpg</reportPdfurl>\n" + 
        			"<reportPdfurl>http://192.168.102.197:8080/LIS/20180412/102492018041210/102492018041210_1.jpg</reportPdfurl>\n" + 
        			"<reportPdfurl>http://192.168.102.197:8080/LIS/20180412/102492018041210/102492018041210_2.jpg</reportPdfurl>\n" + 
        			"<labDetails>\n" + 
        			"<labDetail>\n" + 
        			"<masterItemCode/>\n" + 
        			"<masterItemName/>\n" + 
        			"<itemCode>50568</itemCode>\n" + 
        			"<itemChiName>凝血酶原时间</itemChiName>\n" + 
        			"<itemLoincCode/>\n" + 
        			"<itemLoincName/>\n" + 
        			"<itemResult>16.6</itemResult>\n" + 
        			"<itemResultUnit>s</itemResultUnit>\n" + 
        			"<itemResultFlag>H</itemResultFlag>\n" + 
        			"<referenceDesc>11-14.5</referenceDesc>\n" + 
        			"<referenceHighLimit/>\n" + 
        			"<referenceLowLimit/>\n" + 
        			"<reagentMethod>仪器法</reagentMethod>\n" + 
        			"<sortNo>1</sortNo>\n" + 
        			"<remark>orion插入</remark>\n" + 
        			"<verify>1</verify>\n" + 
        			"<drugAllergys/>\n" + 
        			"</labDetail>\n" + 
        			"<labDetail>\n" + 
        			"<masterItemCode/>\n" + 
        			"<masterItemName/>\n" + 
        			"<itemCode>50569</itemCode>\n" + 
        			"<itemChiName>国际标准化比值</itemChiName>\n" + 
        			"<itemLoincCode/>\n" + 
        			"<itemLoincName/>\n" + 
        			"<itemResult>1.36</itemResult>\n" + 
        			"<itemResultUnit/>\n" + 
        			"<itemResultFlag>H</itemResultFlag>\n" + 
        			"<referenceDesc>0.8-1.2</referenceDesc>\n" + 
        			"<referenceHighLimit/>\n" + 
        			"<referenceLowLimit/>\n" + 
        			"<reagentMethod>计算法</reagentMethod>\n" + 
        			"<sortNo>2</sortNo>\n" + 
        			"<remark>orion插入</remark>\n" + 
        			"<verify>1</verify>\n" + 
        			"<drugAllergys/>\n" + 
        			"</labDetail>\n" + 
        			"<labDetail>\n" + 
        			"<masterItemCode/>\n" + 
        			"<masterItemName/>\n" + 
        			"<itemCode>50835</itemCode>\n" + 
        			"<itemChiName>凝血酶原时间比值</itemChiName>\n" + 
        			"<itemLoincCode/>\n" + 
        			"<itemLoincName/>\n" + 
        			"<itemResult>1.27</itemResult>\n" + 
        			"<itemResultUnit/>\n" + 
        			"<itemResultFlag>H</itemResultFlag>\n" + 
        			"<referenceDesc>0.8-1.2</referenceDesc>\n" + 
        			"<referenceHighLimit/>\n" + 
        			"<referenceLowLimit/>\n" + 
        			"<reagentMethod>计算法</reagentMethod>\n" + 
        			"<sortNo>3</sortNo>\n" + 
        			"<remark>orion插入</remark>\n" + 
        			"<verify>1</verify>\n" + 
        			"<drugAllergys/>\n" + 
        			"</labDetail>\n" + 
        			"</labDetails>\n" + 
        			"</root>";
        } else {
	        WSInterface wsInterface = new WSInterface();
	        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
	
			try {
				retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
				System.out.println("retMsg: " + retMsg);
			} catch (CallInterfaceFault_Exception e) {
				e.printStackTrace();
			}
        }
        
        LisDetail lisDetail = (LisDetail) XmlUtil.xmlToObject(retMsg, LisDetail.class);
        List<String> list = new ArrayList();
        List<String> reportPdfurl = lisDetail.getReportPdfurl();
//        String pdfurl = lisDetail.getReportPdfurl();
        for (String s : reportPdfurl) {
        		String[] https = s.split("http");
            System.out.println(https.length);
            for (int i = 1; i < https.length; i++) {
                https[i] = "http" + https[i];
                list.add(https[i]);
                System.out.println(https[i]);
            }
        }
        
        lisDetail.setReportPdfurls(list);
        return lisDetail;
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
        		"  <visitType>" + 1 + "</visitType>\n" +  // （ 就诊类型 : 1门急诊2住院 3体检）
        		"  <visitNo>" + commonCode + "</visitNo>\n" +  // 门诊挂号号/住院号(含住院序号)/体检号
//        		"  <patientId>" + patientID + "</patientId>\n" +  // 病人ID
        		"  <patientName>" + patientname + "</patientName>\n" +  // 病人姓名
        		"  <reportOperator>" + operator + "</reportOperator>\n" +  // 报告查询操作人
        		"</root>\n";
        
        String msgBody2 = "<root>\n" + 
        		"  <orgCode>" + organizationCode + "</orgCode>\n" +  // 机构代码
        		"  <visitType>" + 1 + "</visitType>\n" +  // （ 就诊类型 : 1门急诊2住院 3体检）
        		"  <visitNo>" + commonCode + "</visitNo>\n" +  // 门诊挂号号/住院号(含住院序号)/体检号
        		"  <patientId>" + patientID + "</patientId>\n" +  // 病人ID
//        		"  <patientName>" + patientname + "</patientName>\n" +  // 病人姓名
        		"  <reportOperator>" + operator + "</reportOperator>\n" +  // 报告查询操作人
        		"</root>\n";
        
        String retMsg = "";
        if (isDevelop) {
        	retMsg = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root>\n" + 
        			"<reports soureCode=\"P01\" soureName=\"检查\">\n" + 
        			"<report reportBillNo=\"P02|1521691246511\" reportTitle=\"心脏彩超组合(常规心脏彩超+左心功能测定+组织多普勒显像 组合)\" reportTime=\"2018-03-22 12:00:43\" reportStatus=\"7\" applyOperator=\"饶健\" auditOperator=\"\" labClass=\"1\"/>\n" + 
        			"</reports>\n" + 
        			"</root>";
        } else {
	        WSInterface wsInterface = new WSInterface();
	        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
	        retMsg = "";
			try {
				if (patientname != null) {
					retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
					System.out.println("msgBody: " + msgBody);
				} else {
					retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody2);
					System.out.println("msgBody: " + msgBody2);
				}
				System.out.println("retMsg: " + retMsg);
			} catch (CallInterfaceFault_Exception e) {
				e.printStackTrace();
			}
        }
        
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
        
        String retMsg = "";
        if (isDevelop) {
        	retMsg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root>\n" + 
        			"<patientId>0000293521</patientId>\n" + 
        			"<visitNo>210146001</visitNo>\n" + 
        			"<visitType>1</visitType>\n" + 
        			"<emergencyFlag/>\n" + 
        			"<abnormalFlag/>\n" + 
        			"<patientName>滑进军</patientName>\n" + 
        			"<patientSex>未知</patientSex>\n" + 
        			"<patientBirthDay/>\n" + 
        			"<patientAge/>\n" + 
        			"<bedNo/>\n" + 
        			"<diagnoseCode/>\n" + 
        			"<diagnoseName/>\n" + 
        			"<medicalHistory/>\n" + 
        			"<applyNos/>\n" + 
        			"<applyOperator>饶健</applyOperator>\n" + 
        			"<applyDeptCode/>\n" + 
        			"<applyDeptName/>\n" + 
        			"<applyTime>2018-03-22 11:22:57</applyTime>\n" + 
        			"<reportNo>US91933</reportNo>\n" + 
        			"<reportTitle>心脏彩超组合(常规心脏彩超+左心功能测定+组织多普勒显像 组合)</reportTitle>\n" + 
        			"<subjectClass>020201</subjectClass>\n" + 
        			"<itemCode>762034</itemCode>\n" + 
        			"<itemName>心脏彩超组合(常规心脏彩超+左心功能测定+组织多普勒显像 组合)</itemName>\n" + 
        			"<examMethod/>\n" + 
        			"<examPart/>\n" + 
        			"<examPartDesc/>\n" + 
        			"<visitStateDesc>1、主动脉右冠瓣脱垂合并中度关闭不全。2、室间隔基底段增厚。3、左室整体收缩功能正常。</visitStateDesc>\n" + 
        			"<examImgDesc>心脏测值：【超声透声条件：乙 级】 （静息状态下经胸探查）RVOT  27mm   AO  37mm    LA  37mm    RV 25mm   AAO 37mm   MPA 22mm RA 29mm    IVS  9.1mm   LVD 54mm    LVS  42mm    LVPWD 9.5mm  EF  58%    FS  31%      Vp-TR 2.5m/s  PPG 25mmHg  PAPs 35mmHg  Vp-AV 1.2m/s  PPG 6mmHg      舒张功能：E/A  0.49/0.93(m/s)＝0.5  室间隔e'' 5.6cm/s   侧壁e'' 8.2cm/s          平均 E/e''=7.1   1、心脏各房室内径正常。房、室间隔回声连续性完整。室间隔与左室后壁逆向运动。室间隔基底段厚12.1mm，余室壁厚度正常，整体运动幅度及收缩期增厚率未见明显异常。舒张期主动脉右冠瓣脱入左室流出道侧，瓣叶开放可，闭合不拢；余各瓣膜回声尚纤细柔软，开放幅度正常。升主动脉及肺动脉内径正常。2、彩色及频谱多普勒显示:舒张期主动脉瓣口可见中量偏心性反流信号；收缩期三尖瓣口可见微少量反流信号；余未见异常血流信号及频谱。</examImgDesc>\n" + 
        			"<examPurpose/>\n" + 
        			"<examDevice/>\n" + 
        			"<examDeviceName/>\n" + 
        			"<registerTime/>\n" + 
        			"<registerOperator/>\n" + 
        			"<examTime>2018-03-22 11:54:55</examTime>\n" + 
        			"<examDept>超声室</examDept>\n" + 
        			"<examOperator/>\n" + 
        			"<reportTime>2018-03-22 12:00:43</reportTime>\n" + 
        			"<reportOperator>陈旭/CX</reportOperator>\n" + 
        			"<auditTime>2018-03-22 12:00:43</auditTime>\n" + 
        			"<auditOperator>陈旭/CX</auditOperator>\n" + 
        			"<printTime/>\n" + 
        			"<printOperator/>\n" + 
        			"<remark/>\n" + 
//        			"<reportPdfurl>http://192.168.102.197:8080/UIS/20180322/20180322120047395_9628931.jpg</reportPdfurl>\n" + 
        			"<reportPdfurl>http://192.168.102.197:8080/LIS/20180417/10245201804171/10245201804171_2.jpghttp://192.168.102.197:8080/LIS/20180417/10245201804171/10245201804171_3.jpg</reportPdfurl>\n" + 
        			"<examClass/>\n" + 
        			"</root>";
        } else {
	        WSInterface wsInterface = new WSInterface();
	        WSInterfacePortType wsInterfaceHttpSoap11Endpoint = wsInterface.getWSInterfaceHttpSoap11Endpoint();
	        retMsg = "";
			try {
				retMsg = wsInterfaceHttpSoap11Endpoint.callInterface(msgHeader, msgBody);
				System.out.println("retMsg: " + retMsg);
			} catch (CallInterfaceFault_Exception e) {
				e.printStackTrace();
			}
        }
        
        LisDetail lisDetail = (LisDetail) XmlUtil.xmlToObject(retMsg, LisDetail.class);
        List<String> list = new ArrayList();
        List<String> reportPdfurl = lisDetail.getReportPdfurl();
//        String pdfurl = lisDetail.getReportPdfurl();
        for (String s : reportPdfurl) {
        		String[] https = s.split("http");
            System.out.println(https.length);
            for (int i = 1; i < https.length; i++) {
                https[i] = "http" + https[i];
                list.add(https[i]);
                System.out.println(https[i]);
            }
        }
        
        lisDetail.setReportPdfurls(list);
        return lisDetail;
    }
}
