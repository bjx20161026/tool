package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class workOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public workOrderExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andWORKJOB_IDIsNull() {
            addCriterion("WORKJOB_ID is null");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDIsNotNull() {
            addCriterion("WORKJOB_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDEqualTo(String value) {
            addCriterion("WORKJOB_ID =", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDNotEqualTo(String value) {
            addCriterion("WORKJOB_ID <>", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDGreaterThan(String value) {
            addCriterion("WORKJOB_ID >", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDGreaterThanOrEqualTo(String value) {
            addCriterion("WORKJOB_ID >=", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDLessThan(String value) {
            addCriterion("WORKJOB_ID <", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDLessThanOrEqualTo(String value) {
            addCriterion("WORKJOB_ID <=", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDLike(String value) {
            addCriterion("WORKJOB_ID like", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDNotLike(String value) {
            addCriterion("WORKJOB_ID not like", value, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDIn(List<String> values) {
            addCriterion("WORKJOB_ID in", values, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDNotIn(List<String> values) {
            addCriterion("WORKJOB_ID not in", values, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDBetween(String value1, String value2) {
            addCriterion("WORKJOB_ID between", value1, value2, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_IDNotBetween(String value1, String value2) {
            addCriterion("WORKJOB_ID not between", value1, value2, "WORKJOB_ID");
            return (Criteria) this;
        }

        public Criteria andTITLEIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTITLEIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTITLEEqualTo(String value) {
            addCriterion("TITLE =", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLENotEqualTo(String value) {
            addCriterion("TITLE <>", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLEGreaterThan(String value) {
            addCriterion("TITLE >", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLEGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLELessThan(String value) {
            addCriterion("TITLE <", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLELessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLELike(String value) {
            addCriterion("TITLE like", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLENotLike(String value) {
            addCriterion("TITLE not like", value, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLEIn(List<String> values) {
            addCriterion("TITLE in", values, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLENotIn(List<String> values) {
            addCriterion("TITLE not in", values, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLEBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "TITLE");
            return (Criteria) this;
        }

        public Criteria andTITLENotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "TITLE");
            return (Criteria) this;
        }

        public Criteria andWORKERIsNull() {
            addCriterion("WORKER is null");
            return (Criteria) this;
        }

        public Criteria andWORKERIsNotNull() {
            addCriterion("WORKER is not null");
            return (Criteria) this;
        }

        public Criteria andWORKEREqualTo(String value) {
            addCriterion("WORKER =", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERNotEqualTo(String value) {
            addCriterion("WORKER <>", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERGreaterThan(String value) {
            addCriterion("WORKER >", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERGreaterThanOrEqualTo(String value) {
            addCriterion("WORKER >=", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERLessThan(String value) {
            addCriterion("WORKER <", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERLessThanOrEqualTo(String value) {
            addCriterion("WORKER <=", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERLike(String value) {
            addCriterion("WORKER like", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERNotLike(String value) {
            addCriterion("WORKER not like", value, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERIn(List<String> values) {
            addCriterion("WORKER in", values, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERNotIn(List<String> values) {
            addCriterion("WORKER not in", values, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERBetween(String value1, String value2) {
            addCriterion("WORKER between", value1, value2, "WORKER");
            return (Criteria) this;
        }

        public Criteria andWORKERNotBetween(String value1, String value2) {
            addCriterion("WORKER not between", value1, value2, "WORKER");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTIsNull() {
            addCriterion("DEPARTMENT is null");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTIsNotNull() {
            addCriterion("DEPARTMENT is not null");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTEqualTo(String value) {
            addCriterion("DEPARTMENT =", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTNotEqualTo(String value) {
            addCriterion("DEPARTMENT <>", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTGreaterThan(String value) {
            addCriterion("DEPARTMENT >", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT >=", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTLessThan(String value) {
            addCriterion("DEPARTMENT <", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENT <=", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTLike(String value) {
            addCriterion("DEPARTMENT like", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTNotLike(String value) {
            addCriterion("DEPARTMENT not like", value, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTIn(List<String> values) {
            addCriterion("DEPARTMENT in", values, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTNotIn(List<String> values) {
            addCriterion("DEPARTMENT not in", values, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTBetween(String value1, String value2) {
            addCriterion("DEPARTMENT between", value1, value2, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andDEPARTMENTNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENT not between", value1, value2, "DEPARTMENT");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_TIME =", value, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMENotEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_TIME <>", value, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEGreaterThan(Date value) {
            addCriterionForJDBCDate("SEND_TIME >", value, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_TIME >=", value, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMELessThan(Date value) {
            addCriterionForJDBCDate("SEND_TIME <", value, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SEND_TIME <=", value, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEIn(List<Date> values) {
            addCriterionForJDBCDate("SEND_TIME in", values, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMENotIn(List<Date> values) {
            addCriterionForJDBCDate("SEND_TIME not in", values, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SEND_TIME between", value1, value2, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andSEND_TIMENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SEND_TIME not between", value1, value2, "SEND_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEIsNull() {
            addCriterion("HANDLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEIsNotNull() {
            addCriterion("HANDLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEEqualTo(Date value) {
            addCriterionForJDBCDate("HANDLE_TIME =", value, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMENotEqualTo(Date value) {
            addCriterionForJDBCDate("HANDLE_TIME <>", value, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEGreaterThan(Date value) {
            addCriterionForJDBCDate("HANDLE_TIME >", value, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HANDLE_TIME >=", value, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMELessThan(Date value) {
            addCriterionForJDBCDate("HANDLE_TIME <", value, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HANDLE_TIME <=", value, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEIn(List<Date> values) {
            addCriterionForJDBCDate("HANDLE_TIME in", values, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMENotIn(List<Date> values) {
            addCriterionForJDBCDate("HANDLE_TIME not in", values, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HANDLE_TIME between", value1, value2, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHANDLE_TIMENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HANDLE_TIME not between", value1, value2, "HANDLE_TIME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEIsNull() {
            addCriterion("HOTSPOTNAME is null");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEIsNotNull() {
            addCriterion("HOTSPOTNAME is not null");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEEqualTo(String value) {
            addCriterion("HOTSPOTNAME =", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMENotEqualTo(String value) {
            addCriterion("HOTSPOTNAME <>", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEGreaterThan(String value) {
            addCriterion("HOTSPOTNAME >", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEGreaterThanOrEqualTo(String value) {
            addCriterion("HOTSPOTNAME >=", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMELessThan(String value) {
            addCriterion("HOTSPOTNAME <", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMELessThanOrEqualTo(String value) {
            addCriterion("HOTSPOTNAME <=", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMELike(String value) {
            addCriterion("HOTSPOTNAME like", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMENotLike(String value) {
            addCriterion("HOTSPOTNAME not like", value, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEIn(List<String> values) {
            addCriterion("HOTSPOTNAME in", values, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMENotIn(List<String> values) {
            addCriterion("HOTSPOTNAME not in", values, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMEBetween(String value1, String value2) {
            addCriterion("HOTSPOTNAME between", value1, value2, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andHOTSPOTNAMENotBetween(String value1, String value2) {
            addCriterion("HOTSPOTNAME not between", value1, value2, "HOTSPOTNAME");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTIsNull() {
            addCriterion("SHIELD_START is null");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTIsNotNull() {
            addCriterion("SHIELD_START is not null");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_START =", value, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTNotEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_START <>", value, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTGreaterThan(Date value) {
            addCriterionForJDBCDate("SHIELD_START >", value, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_START >=", value, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTLessThan(Date value) {
            addCriterionForJDBCDate("SHIELD_START <", value, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_START <=", value, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTIn(List<Date> values) {
            addCriterionForJDBCDate("SHIELD_START in", values, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTNotIn(List<Date> values) {
            addCriterionForJDBCDate("SHIELD_START not in", values, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SHIELD_START between", value1, value2, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_STARTNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SHIELD_START not between", value1, value2, "SHIELD_START");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDIsNull() {
            addCriterion("SHIELD_END is null");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDIsNotNull() {
            addCriterion("SHIELD_END is not null");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_END =", value, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDNotEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_END <>", value, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDGreaterThan(Date value) {
            addCriterionForJDBCDate("SHIELD_END >", value, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_END >=", value, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDLessThan(Date value) {
            addCriterionForJDBCDate("SHIELD_END <", value, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SHIELD_END <=", value, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDIn(List<Date> values) {
            addCriterionForJDBCDate("SHIELD_END in", values, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDNotIn(List<Date> values) {
            addCriterionForJDBCDate("SHIELD_END not in", values, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SHIELD_END between", value1, value2, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andSHIELD_ENDNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SHIELD_END not between", value1, value2, "SHIELD_END");
            return (Criteria) this;
        }

        public Criteria andLOCATIONIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLOCATIONIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLOCATIONEqualTo(String value) {
            addCriterion("LOCATION =", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONGreaterThan(String value) {
            addCriterion("LOCATION >", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONLessThan(String value) {
            addCriterion("LOCATION <", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONLike(String value) {
            addCriterion("LOCATION like", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONNotLike(String value) {
            addCriterion("LOCATION not like", value, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONIn(List<String> values) {
            addCriterion("LOCATION in", values, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONNotIn(List<String> values) {
            addCriterion("LOCATION not in", values, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andLOCATIONNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "LOCATION");
            return (Criteria) this;
        }

        public Criteria andAREAIsNull() {
            addCriterion("AREA is null");
            return (Criteria) this;
        }

        public Criteria andAREAIsNotNull() {
            addCriterion("AREA is not null");
            return (Criteria) this;
        }

        public Criteria andAREAEqualTo(String value) {
            addCriterion("AREA =", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREANotEqualTo(String value) {
            addCriterion("AREA <>", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREAGreaterThan(String value) {
            addCriterion("AREA >", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREAGreaterThanOrEqualTo(String value) {
            addCriterion("AREA >=", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREALessThan(String value) {
            addCriterion("AREA <", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREALessThanOrEqualTo(String value) {
            addCriterion("AREA <=", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREALike(String value) {
            addCriterion("AREA like", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREANotLike(String value) {
            addCriterion("AREA not like", value, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREAIn(List<String> values) {
            addCriterion("AREA in", values, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREANotIn(List<String> values) {
            addCriterion("AREA not in", values, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREABetween(String value1, String value2) {
            addCriterion("AREA between", value1, value2, "AREA");
            return (Criteria) this;
        }

        public Criteria andAREANotBetween(String value1, String value2) {
            addCriterion("AREA not between", value1, value2, "AREA");
            return (Criteria) this;
        }

        public Criteria andFTPIsNull() {
            addCriterion("FTP is null");
            return (Criteria) this;
        }

        public Criteria andFTPIsNotNull() {
            addCriterion("FTP is not null");
            return (Criteria) this;
        }

        public Criteria andFTPEqualTo(String value) {
            addCriterion("FTP =", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPNotEqualTo(String value) {
            addCriterion("FTP <>", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPGreaterThan(String value) {
            addCriterion("FTP >", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPGreaterThanOrEqualTo(String value) {
            addCriterion("FTP >=", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPLessThan(String value) {
            addCriterion("FTP <", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPLessThanOrEqualTo(String value) {
            addCriterion("FTP <=", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPLike(String value) {
            addCriterion("FTP like", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPNotLike(String value) {
            addCriterion("FTP not like", value, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPIn(List<String> values) {
            addCriterion("FTP in", values, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPNotIn(List<String> values) {
            addCriterion("FTP not in", values, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPBetween(String value1, String value2) {
            addCriterion("FTP between", value1, value2, "FTP");
            return (Criteria) this;
        }

        public Criteria andFTPNotBetween(String value1, String value2) {
            addCriterion("FTP not between", value1, value2, "FTP");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTIsNull() {
            addCriterion("STATEMENT is null");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTIsNotNull() {
            addCriterion("STATEMENT is not null");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTEqualTo(String value) {
            addCriterion("STATEMENT =", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTNotEqualTo(String value) {
            addCriterion("STATEMENT <>", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTGreaterThan(String value) {
            addCriterion("STATEMENT >", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTGreaterThanOrEqualTo(String value) {
            addCriterion("STATEMENT >=", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTLessThan(String value) {
            addCriterion("STATEMENT <", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTLessThanOrEqualTo(String value) {
            addCriterion("STATEMENT <=", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTLike(String value) {
            addCriterion("STATEMENT like", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTNotLike(String value) {
            addCriterion("STATEMENT not like", value, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTIn(List<String> values) {
            addCriterion("STATEMENT in", values, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTNotIn(List<String> values) {
            addCriterion("STATEMENT not in", values, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTBetween(String value1, String value2) {
            addCriterion("STATEMENT between", value1, value2, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andSTATEMENTNotBetween(String value1, String value2) {
            addCriterion("STATEMENT not between", value1, value2, "STATEMENT");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDIsNull() {
            addCriterion("ISSUCCED is null");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDIsNotNull() {
            addCriterion("ISSUCCED is not null");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDEqualTo(Short value) {
            addCriterion("ISSUCCED =", value, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDNotEqualTo(Short value) {
            addCriterion("ISSUCCED <>", value, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDGreaterThan(Short value) {
            addCriterion("ISSUCCED >", value, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDGreaterThanOrEqualTo(Short value) {
            addCriterion("ISSUCCED >=", value, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDLessThan(Short value) {
            addCriterion("ISSUCCED <", value, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDLessThanOrEqualTo(Short value) {
            addCriterion("ISSUCCED <=", value, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDIn(List<Short> values) {
            addCriterion("ISSUCCED in", values, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDNotIn(List<Short> values) {
            addCriterion("ISSUCCED not in", values, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDBetween(Short value1, Short value2) {
            addCriterion("ISSUCCED between", value1, value2, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andISSUCCEDNotBetween(Short value1, Short value2) {
            addCriterion("ISSUCCED not between", value1, value2, "ISSUCCED");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEIsNull() {
            addCriterion("WORKJOB_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEIsNotNull() {
            addCriterion("WORKJOB_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEEqualTo(String value) {
            addCriterion("WORKJOB_TYPE =", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPENotEqualTo(String value) {
            addCriterion("WORKJOB_TYPE <>", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEGreaterThan(String value) {
            addCriterion("WORKJOB_TYPE >", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEGreaterThanOrEqualTo(String value) {
            addCriterion("WORKJOB_TYPE >=", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPELessThan(String value) {
            addCriterion("WORKJOB_TYPE <", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPELessThanOrEqualTo(String value) {
            addCriterion("WORKJOB_TYPE <=", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPELike(String value) {
            addCriterion("WORKJOB_TYPE like", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPENotLike(String value) {
            addCriterion("WORKJOB_TYPE not like", value, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEIn(List<String> values) {
            addCriterion("WORKJOB_TYPE in", values, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPENotIn(List<String> values) {
            addCriterion("WORKJOB_TYPE not in", values, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPEBetween(String value1, String value2) {
            addCriterion("WORKJOB_TYPE between", value1, value2, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andWORKJOB_TYPENotBetween(String value1, String value2) {
            addCriterion("WORKJOB_TYPE not between", value1, value2, "WORKJOB_TYPE");
            return (Criteria) this;
        }

        public Criteria andNASIDIsNull() {
            addCriterion("NASID is null");
            return (Criteria) this;
        }

        public Criteria andNASIDIsNotNull() {
            addCriterion("NASID is not null");
            return (Criteria) this;
        }

        public Criteria andNASIDEqualTo(String value) {
            addCriterion("NASID =", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDNotEqualTo(String value) {
            addCriterion("NASID <>", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDGreaterThan(String value) {
            addCriterion("NASID >", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDGreaterThanOrEqualTo(String value) {
            addCriterion("NASID >=", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDLessThan(String value) {
            addCriterion("NASID <", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDLessThanOrEqualTo(String value) {
            addCriterion("NASID <=", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDLike(String value) {
            addCriterion("NASID like", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDNotLike(String value) {
            addCriterion("NASID not like", value, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDIn(List<String> values) {
            addCriterion("NASID in", values, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDNotIn(List<String> values) {
            addCriterion("NASID not in", values, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDBetween(String value1, String value2) {
            addCriterion("NASID between", value1, value2, "NASID");
            return (Criteria) this;
        }

        public Criteria andNASIDNotBetween(String value1, String value2) {
            addCriterion("NASID not between", value1, value2, "NASID");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEIsNull() {
            addCriterion("FINISHTIME is null");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEIsNotNull() {
            addCriterion("FINISHTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEEqualTo(Date value) {
            addCriterionForJDBCDate("FINISHTIME =", value, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMENotEqualTo(Date value) {
            addCriterionForJDBCDate("FINISHTIME <>", value, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEGreaterThan(Date value) {
            addCriterionForJDBCDate("FINISHTIME >", value, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FINISHTIME >=", value, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMELessThan(Date value) {
            addCriterionForJDBCDate("FINISHTIME <", value, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FINISHTIME <=", value, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEIn(List<Date> values) {
            addCriterionForJDBCDate("FINISHTIME in", values, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMENotIn(List<Date> values) {
            addCriterionForJDBCDate("FINISHTIME not in", values, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FINISHTIME between", value1, value2, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andFINISHTIMENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FINISHTIME not between", value1, value2, "FINISHTIME");
            return (Criteria) this;
        }

        public Criteria andRECEIPTIsNull() {
            addCriterion("RECEIPT is null");
            return (Criteria) this;
        }

        public Criteria andRECEIPTIsNotNull() {
            addCriterion("RECEIPT is not null");
            return (Criteria) this;
        }

        public Criteria andRECEIPTEqualTo(Date value) {
            addCriterionForJDBCDate("RECEIPT =", value, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTNotEqualTo(Date value) {
            addCriterionForJDBCDate("RECEIPT <>", value, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTGreaterThan(Date value) {
            addCriterionForJDBCDate("RECEIPT >", value, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RECEIPT >=", value, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTLessThan(Date value) {
            addCriterionForJDBCDate("RECEIPT <", value, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("RECEIPT <=", value, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTIn(List<Date> values) {
            addCriterionForJDBCDate("RECEIPT in", values, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTNotIn(List<Date> values) {
            addCriterionForJDBCDate("RECEIPT not in", values, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RECEIPT between", value1, value2, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andRECEIPTNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("RECEIPT not between", value1, value2, "RECEIPT");
            return (Criteria) this;
        }

        public Criteria andINCLUDEIsNull() {
            addCriterion("INCLUDE is null");
            return (Criteria) this;
        }

        public Criteria andINCLUDEIsNotNull() {
            addCriterion("INCLUDE is not null");
            return (Criteria) this;
        }

        public Criteria andINCLUDEEqualTo(String value) {
            addCriterion("INCLUDE =", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDENotEqualTo(String value) {
            addCriterion("INCLUDE <>", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDEGreaterThan(String value) {
            addCriterion("INCLUDE >", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDEGreaterThanOrEqualTo(String value) {
            addCriterion("INCLUDE >=", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDELessThan(String value) {
            addCriterion("INCLUDE <", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDELessThanOrEqualTo(String value) {
            addCriterion("INCLUDE <=", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDELike(String value) {
            addCriterion("INCLUDE like", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDENotLike(String value) {
            addCriterion("INCLUDE not like", value, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDEIn(List<String> values) {
            addCriterion("INCLUDE in", values, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDENotIn(List<String> values) {
            addCriterion("INCLUDE not in", values, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDEBetween(String value1, String value2) {
            addCriterion("INCLUDE between", value1, value2, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andINCLUDENotBetween(String value1, String value2) {
            addCriterion("INCLUDE not between", value1, value2, "INCLUDE");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEIsNull() {
            addCriterion("OPERATETIME is null");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEIsNotNull() {
            addCriterion("OPERATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATETIME =", value, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMENotEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATETIME <>", value, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEGreaterThan(Date value) {
            addCriterionForJDBCDate("OPERATETIME >", value, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATETIME >=", value, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMELessThan(Date value) {
            addCriterionForJDBCDate("OPERATETIME <", value, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATETIME <=", value, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATETIME in", values, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMENotIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATETIME not in", values, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATETIME between", value1, value2, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andOPERATETIMENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATETIME not between", value1, value2, "OPERATETIME");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEIsNull() {
            addCriterion("LOCALFILE is null");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEIsNotNull() {
            addCriterion("LOCALFILE is not null");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEEqualTo(String value) {
            addCriterion("LOCALFILE =", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILENotEqualTo(String value) {
            addCriterion("LOCALFILE <>", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEGreaterThan(String value) {
            addCriterion("LOCALFILE >", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEGreaterThanOrEqualTo(String value) {
            addCriterion("LOCALFILE >=", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILELessThan(String value) {
            addCriterion("LOCALFILE <", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILELessThanOrEqualTo(String value) {
            addCriterion("LOCALFILE <=", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILELike(String value) {
            addCriterion("LOCALFILE like", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILENotLike(String value) {
            addCriterion("LOCALFILE not like", value, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEIn(List<String> values) {
            addCriterion("LOCALFILE in", values, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILENotIn(List<String> values) {
            addCriterion("LOCALFILE not in", values, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILEBetween(String value1, String value2) {
            addCriterion("LOCALFILE between", value1, value2, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andLOCALFILENotBetween(String value1, String value2) {
            addCriterion("LOCALFILE not between", value1, value2, "LOCALFILE");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONIsNull() {
            addCriterion("FAILED_REASON is null");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONIsNotNull() {
            addCriterion("FAILED_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONEqualTo(String value) {
            addCriterion("FAILED_REASON =", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONNotEqualTo(String value) {
            addCriterion("FAILED_REASON <>", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONGreaterThan(String value) {
            addCriterion("FAILED_REASON >", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONGreaterThanOrEqualTo(String value) {
            addCriterion("FAILED_REASON >=", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONLessThan(String value) {
            addCriterion("FAILED_REASON <", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONLessThanOrEqualTo(String value) {
            addCriterion("FAILED_REASON <=", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONLike(String value) {
            addCriterion("FAILED_REASON like", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONNotLike(String value) {
            addCriterion("FAILED_REASON not like", value, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONIn(List<String> values) {
            addCriterion("FAILED_REASON in", values, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONNotIn(List<String> values) {
            addCriterion("FAILED_REASON not in", values, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONBetween(String value1, String value2) {
            addCriterion("FAILED_REASON between", value1, value2, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andFAILED_REASONNotBetween(String value1, String value2) {
            addCriterion("FAILED_REASON not between", value1, value2, "FAILED_REASON");
            return (Criteria) this;
        }

        public Criteria andORDER_USERIsNull() {
            addCriterion("ORDER_USER is null");
            return (Criteria) this;
        }

        public Criteria andORDER_USERIsNotNull() {
            addCriterion("ORDER_USER is not null");
            return (Criteria) this;
        }

        public Criteria andORDER_USEREqualTo(String value) {
            addCriterion("ORDER_USER =", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERNotEqualTo(String value) {
            addCriterion("ORDER_USER <>", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERGreaterThan(String value) {
            addCriterion("ORDER_USER >", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_USER >=", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERLessThan(String value) {
            addCriterion("ORDER_USER <", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERLessThanOrEqualTo(String value) {
            addCriterion("ORDER_USER <=", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERLike(String value) {
            addCriterion("ORDER_USER like", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERNotLike(String value) {
            addCriterion("ORDER_USER not like", value, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERIn(List<String> values) {
            addCriterion("ORDER_USER in", values, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERNotIn(List<String> values) {
            addCriterion("ORDER_USER not in", values, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERBetween(String value1, String value2) {
            addCriterion("ORDER_USER between", value1, value2, "ORDER_USER");
            return (Criteria) this;
        }

        public Criteria andORDER_USERNotBetween(String value1, String value2) {
            addCriterion("ORDER_USER not between", value1, value2, "ORDER_USER");
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