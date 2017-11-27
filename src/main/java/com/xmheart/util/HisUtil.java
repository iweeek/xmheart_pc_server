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

import com.xmheart.util.soap.*;


/**
 * His系统对接层
 */
public class HisUtil {

    private static final Log log = LogFactory.getLog(HisUtil.class);

    public static String testDb() {
    String requestXml = "<Req>" +
      "<oracode>00002</oracode>" +
      "<oraauthcode>cs20171011</oraauthcode>" +
      "<TransactionCode>JK1001</TransactionCode>" +
      "</Req>";
    String tradeCode = "JK1001";
    Service1 service = new Service1();
    Service1Soap service1Soap =  service.getService1Soap();
    String retMsg = service1Soap.interfaceTradeJkzl(tradeCode, requestXml);
    return retMsg;
    }


}
