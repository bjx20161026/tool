package com.dao.mapping;

import java.util.Date;

public class EsbCollectMsg {
    private String ID;

    private Date RECEIVE_TIME_STAMP;

    private String MSG_CONTENT;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public Date getRECEIVE_TIME_STAMP() {
        return RECEIVE_TIME_STAMP;
    }

    public void setRECEIVE_TIME_STAMP(Date RECEIVE_TIME_STAMP) {
        this.RECEIVE_TIME_STAMP = RECEIVE_TIME_STAMP;
    }

    public String getMSG_CONTENT() {
        return MSG_CONTENT;
    }

    public void setMSG_CONTENT(String MSG_CONTENT) {
        this.MSG_CONTENT = MSG_CONTENT == null ? null : MSG_CONTENT.trim();
    }
}