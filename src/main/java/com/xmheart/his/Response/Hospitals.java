package com.xmheart.his.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nimon
 *<Resp>
<TransactionCode>JK1002</ TransactionCode >
<RespCode></RespCode>
<RespMessage></RespMessage>
<Hos>
<HosID></HosID>
< HospitalName ></ HospitalName >
< Site ></ Site >
< Address ></ Address >
< PostCode ></ PostCode >
<SysDateTime><SysDateTime>
</Hos>
</Resp>
 */
@XmlRootElement(name = "Resp")
public class Hospitals {
    public String TransactionCode;
    public String RespCode;
    public String RespMessage;
    private List<Hos> hos;
    
    public Hospitals() {}

    public Hospitals(String transactionCode, String respCode, String respMessage, List<Hos> hos) {
        this.RespCode = respCode;
        this.TransactionCode = transactionCode;
        this.RespMessage = respMessage;
        this.hos = hos;
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
    @XmlElement(name = "hos")
    public List<Hos> getHos() {
        return hos;
    }

    public void setHos(List<Hos> hos) {
        this.hos = hos;
    }
    
}
@XmlRootElement(name = "Hos")
class Hos {
    public String HosID;
    public String HospitalName;
    public String Site;
    public String Address;
    public String PostCode;
    public String SysDateTime;
    public Hos() {}
    public Hos(String hosID, String hospitalName, String site, String address, String postCode, String sysDateTime) {
        super();
        HosID = hosID;
        HospitalName = hospitalName;
        Site = site;
        Address = address;
        PostCode = postCode;
        SysDateTime = sysDateTime;
    }
    @XmlElement(name = "HosID")
    public String getHosID() {
        return HosID;
    }
    public void setHosID(String hosID) {
        HosID = hosID;
    }
    @XmlElement(name = "HospitalName")
    public String getHospitalName() {
        return HospitalName;
    }
    public void setHospitalName(String hospitalName) {
        HospitalName = hospitalName;
    }
    @XmlElement(name = "Site")
    public String getSite() {
        return Site;
    }
    public void setSite(String site) {
        Site = site;
    }
    @XmlElement(name = "Address")
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    @XmlElement(name = "PostCode")
    public String getPostCode() {
        return PostCode;
    }
    public void setPostCode(String postCode) {
        PostCode = postCode;
    }
    @XmlElement(name = "SysDateTime")
    public String getSysDateTime() {
        return SysDateTime;
    }
    public void setSysDateTime(String sysDateTime) {
        SysDateTime = sysDateTime;
    }
    
}