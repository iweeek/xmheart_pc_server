package com.xmheart.zy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * <root>
  <reports>
    <report reportBillNo="报告单号" reportTitle="报告名称" 
    reportTime="报告时间" reportStatus="报告状态" 
    applyOperator="申请医生"  auditOperator="审核医生"/>
  </reports>
</root>
 */
@XmlRootElement(name = "report")
@XmlAccessorType(XmlAccessType.FIELD)
public class Report {

	@XmlAttribute
    private String reportBillNo;

	@XmlAttribute
    private String reportTitle;
	
	@XmlAttribute
    private String reportTime;
	
	@XmlAttribute
    private String reportStatus;
	
	@XmlAttribute
    private String applyOperator;
	
	@XmlAttribute
    private String auditOperator;
	
	@XmlAttribute
	private String labOperator;
	
    public  Report(){}

    public Report(String reportBillNo, String reportTitle, String reportTime, String reportStatus, String applyOperator,
			String auditOperator) {
		super();
		this.reportBillNo = reportBillNo;
		this.reportTitle = reportTitle;
		this.reportTime = reportTime;
		this.reportStatus = reportStatus;
		this.applyOperator = applyOperator;
		this.auditOperator = auditOperator;
	}


//    @XmlElement(name = "reportBillNo")
	public String getReportBillNo() {
		return reportBillNo;
	}

	public void setReportBillNo(String reportBillNo) {
		this.reportBillNo = reportBillNo;
	}

//	@XmlElement(name = "reportTitle")
	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

//	@XmlElement(name = "reportTime")
	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

//	@XmlElement(name = "reportStatus")
	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

//	@XmlElement(name = "applyOperator")
	public String getApplyOperator() {
		return applyOperator;
	}

	public void setApplyOperator(String applyOperator) {
		this.applyOperator = applyOperator;
	}

//	@XmlElement(name = "auditOperator")
	public String getAuditOperator() {
		return auditOperator;
	}

	public void setAuditOperator(String auditOperator) {
		this.auditOperator = auditOperator;
	}

	public String getLabOperator() {
		return labOperator;
	}

	public void setLabOperator(String labOperator) {
		this.labOperator = labOperator;
	}

	@Override
	public String toString() {
		return "Report [reportBillNo=" + reportBillNo + ", reportTitle=" + reportTitle + ", reportTime=" + reportTime
				+ ", reportStatus=" + reportStatus + ", applyOperator=" + applyOperator + ", auditOperator="
				+ auditOperator + ", labOperator=" + labOperator + "]";
	}

}
