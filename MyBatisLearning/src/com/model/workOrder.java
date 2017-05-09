package com.model;

import java.util.Date;


public class workOrder {
	private String WORKJOB_ID;
	private String TITLE;
	private String WORKER;
	private String DEPARTMENT;
	private Date SEND_TIME;
	private Date HANDLE_TIME;
	private String HOTSPOTNAME;
	private Date SHIELD_START;
	private Date SHIELD_END;
	private String LOCATION;
	private String AREA;
	private String FTP;
	private String STATEMENT;
	private Short ISSUCCED;
	private String WORKJOB_TYPE;
	private String NASID;
	private Date FINISHTIME;
	private Date RECEIPT;
	private String INCLUDE;
	private Date OPERATETIME;
	private String LOCALFILE;
	private String FAILED_REASON;
	private String ORDER_USER;
	private String XMLTEXT;

	public String getWORKJOB_ID() {
		return WORKJOB_ID;
	}
	public void setWORKJOB_ID(String WORKJOB_ID) {
		this.WORKJOB_ID = WORKJOB_ID == null ? null : WORKJOB_ID.trim();
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String TITLE) {
		this.TITLE = TITLE == null ? null : TITLE.trim();
	}
	public String getWORKER() {
		return WORKER;
	}
	public void setWORKER(String WORKER) {
		this.WORKER = WORKER == null ? null : WORKER.trim();
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String DEPARTMENT) {
		this.DEPARTMENT = DEPARTMENT == null ? null : DEPARTMENT.trim();
	}
	public Date getSEND_TIME() {
		return SEND_TIME;
	}
	public void setSEND_TIME(Date SEND_TIME) {
		this.SEND_TIME = SEND_TIME;
	}
	public Date getHANDLE_TIME() {
		return HANDLE_TIME;
	}
	public void setHANDLE_TIME(Date HANDLE_TIME) {
		this.HANDLE_TIME = HANDLE_TIME;
	}
	public String getHOTSPOTNAME() {
		return HOTSPOTNAME;
	}
	public void setHOTSPOTNAME(String HOTSPOTNAME) {
		this.HOTSPOTNAME = HOTSPOTNAME == null ? null : HOTSPOTNAME.trim();
	}
	public Date getSHIELD_START() {
		return SHIELD_START;
	}
	public void setSHIELD_START(Date SHIELD_START) {
		this.SHIELD_START = SHIELD_START;
	}
	public Date getSHIELD_END() {
		return SHIELD_END;
	}
	public void setSHIELD_END(Date SHIELD_END) {
		this.SHIELD_END = SHIELD_END;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String LOCATION) {
		this.LOCATION = LOCATION == null ? null : LOCATION.trim();
	}
	public String getAREA() {
		return AREA;
	}
	public void setAREA(String AREA) {
		this.AREA = AREA == null ? null : AREA.trim();
	}
	public String getFTP() {
		return FTP;
	}
	public void setFTP(String FTP) {
		this.FTP = FTP == null ? null : FTP.trim();
	}
	public String getSTATEMENT() {
		return STATEMENT;
	}
	public void setSTATEMENT(String STATEMENT) {
		this.STATEMENT = STATEMENT == null ? null : STATEMENT.trim();
	}
	public Short getISSUCCED() {
		return ISSUCCED;
	}
	public void setISSUCCED(Short ISSUCCED) {
		this.ISSUCCED = ISSUCCED;
	}
	public String getWORKJOB_TYPE() {
		return WORKJOB_TYPE;
	}
	public void setWORKJOB_TYPE(String WORKJOB_TYPE) {
		this.WORKJOB_TYPE = WORKJOB_TYPE == null ? null : WORKJOB_TYPE.trim();
	}
	public String getNASID() {
		return NASID;
	}
	public void setNASID(String NASID) {
		this.NASID = NASID == null ? null : NASID.trim();
	}
	public Date getFINISHTIME() {
		return FINISHTIME;
	}
	public void setFINISHTIME(Date FINISHTIME) {
		this.FINISHTIME = FINISHTIME;
	}
	public Date getRECEIPT() {
		return RECEIPT;
	}
	public void setRECEIPT(Date RECEIPT) {
		this.RECEIPT = RECEIPT;
	}
	public String getINCLUDE() {
		return INCLUDE;
	}
	public void setINCLUDE(String INCLUDE) {
		this.INCLUDE = INCLUDE == null ? null : INCLUDE.trim();
	}
	public Date getOPERATETIME() {
		return OPERATETIME;
	}
	public void setOPERATETIME(Date OPERATETIME) {
		this.OPERATETIME = OPERATETIME;
	}
	public String getLOCALFILE() {
		return LOCALFILE;
	}
	public void setLOCALFILE(String LOCALFILE) {
		this.LOCALFILE = LOCALFILE == null ? null : LOCALFILE.trim();
	}
	public String getFAILED_REASON() {
		return FAILED_REASON;
	}
	public void setFAILED_REASON(String FAILED_REASON) {
		this.FAILED_REASON = FAILED_REASON == null ? null : FAILED_REASON.trim();
	}
	public String getORDER_USER() {
		return ORDER_USER;
	}
	public void setORDER_USER(String ORDER_USER) {
		this.ORDER_USER = ORDER_USER == null ? null : ORDER_USER.trim();
	}
	public String getXMLTEXT() {
		return XMLTEXT;
	}
	public void setXMLTEXT(String XMLTEXT) {
		this.XMLTEXT = XMLTEXT == null ? null : XMLTEXT.trim();
	}
	private	String	workjob_id;
	private	String	title;
	private	String	worker;
	private	String	department;
	private	Date	send_time;
	private	Date	handle_time;
	private	String	hotspotname;
	private	Date	shield_start;
	private	Date	shield_end;
	private	String	location;
	private	String	area;
	private	String	ftp;
	private	String	statement;
	private	int	issucced;
	private	String	workjob_type;
	private	String	nasid;
	private String  localfile;
	private Date finishtime;
	private Date operatetime;
	private String failed_reason;
	private String order_user;
	
	public String getOrder_user() {
		return order_user;
	}
	public void setOrder_user(String order_user) {
		this.order_user = order_user;
	}
	public Date getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(Date finishtime) {
		this.finishtime = finishtime;
	}
	public Date getOperatetime() {
		return operatetime;
	}
	public void setOperatetime(Date operatetime) {
		this.operatetime = operatetime;
	}
	public String getFailed_reason() {
		return failed_reason;
	}
	public void setFailed_reason(String failed_reason) {
		this.failed_reason = failed_reason;
	}

	public String getLocalfile() {
		return localfile;
	}
	public void setLocalfile(String localfile) {
		this.localfile = localfile;
	}
	public String getWorkjob_id() {
		return workjob_id;
	}
	public void setWorkjob_id(String workjob_id) {
		this.workjob_id = workjob_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorker() {
		return worker;
	}
	public void setWorker(String worker) {
		this.worker = worker;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	
	public Date getHandle_time() {
		return handle_time;
	}
	public void setHandle_time(Date handle_time) {
		this.handle_time = handle_time;
	}
	public String getHotspotname() {
		return hotspotname;
	}
	public void setHotspotname(String hotspotname) {
		this.hotspotname = hotspotname;
	}
	
	public Date getShield_start() {
		return shield_start;
	}
	public void setShield_start(Date shield_start) {
		this.shield_start = shield_start;
	}
	
	public Date getShield_end() {
		return shield_end;
	}
	public void setShield_end(Date shield_end) {
		this.shield_end = shield_end;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFtp() {
		return ftp;
	}
	public void setFtp(String ftp) {
		this.ftp = ftp;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public int getIssucced() {
		return issucced;
	}
	public void setIssucced(int issucced) {
		this.issucced = issucced;
	}
	public String getWorkjob_type() {
		return workjob_type;
	}
	public void setWorkjob_type(String workjob_type) {
		this.workjob_type = workjob_type;
	}
	public String getNasid() {
		return nasid;
	}
	public void setNasid(String nasid) {
		this.nasid = nasid;
	}
	@Override
	public String toString(){
		return "workjob_id: "+workjob_id+"title: "+title+"worker: "+worker+"department: "+department+"send_time: "+send_time+"handle_time: "+handle_time+"hotspotname: "+hotspotname+"shield_start: "+shield_start+"shield_end: "+shield_end+"location: "+location+"area: "+area+"ftp: "+ftp+"statement: "+statement+"issucced: "+issucced+"workjob_type: "+workjob_type+"nasid: "+nasid+"localfile: "+localfile+"finishtime: "+finishtime+"operatetime: "+operatetime+"failed_reason: "+failed_reason+"order_user: "+order_user;
	}
}
