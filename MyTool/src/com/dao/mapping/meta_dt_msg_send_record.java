package com.dao.mapping;

import java.util.Date;

public class meta_dt_msg_send_record {
    private String ID;

    private String CALL_RESULT;

    private String ERR_MSG;

    private String MSG_CONTENT;

    private Date SEND_TIME_STAMP;

    private String ESB_MSG;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public String getCALL_RESULT() {
        return CALL_RESULT;
    }

    public void setCALL_RESULT(String CALL_RESULT) {
        this.CALL_RESULT = CALL_RESULT == null ? null : CALL_RESULT.trim();
    }

    public String getERR_MSG() {
        return ERR_MSG;
    }

    public void setERR_MSG(String ERR_MSG) {
        this.ERR_MSG = ERR_MSG == null ? null : ERR_MSG.trim();
    }

    public String getMSG_CONTENT() {
        return MSG_CONTENT;
    }

    public void setMSG_CONTENT(String MSG_CONTENT) {
        this.MSG_CONTENT = MSG_CONTENT == null ? null : MSG_CONTENT.trim();
    }

    public Date getSEND_TIME_STAMP() {
        return SEND_TIME_STAMP;
    }

    public void setSEND_TIME_STAMP(Date SEND_TIME_STAMP) {
        this.SEND_TIME_STAMP = SEND_TIME_STAMP;
    }

    public String getESB_MSG() {
        return ESB_MSG;
    }

    public void setESB_MSG(String ESB_MSG) {
        this.ESB_MSG = ESB_MSG == null ? null : ESB_MSG.trim();
    }
}