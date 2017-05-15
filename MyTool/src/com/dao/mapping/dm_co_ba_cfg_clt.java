package com.dao.mapping;

public class dm_co_ba_cfg_clt {
    private String ID;

    private String TYPE;

    private String CONFIG;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }

    public String getCONFIG() {
        return CONFIG;
    }

    public void setCONFIG(String CONFIG) {
        this.CONFIG = CONFIG == null ? null : CONFIG.trim();
    }
}