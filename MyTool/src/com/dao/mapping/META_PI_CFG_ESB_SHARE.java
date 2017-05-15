package com.dao.mapping;

import java.math.BigDecimal;

public class META_PI_CFG_ESB_SHARE {
    private String SERVICE_CODE;

    private BigDecimal TIME_TYPE;

    private BigDecimal TIME_FILS;

    private String TABLE_NAME;

    private Short IS_COMPLETE;

    private Short IS_SHARED;

    private String REC_VENDOR;

    private String DESCR;

    private String FTP_IP;

    private String FILE_PATTERN;

    private String SERVICE_NAME;

    private Short IS_MONITOR;

    public String getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    public void setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE == null ? null : SERVICE_CODE.trim();
    }

    public BigDecimal getTIME_TYPE() {
        return TIME_TYPE;
    }

    public void setTIME_TYPE(BigDecimal TIME_TYPE) {
        this.TIME_TYPE = TIME_TYPE;
    }

    public BigDecimal getTIME_FILS() {
        return TIME_FILS;
    }

    public void setTIME_FILS(BigDecimal TIME_FILS) {
        this.TIME_FILS = TIME_FILS;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME == null ? null : TABLE_NAME.trim();
    }

    public Short getIS_COMPLETE() {
        return IS_COMPLETE;
    }

    public void setIS_COMPLETE(Short IS_COMPLETE) {
        this.IS_COMPLETE = IS_COMPLETE;
    }

    public Short getIS_SHARED() {
        return IS_SHARED;
    }

    public void setIS_SHARED(Short IS_SHARED) {
        this.IS_SHARED = IS_SHARED;
    }

    public String getREC_VENDOR() {
        return REC_VENDOR;
    }

    public void setREC_VENDOR(String REC_VENDOR) {
        this.REC_VENDOR = REC_VENDOR == null ? null : REC_VENDOR.trim();
    }

    public String getDESCR() {
        return DESCR;
    }

    public void setDESCR(String DESCR) {
        this.DESCR = DESCR == null ? null : DESCR.trim();
    }

    public String getFTP_IP() {
        return FTP_IP;
    }

    public void setFTP_IP(String FTP_IP) {
        this.FTP_IP = FTP_IP == null ? null : FTP_IP.trim();
    }

    public String getFILE_PATTERN() {
        return FILE_PATTERN;
    }

    public void setFILE_PATTERN(String FILE_PATTERN) {
        this.FILE_PATTERN = FILE_PATTERN == null ? null : FILE_PATTERN.trim();
    }

    public String getSERVICE_NAME() {
        return SERVICE_NAME;
    }

    public void setSERVICE_NAME(String SERVICE_NAME) {
        this.SERVICE_NAME = SERVICE_NAME == null ? null : SERVICE_NAME.trim();
    }

    public Short getIS_MONITOR() {
        return IS_MONITOR;
    }

    public void setIS_MONITOR(Short IS_MONITOR) {
        this.IS_MONITOR = IS_MONITOR;
    }
}