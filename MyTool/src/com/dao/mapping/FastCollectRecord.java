package com.dao.mapping;

import java.math.BigDecimal;
import java.util.Date;

public class FastCollectRecord {
    private String UUID;

    private Date INSERT_TIME;

    private String PROTOCOL;

    private String DEALTYPE;

    private String FILENAME;

    private String FILEPATH;

    private BigDecimal SPENDTIME;

    private BigDecimal QUANTITY;

    private String ERRORINFO;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID == null ? null : UUID.trim();
    }

    public Date getINSERT_TIME() {
        return INSERT_TIME;
    }

    public void setINSERT_TIME(Date INSERT_TIME) {
        this.INSERT_TIME = INSERT_TIME;
    }

    public String getPROTOCOL() {
        return PROTOCOL;
    }

    public void setPROTOCOL(String PROTOCOL) {
        this.PROTOCOL = PROTOCOL == null ? null : PROTOCOL.trim();
    }

    public String getDEALTYPE() {
        return DEALTYPE;
    }

    public void setDEALTYPE(String DEALTYPE) {
        this.DEALTYPE = DEALTYPE == null ? null : DEALTYPE.trim();
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME == null ? null : FILENAME.trim();
    }

    public String getFILEPATH() {
        return FILEPATH;
    }

    public void setFILEPATH(String FILEPATH) {
        this.FILEPATH = FILEPATH == null ? null : FILEPATH.trim();
    }

    public BigDecimal getSPENDTIME() {
        return SPENDTIME;
    }

    public void setSPENDTIME(BigDecimal SPENDTIME) {
        this.SPENDTIME = SPENDTIME;
    }

    public BigDecimal getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(BigDecimal QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getERRORINFO() {
        return ERRORINFO;
    }

    public void setERRORINFO(String ERRORINFO) {
        this.ERRORINFO = ERRORINFO == null ? null : ERRORINFO.trim();
    }
}