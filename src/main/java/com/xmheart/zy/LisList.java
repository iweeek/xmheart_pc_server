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
 * 3.1.1 获取病人LIS报告列表 
 * 
<root>
  <reports>
    <report reportBillNo="报告单号" reportTitle="报告名称" 
    reportTime="报告时间" reportStatus="报告状态" 
    applyOperator="申请医生"  auditOperator="审核医生"/>
  </reports>
</root>
 */
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class LisList {

    @XmlElementWrapper(name = "reports")
    @XmlElement(name = "report")
    private List<Report> reports;

    public  LisList(){}

	public LisList(List<Report> reports) {
		super();
		this.reports = reports;
	}
	
	// TODO @XmlElement(name = "reports")
	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		return "LisList [reports=" + reports + "]";
	}

}

