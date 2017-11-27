
package com.xmheart.util.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Service1Soap", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Service1Soap {


    /**
     * 获取系统当前时间
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetOracleDateTime", action = "http://tempuri.org/GetOracleDateTime")
    @WebResult(name = "GetOracleDateTimeResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "GetOracleDateTime", targetNamespace = "http://tempuri.org/", className = "com.xmheart.util.soap.GetOracleDateTime")
    @ResponseWrapper(localName = "GetOracleDateTimeResponse", targetNamespace = "http://tempuri.org/", className = "com.xmheart.util.soap.GetOracleDateTimeResponse")
    public String getOracleDateTime();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "OracleConnect", action = "http://tempuri.org/OracleConnect")
    @WebResult(name = "OracleConnectResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "OracleConnect", targetNamespace = "http://tempuri.org/", className = "com.xmheart.util.soap.OracleConnect")
    @ResponseWrapper(localName = "OracleConnectResponse", targetNamespace = "http://tempuri.org/", className = "com.xmheart.util.soap.OracleConnectResponse")
    public String oracleConnect();

    /**
     * 第三方调用HIS接口
     * 
     * @param tradeCode
     * @param requestXml
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Interface_Trade_Jkzl", action = "http://tempuri.org/Interface_Trade_Jkzl")
    @WebResult(name = "Interface_Trade_JkzlResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "Interface_Trade_Jkzl", targetNamespace = "http://tempuri.org/", className = "com.xmheart.util.soap.InterfaceTradeJkzl")
    @ResponseWrapper(localName = "Interface_Trade_JkzlResponse", targetNamespace = "http://tempuri.org/", className = "com.xmheart.util.soap.InterfaceTradeJkzlResponse")
    public String interfaceTradeJkzl(
        @WebParam(name = "tradeCode", targetNamespace = "http://tempuri.org/")
        String tradeCode,
        @WebParam(name = "requestXml", targetNamespace = "http://tempuri.org/")
        String requestXml);

}
