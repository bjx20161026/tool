package com.dao.mapping;

import java.util.Date;

public class dm_co_ba_cfg_task_mng {
    private String ID;

    private String TIMETYPE;

    private String TIMEINVOKEPOINT;

    private String TIMEPOINT;

    private Short ENABLED;

    private Short PRIORITY;

    private String SUBID;

    private String REMARK;

    private Date LAST_EXE_TIME;

    private String SERVER_IP;

    private String RESULT;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public String getTIMETYPE() {
        return TIMETYPE;
    }

    public void setTIMETYPE(String TIMETYPE) {
        this.TIMETYPE = TIMETYPE == null ? null : TIMETYPE.trim();
    }

    public String getTIMEINVOKEPOINT() {
        return TIMEINVOKEPOINT;
    }

    public void setTIMEINVOKEPOINT(String TIMEINVOKEPOINT) {
        this.TIMEINVOKEPOINT = TIMEINVOKEPOINT == null ? null : TIMEINVOKEPOINT.trim();
    }

    public String getTIMEPOINT() {
        return TIMEPOINT;
    }

    public void setTIMEPOINT(String TIMEPOINT) {
        this.TIMEPOINT = TIMEPOINT == null ? null : TIMEPOINT.trim();
    }

    public Short getENABLED() {
        return ENABLED;
    }

    public void setENABLED(Short ENABLED) {
        this.ENABLED = ENABLED;
    }

    public Short getPRIORITY() {
        return PRIORITY;
    }

    public void setPRIORITY(Short PRIORITY) {
        this.PRIORITY = PRIORITY;
    }

    public String getSUBID() {
        return SUBID;
    }

    public void setSUBID(String SUBID) {
        this.SUBID = SUBID == null ? null : SUBID.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public Date getLAST_EXE_TIME() {
        return LAST_EXE_TIME;
    }

    public void setLAST_EXE_TIME(Date LAST_EXE_TIME) {
        this.LAST_EXE_TIME = LAST_EXE_TIME;
    }

    public String getSERVER_IP() {
        return SERVER_IP;
    }

    public void setSERVER_IP(String SERVER_IP) {
        this.SERVER_IP = SERVER_IP == null ? null : SERVER_IP.trim();
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT == null ? null : RESULT.trim();
    }
}