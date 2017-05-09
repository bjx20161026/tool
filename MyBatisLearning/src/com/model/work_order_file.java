package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class work_order_file {
    private Date OPREATE_DATE;

    private BigDecimal FLAG;

    private String UUID;

    private String XMLTEXT;

    public Date getOPREATE_DATE() {
        return OPREATE_DATE;
    }

    public void setOPREATE_DATE(Date OPREATE_DATE) {
        this.OPREATE_DATE = OPREATE_DATE;
    }

    public BigDecimal getFLAG() {
        return FLAG;
    }

    public void setFLAG(BigDecimal FLAG) {
        this.FLAG = FLAG;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID == null ? null : UUID.trim();
    }

    public String getXMLTEXT() {
        return XMLTEXT;
    }

    public void setXMLTEXT(String XMLTEXT) {
        this.XMLTEXT = XMLTEXT == null ? null : XMLTEXT.trim();
    }
}