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

    @XmlElement(name = "reportPdfurl")
    private String reportPdfurl;
    
    
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

	public String getReportPdfurl() {
		return reportPdfurl;
	}

	public void setReportPdfurl(String reportPdfurl) {
		this.reportPdfurl = reportPdfurl;
	}
}

