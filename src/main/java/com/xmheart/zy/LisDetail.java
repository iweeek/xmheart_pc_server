package com.xmheart.zy;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 3.1.1 获取病人LIS报告详情
 * 
<root>
	<reportPdfurl>PDF报告Url地址</reportPdfurl>
    <images>--没有单独图像可不提供
    <image code="图像代码" sub="图像序号" typeCode="图像类型(1普通图像2dicom)" remark="备注">
    </images>
</root>
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class LisDetail {

    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    private List<LisImage> images;

//    @XmlElement(name = "reportPdfurl")
//    private String reportPdfurl;
    @XmlElement(name = "reportPdfurl")
    private List<String> reportPdfurl;
    
    private List<String> reportPdfurls;
    
    @XmlElement(name = "visitNo")
    private String visitNo;
    
    @XmlElement(name = "patientAge")
    private String patientAge;
    
    @XmlElement(name = "bedNo")
    private String bedNo;
    
    @XmlElement(name = "applyOperator")
    private String applyOperator;
    
    
    public  LisDetail(){}
    
	public LisDetail(List<LisImage> images) {
		super();
		this.images = images;
	}

	public List<LisImage> getImages() {
		return images;
	}

	public void setImages(List<LisImage> images) {
		this.images = images;
	}

//	public String getReportPdfurl() {
//		return reportPdfurl;
//	}
//
//	public void setReportPdfurl(String reportPdfurl) {
//		this.reportPdfurl = reportPdfurl;
//	}
	
	

	public String getVisitNo() {
		return visitNo;
	}

	public List<String> getReportPdfurl() {
		return reportPdfurl;
	}

	public void setReportPdfurl(List<String> reportPdfurl) {
		this.reportPdfurl = reportPdfurl;
	}

	public void setVisitNo(String visitNo) {
		this.visitNo = visitNo;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getApplyOperator() {
		return applyOperator;
	}

	public void setApplyOperator(String applyOperator) {
		this.applyOperator = applyOperator;
	}

	public List<String> getReportPdfurls() {
		return reportPdfurls;
	}

	public void setReportPdfurls(List<String> reportPdfurls) {
		this.reportPdfurls = reportPdfurls;
	}
	
	

	
}

