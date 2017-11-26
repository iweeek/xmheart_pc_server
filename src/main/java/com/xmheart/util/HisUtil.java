package com.xmheart.util;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;


/**
 * His系统对接层
 */
public class HisUtil {

    private static final Log log = LogFactory.getLog(HisUtil.class);
    private static final String HELLO_SERVICE_ENDPOINT = "http://192.168.102.170:8001/SQWebServer.asmx?wsdl";

    public static String testDb() {
        try {
            String requestXml = "<Req>" +
                    "<oracode>00002</oracode>" +
                    "<oraauthcode>cs20171011</oraauthcode>" +
                    "<TransactionCode>JK1001</TransactionCode>" +
                    "</Req>";
            String tradeCode = "JK1001";

            String url = "http://192.168.102.170:8001/SQWebServer.asmx?wsdl";
            Options options = new Options();
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);
            options.setAction("http://tempuri.org/"+"Interface_Trade_Jkzl");
            ServiceClient sender = new ServiceClient();
            sender.setOptions(options);
            OMFactory fac = OMAbstractFactory.getOMFactory();
            String tns = "http://tempuri.org";
            OMNamespace omNs = fac.createOMNamespace(tns, "");
            OMElement method = fac.createOMElement("Interface_Trade_Jkzl", omNs);
            OMElement symbol = fac.createOMElement("tradeCode", omNs);
            symbol.addChild(fac.createOMText(symbol, tradeCode));
            method.addChild(symbol);

            OMElement symbol1 = fac.createOMElement("requestXml", omNs);
            symbol.addChild(fac.createOMText(symbol1, requestXml));
            method.addChild(symbol1);

            method.build();
            OMElement result = sender.sendReceive(method);
            return result.toString();


//
//
//            RPCServiceClient serviceClient = new RPCServiceClient();
//            EndpointReference targetEPR = new EndpointReference("http://192.168.102.170:8001/SQWebServer.asmx?wsdl");
//
//            Options options = serviceClient.getOptions();
//            options.setTo(targetEPR);
//            options.setAction("http://tempuri.org/Interface_Trade_Jkzl");
//
//                    /*
//                     * 这里的第一个参数namespaceURI，是我们访问Hello的wsdl 地址http://localhost:8080/axis2/services/Hello?wsdl
//                     * ...
//                     * <xs:schema attributeFormDefault="qualified" elementFormDefault="unqualified" targetNamespace="http://ws.apache.org/axis2">
//                     * ...
//                     * 里targetNamespace的值
//                     * */
//            QName opAddEntry = new QName("http://tempuri.org", "Interface_Trade_Jkzl");
//            Object[] opAddEntryArgs = new String[]{tradeCode, requestXml};
//            Class[] classes = new Class[]{String.class};
//
//                    /*
//                     * 如果被调用的WebService方法没有返回值，应使用RPCServiceClient类的invokeRobust方法，该方法只有两个参数，
//                     * 他们的含义与invokeBlocking方法的前两个参数的含义相同。
//                     * */
//            OMElement result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs);
//            return result.toString();



        } catch (AxisFault var6) {
            return var6.getMessage()+"0000";
//            System.out.println(var6.getMessage());
        }

//        return "999";
    }


}
