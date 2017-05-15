package com.dao.mapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class META_PI_CFG_ESB_SHAREExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public META_PI_CFG_ESB_SHAREExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSERVICE_CODEIsNull() {
            addCriterion("SERVICE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODEIsNotNull() {
            addCriterion("SERVICE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODEEqualTo(String value) {
            addCriterion("SERVICE_CODE =", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODENotEqualTo(String value) {
            addCriterion("SERVICE_CODE <>", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODEGreaterThan(String value) {
            addCriterion("SERVICE_CODE >", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODEGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_CODE >=", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODELessThan(String value) {
            addCriterion("SERVICE_CODE <", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODELessThanOrEqualTo(String value) {
            addCriterion("SERVICE_CODE <=", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODELike(String value) {
            addCriterion("SERVICE_CODE like", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODENotLike(String value) {
            addCriterion("SERVICE_CODE not like", value, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODEIn(List<String> values) {
            addCriterion("SERVICE_CODE in", values, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODENotIn(List<String> values) {
            addCriterion("SERVICE_CODE not in", values, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODEBetween(String value1, String value2) {
            addCriterion("SERVICE_CODE between", value1, value2, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andSERVICE_CODENotBetween(String value1, String value2) {
            addCriterion("SERVICE_CODE not between", value1, value2, "SERVICE_CODE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEIsNull() {
            addCriterion("TIME_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEIsNotNull() {
            addCriterion("TIME_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEEqualTo(BigDecimal value) {
            addCriterion("TIME_TYPE =", value, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPENotEqualTo(BigDecimal value) {
            addCriterion("TIME_TYPE <>", value, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEGreaterThan(BigDecimal value) {
            addCriterion("TIME_TYPE >", value, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_TYPE >=", value, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPELessThan(BigDecimal value) {
            addCriterion("TIME_TYPE <", value, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPELessThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_TYPE <=", value, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEIn(List<BigDecimal> values) {
            addCriterion("TIME_TYPE in", values, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPENotIn(List<BigDecimal> values) {
            addCriterion("TIME_TYPE not in", values, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPEBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_TYPE between", value1, value2, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_TYPENotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_TYPE not between", value1, value2, "TIME_TYPE");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSIsNull() {
            addCriterion("TIME_FILS is null");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSIsNotNull() {
            addCriterion("TIME_FILS is not null");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSEqualTo(BigDecimal value) {
            addCriterion("TIME_FILS =", value, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSNotEqualTo(BigDecimal value) {
            addCriterion("TIME_FILS <>", value, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSGreaterThan(BigDecimal value) {
            addCriterion("TIME_FILS >", value, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_FILS >=", value, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSLessThan(BigDecimal value) {
            addCriterion("TIME_FILS <", value, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TIME_FILS <=", value, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSIn(List<BigDecimal> values) {
            addCriterion("TIME_FILS in", values, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSNotIn(List<BigDecimal> values) {
            addCriterion("TIME_FILS not in", values, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_FILS between", value1, value2, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTIME_FILSNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TIME_FILS not between", value1, value2, "TIME_FILS");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEIsNull() {
            addCriterion("TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEIsNotNull() {
            addCriterion("TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEEqualTo(String value) {
            addCriterion("TABLE_NAME =", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMENotEqualTo(String value) {
            addCriterion("TABLE_NAME <>", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEGreaterThan(String value) {
            addCriterion("TABLE_NAME >", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEGreaterThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME >=", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMELessThan(String value) {
            addCriterion("TABLE_NAME <", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMELessThanOrEqualTo(String value) {
            addCriterion("TABLE_NAME <=", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMELike(String value) {
            addCriterion("TABLE_NAME like", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMENotLike(String value) {
            addCriterion("TABLE_NAME not like", value, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEIn(List<String> values) {
            addCriterion("TABLE_NAME in", values, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMENotIn(List<String> values) {
            addCriterion("TABLE_NAME not in", values, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMEBetween(String value1, String value2) {
            addCriterion("TABLE_NAME between", value1, value2, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andTABLE_NAMENotBetween(String value1, String value2) {
            addCriterion("TABLE_NAME not between", value1, value2, "TABLE_NAME");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEIsNull() {
            addCriterion("IS_COMPLETE is null");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEIsNotNull() {
            addCriterion("IS_COMPLETE is not null");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEEqualTo(Short value) {
            addCriterion("IS_COMPLETE =", value, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETENotEqualTo(Short value) {
            addCriterion("IS_COMPLETE <>", value, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEGreaterThan(Short value) {
            addCriterion("IS_COMPLETE >", value, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_COMPLETE >=", value, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETELessThan(Short value) {
            addCriterion("IS_COMPLETE <", value, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETELessThanOrEqualTo(Short value) {
            addCriterion("IS_COMPLETE <=", value, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEIn(List<Short> values) {
            addCriterion("IS_COMPLETE in", values, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETENotIn(List<Short> values) {
            addCriterion("IS_COMPLETE not in", values, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETEBetween(Short value1, Short value2) {
            addCriterion("IS_COMPLETE between", value1, value2, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_COMPLETENotBetween(Short value1, Short value2) {
            addCriterion("IS_COMPLETE not between", value1, value2, "IS_COMPLETE");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDIsNull() {
            addCriterion("IS_SHARED is null");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDIsNotNull() {
            addCriterion("IS_SHARED is not null");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDEqualTo(Short value) {
            addCriterion("IS_SHARED =", value, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDNotEqualTo(Short value) {
            addCriterion("IS_SHARED <>", value, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDGreaterThan(Short value) {
            addCriterion("IS_SHARED >", value, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_SHARED >=", value, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDLessThan(Short value) {
            addCriterion("IS_SHARED <", value, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDLessThanOrEqualTo(Short value) {
            addCriterion("IS_SHARED <=", value, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDIn(List<Short> values) {
            addCriterion("IS_SHARED in", values, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDNotIn(List<Short> values) {
            addCriterion("IS_SHARED not in", values, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDBetween(Short value1, Short value2) {
            addCriterion("IS_SHARED between", value1, value2, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andIS_SHAREDNotBetween(Short value1, Short value2) {
            addCriterion("IS_SHARED not between", value1, value2, "IS_SHARED");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORIsNull() {
            addCriterion("REC_VENDOR is null");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORIsNotNull() {
            addCriterion("REC_VENDOR is not null");
            return (Criteria) this;
        }

        public Criteria andREC_VENDOREqualTo(String value) {
            addCriterion("REC_VENDOR =", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORNotEqualTo(String value) {
            addCriterion("REC_VENDOR <>", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORGreaterThan(String value) {
            addCriterion("REC_VENDOR >", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORGreaterThanOrEqualTo(String value) {
            addCriterion("REC_VENDOR >=", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORLessThan(String value) {
            addCriterion("REC_VENDOR <", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORLessThanOrEqualTo(String value) {
            addCriterion("REC_VENDOR <=", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORLike(String value) {
            addCriterion("REC_VENDOR like", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORNotLike(String value) {
            addCriterion("REC_VENDOR not like", value, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORIn(List<String> values) {
            addCriterion("REC_VENDOR in", values, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORNotIn(List<String> values) {
            addCriterion("REC_VENDOR not in", values, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORBetween(String value1, String value2) {
            addCriterion("REC_VENDOR between", value1, value2, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andREC_VENDORNotBetween(String value1, String value2) {
            addCriterion("REC_VENDOR not between", value1, value2, "REC_VENDOR");
            return (Criteria) this;
        }

        public Criteria andDESCRIsNull() {
            addCriterion("DESCR is null");
            return (Criteria) this;
        }

        public Criteria andDESCRIsNotNull() {
            addCriterion("DESCR is not null");
            return (Criteria) this;
        }

        public Criteria andDESCREqualTo(String value) {
            addCriterion("DESCR =", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRNotEqualTo(String value) {
            addCriterion("DESCR <>", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRGreaterThan(String value) {
            addCriterion("DESCR >", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRGreaterThanOrEqualTo(String value) {
            addCriterion("DESCR >=", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRLessThan(String value) {
            addCriterion("DESCR <", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRLessThanOrEqualTo(String value) {
            addCriterion("DESCR <=", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRLike(String value) {
            addCriterion("DESCR like", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRNotLike(String value) {
            addCriterion("DESCR not like", value, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRIn(List<String> values) {
            addCriterion("DESCR in", values, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRNotIn(List<String> values) {
            addCriterion("DESCR not in", values, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRBetween(String value1, String value2) {
            addCriterion("DESCR between", value1, value2, "DESCR");
            return (Criteria) this;
        }

        public Criteria andDESCRNotBetween(String value1, String value2) {
            addCriterion("DESCR not between", value1, value2, "DESCR");
            return (Criteria) this;
        }

        public Criteria andFTP_IPIsNull() {
            addCriterion("FTP_IP is null");
            return (Criteria) this;
        }

        public Criteria andFTP_IPIsNotNull() {
            addCriterion("FTP_IP is not null");
            return (Criteria) this;
        }

        public Criteria andFTP_IPEqualTo(String value) {
            addCriterion("FTP_IP =", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPNotEqualTo(String value) {
            addCriterion("FTP_IP <>", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPGreaterThan(String value) {
            addCriterion("FTP_IP >", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPGreaterThanOrEqualTo(String value) {
            addCriterion("FTP_IP >=", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPLessThan(String value) {
            addCriterion("FTP_IP <", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPLessThanOrEqualTo(String value) {
            addCriterion("FTP_IP <=", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPLike(String value) {
            addCriterion("FTP_IP like", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPNotLike(String value) {
            addCriterion("FTP_IP not like", value, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPIn(List<String> values) {
            addCriterion("FTP_IP in", values, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPNotIn(List<String> values) {
            addCriterion("FTP_IP not in", values, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPBetween(String value1, String value2) {
            addCriterion("FTP_IP between", value1, value2, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFTP_IPNotBetween(String value1, String value2) {
            addCriterion("FTP_IP not between", value1, value2, "FTP_IP");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNIsNull() {
            addCriterion("FILE_PATTERN is null");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNIsNotNull() {
            addCriterion("FILE_PATTERN is not null");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNEqualTo(String value) {
            addCriterion("FILE_PATTERN =", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNNotEqualTo(String value) {
            addCriterion("FILE_PATTERN <>", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNGreaterThan(String value) {
            addCriterion("FILE_PATTERN >", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATTERN >=", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNLessThan(String value) {
            addCriterion("FILE_PATTERN <", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATTERN <=", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNLike(String value) {
            addCriterion("FILE_PATTERN like", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNNotLike(String value) {
            addCriterion("FILE_PATTERN not like", value, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNIn(List<String> values) {
            addCriterion("FILE_PATTERN in", values, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNNotIn(List<String> values) {
            addCriterion("FILE_PATTERN not in", values, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNBetween(String value1, String value2) {
            addCriterion("FILE_PATTERN between", value1, value2, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andFILE_PATTERNNotBetween(String value1, String value2) {
            addCriterion("FILE_PATTERN not between", value1, value2, "FILE_PATTERN");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEIsNull() {
            addCriterion("SERVICE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEIsNotNull() {
            addCriterion("SERVICE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEEqualTo(String value) {
            addCriterion("SERVICE_NAME =", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMENotEqualTo(String value) {
            addCriterion("SERVICE_NAME <>", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEGreaterThan(String value) {
            addCriterion("SERVICE_NAME >", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_NAME >=", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMELessThan(String value) {
            addCriterion("SERVICE_NAME <", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMELessThanOrEqualTo(String value) {
            addCriterion("SERVICE_NAME <=", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMELike(String value) {
            addCriterion("SERVICE_NAME like", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMENotLike(String value) {
            addCriterion("SERVICE_NAME not like", value, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEIn(List<String> values) {
            addCriterion("SERVICE_NAME in", values, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMENotIn(List<String> values) {
            addCriterion("SERVICE_NAME not in", values, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMEBetween(String value1, String value2) {
            addCriterion("SERVICE_NAME between", value1, value2, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andSERVICE_NAMENotBetween(String value1, String value2) {
            addCriterion("SERVICE_NAME not between", value1, value2, "SERVICE_NAME");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORIsNull() {
            addCriterion("IS_MONITOR is null");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORIsNotNull() {
            addCriterion("IS_MONITOR is not null");
            return (Criteria) this;
        }

        public Criteria andIS_MONITOREqualTo(Short value) {
            addCriterion("IS_MONITOR =", value, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORNotEqualTo(Short value) {
            addCriterion("IS_MONITOR <>", value, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORGreaterThan(Short value) {
            addCriterion("IS_MONITOR >", value, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_MONITOR >=", value, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORLessThan(Short value) {
            addCriterion("IS_MONITOR <", value, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORLessThanOrEqualTo(Short value) {
            addCriterion("IS_MONITOR <=", value, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORIn(List<Short> values) {
            addCriterion("IS_MONITOR in", values, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORNotIn(List<Short> values) {
            addCriterion("IS_MONITOR not in", values, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORBetween(Short value1, Short value2) {
            addCriterion("IS_MONITOR between", value1, value2, "IS_MONITOR");
            return (Criteria) this;
        }

        public Criteria andIS_MONITORNotBetween(Short value1, Short value2) {
            addCriterion("IS_MONITOR not between", value1, value2, "IS_MONITOR");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}