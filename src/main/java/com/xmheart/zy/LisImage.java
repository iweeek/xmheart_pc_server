package com.xmheart.zy;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
<root>
    <images>--没有单独图像可不提供
    <image code="图像代码" sub="图像序号" typeCode="图像类型(1普通图像2dicom)" remark="备注">
    </images>
</root>
 */
@XmlRootElement(name = "image")
@XmlAccessorType(XmlAccessType.FIELD)
public class LisImage {

	@XmlAttribute
    private String code;

	@XmlAttribute
    private String sub;
	
	@XmlAttribute
    private String typeCode;
	
	@XmlAttribute
    private String remark;
	
	@XmlAttribute
	private String url;
	
    public  LisImage(){}

	public LisImage(String code, String sub, String typeCode, String remark, String url) {
		super();
		this.code = code;
		this.sub = sub;
		this.typeCode = typeCode;
		this.remark = remark;
		this.url = url;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
