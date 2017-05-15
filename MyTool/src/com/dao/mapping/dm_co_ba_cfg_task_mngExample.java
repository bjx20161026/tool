package com.dao.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class dm_co_ba_cfg_task_mngExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public dm_co_ba_cfg_task_mngExample() {
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

        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(String value) {
            addCriterion("ID =", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(String value) {
            addCriterion("ID <>", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(String value) {
            addCriterion("ID >", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(String value) {
            addCriterion("ID <", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDLike(String value) {
            addCriterion("ID like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotLike(String value) {
            addCriterion("ID not like", value, "ID");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<String> values) {
            addCriterion("ID in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<String> values) {
            addCriterion("ID not in", values, "ID");
            return (Criteria) this;
        }

        public Criteria andIDBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "ID");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEIsNull() {
            addCriterion("TIMETYPE is null");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEIsNotNull() {
            addCriterion("TIMETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEEqualTo(String value) {
            addCriterion("TIMETYPE =", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPENotEqualTo(String value) {
            addCriterion("TIMETYPE <>", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEGreaterThan(String value) {
            addCriterion("TIMETYPE >", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEGreaterThanOrEqualTo(String value) {
            addCriterion("TIMETYPE >=", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPELessThan(String value) {
            addCriterion("TIMETYPE <", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPELessThanOrEqualTo(String value) {
            addCriterion("TIMETYPE <=", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPELike(String value) {
            addCriterion("TIMETYPE like", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPENotLike(String value) {
            addCriterion("TIMETYPE not like", value, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEIn(List<String> values) {
            addCriterion("TIMETYPE in", values, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPENotIn(List<String> values) {
            addCriterion("TIMETYPE not in", values, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPEBetween(String value1, String value2) {
            addCriterion("TIMETYPE between", value1, value2, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMETYPENotBetween(String value1, String value2) {
            addCriterion("TIMETYPE not between", value1, value2, "TIMETYPE");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTIsNull() {
            addCriterion("TIMEINVOKEPOINT is null");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTIsNotNull() {
            addCriterion("TIMEINVOKEPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTEqualTo(String value) {
            addCriterion("TIMEINVOKEPOINT =", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTNotEqualTo(String value) {
            addCriterion("TIMEINVOKEPOINT <>", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTGreaterThan(String value) {
            addCriterion("TIMEINVOKEPOINT >", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTGreaterThanOrEqualTo(String value) {
            addCriterion("TIMEINVOKEPOINT >=", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTLessThan(String value) {
            addCriterion("TIMEINVOKEPOINT <", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTLessThanOrEqualTo(String value) {
            addCriterion("TIMEINVOKEPOINT <=", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTLike(String value) {
            addCriterion("TIMEINVOKEPOINT like", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTNotLike(String value) {
            addCriterion("TIMEINVOKEPOINT not like", value, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTIn(List<String> values) {
            addCriterion("TIMEINVOKEPOINT in", values, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTNotIn(List<String> values) {
            addCriterion("TIMEINVOKEPOINT not in", values, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTBetween(String value1, String value2) {
            addCriterion("TIMEINVOKEPOINT between", value1, value2, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEINVOKEPOINTNotBetween(String value1, String value2) {
            addCriterion("TIMEINVOKEPOINT not between", value1, value2, "TIMEINVOKEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTIsNull() {
            addCriterion("TIMEPOINT is null");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTIsNotNull() {
            addCriterion("TIMEPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTEqualTo(String value) {
            addCriterion("TIMEPOINT =", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTNotEqualTo(String value) {
            addCriterion("TIMEPOINT <>", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTGreaterThan(String value) {
            addCriterion("TIMEPOINT >", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTGreaterThanOrEqualTo(String value) {
            addCriterion("TIMEPOINT >=", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTLessThan(String value) {
            addCriterion("TIMEPOINT <", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTLessThanOrEqualTo(String value) {
            addCriterion("TIMEPOINT <=", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTLike(String value) {
            addCriterion("TIMEPOINT like", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTNotLike(String value) {
            addCriterion("TIMEPOINT not like", value, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTIn(List<String> values) {
            addCriterion("TIMEPOINT in", values, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTNotIn(List<String> values) {
            addCriterion("TIMEPOINT not in", values, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTBetween(String value1, String value2) {
            addCriterion("TIMEPOINT between", value1, value2, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andTIMEPOINTNotBetween(String value1, String value2) {
            addCriterion("TIMEPOINT not between", value1, value2, "TIMEPOINT");
            return (Criteria) this;
        }

        public Criteria andENABLEDIsNull() {
            addCriterion("ENABLED is null");
            return (Criteria) this;
        }

        public Criteria andENABLEDIsNotNull() {
            addCriterion("ENABLED is not null");
            return (Criteria) this;
        }

        public Criteria andENABLEDEqualTo(Short value) {
            addCriterion("ENABLED =", value, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDNotEqualTo(Short value) {
            addCriterion("ENABLED <>", value, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDGreaterThan(Short value) {
            addCriterion("ENABLED >", value, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDGreaterThanOrEqualTo(Short value) {
            addCriterion("ENABLED >=", value, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDLessThan(Short value) {
            addCriterion("ENABLED <", value, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDLessThanOrEqualTo(Short value) {
            addCriterion("ENABLED <=", value, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDIn(List<Short> values) {
            addCriterion("ENABLED in", values, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDNotIn(List<Short> values) {
            addCriterion("ENABLED not in", values, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDBetween(Short value1, Short value2) {
            addCriterion("ENABLED between", value1, value2, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andENABLEDNotBetween(Short value1, Short value2) {
            addCriterion("ENABLED not between", value1, value2, "ENABLED");
            return (Criteria) this;
        }

        public Criteria andPRIORITYIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPRIORITYIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPRIORITYEqualTo(Short value) {
            addCriterion("PRIORITY =", value, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYNotEqualTo(Short value) {
            addCriterion("PRIORITY <>", value, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYGreaterThan(Short value) {
            addCriterion("PRIORITY >", value, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYGreaterThanOrEqualTo(Short value) {
            addCriterion("PRIORITY >=", value, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYLessThan(Short value) {
            addCriterion("PRIORITY <", value, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYLessThanOrEqualTo(Short value) {
            addCriterion("PRIORITY <=", value, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYIn(List<Short> values) {
            addCriterion("PRIORITY in", values, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYNotIn(List<Short> values) {
            addCriterion("PRIORITY not in", values, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYBetween(Short value1, Short value2) {
            addCriterion("PRIORITY between", value1, value2, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andPRIORITYNotBetween(Short value1, Short value2) {
            addCriterion("PRIORITY not between", value1, value2, "PRIORITY");
            return (Criteria) this;
        }

        public Criteria andSUBIDIsNull() {
            addCriterion("SUBID is null");
            return (Criteria) this;
        }

        public Criteria andSUBIDIsNotNull() {
            addCriterion("SUBID is not null");
            return (Criteria) this;
        }

        public Criteria andSUBIDEqualTo(String value) {
            addCriterion("SUBID =", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDNotEqualTo(String value) {
            addCriterion("SUBID <>", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDGreaterThan(String value) {
            addCriterion("SUBID >", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDGreaterThanOrEqualTo(String value) {
            addCriterion("SUBID >=", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDLessThan(String value) {
            addCriterion("SUBID <", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDLessThanOrEqualTo(String value) {
            addCriterion("SUBID <=", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDLike(String value) {
            addCriterion("SUBID like", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDNotLike(String value) {
            addCriterion("SUBID not like", value, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDIn(List<String> values) {
            addCriterion("SUBID in", values, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDNotIn(List<String> values) {
            addCriterion("SUBID not in", values, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDBetween(String value1, String value2) {
            addCriterion("SUBID between", value1, value2, "SUBID");
            return (Criteria) this;
        }

        public Criteria andSUBIDNotBetween(String value1, String value2) {
            addCriterion("SUBID not between", value1, value2, "SUBID");
            return (Criteria) this;
        }

        public Criteria andREMARKIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andREMARKIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andREMARKEqualTo(String value) {
            addCriterion("REMARK =", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKGreaterThan(String value) {
            addCriterion("REMARK >", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKLessThan(String value) {
            addCriterion("REMARK <", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKLike(String value) {
            addCriterion("REMARK like", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKNotLike(String value) {
            addCriterion("REMARK not like", value, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKIn(List<String> values) {
            addCriterion("REMARK in", values, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "REMARK");
            return (Criteria) this;
        }

        public Criteria andREMARKNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "REMARK");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEIsNull() {
            addCriterion("LAST_EXE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEIsNotNull() {
            addCriterion("LAST_EXE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_EXE_TIME =", value, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMENotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_EXE_TIME <>", value, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_EXE_TIME >", value, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_EXE_TIME >=", value, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMELessThan(Date value) {
            addCriterionForJDBCDate("LAST_EXE_TIME <", value, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_EXE_TIME <=", value, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_EXE_TIME in", values, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMENotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_EXE_TIME not in", values, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_EXE_TIME between", value1, value2, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andLAST_EXE_TIMENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_EXE_TIME not between", value1, value2, "LAST_EXE_TIME");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPIsNull() {
            addCriterion("SERVER_IP is null");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPIsNotNull() {
            addCriterion("SERVER_IP is not null");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPEqualTo(String value) {
            addCriterion("SERVER_IP =", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPNotEqualTo(String value) {
            addCriterion("SERVER_IP <>", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPGreaterThan(String value) {
            addCriterion("SERVER_IP >", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPGreaterThanOrEqualTo(String value) {
            addCriterion("SERVER_IP >=", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPLessThan(String value) {
            addCriterion("SERVER_IP <", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPLessThanOrEqualTo(String value) {
            addCriterion("SERVER_IP <=", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPLike(String value) {
            addCriterion("SERVER_IP like", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPNotLike(String value) {
            addCriterion("SERVER_IP not like", value, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPIn(List<String> values) {
            addCriterion("SERVER_IP in", values, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPNotIn(List<String> values) {
            addCriterion("SERVER_IP not in", values, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPBetween(String value1, String value2) {
            addCriterion("SERVER_IP between", value1, value2, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andSERVER_IPNotBetween(String value1, String value2) {
            addCriterion("SERVER_IP not between", value1, value2, "SERVER_IP");
            return (Criteria) this;
        }

        public Criteria andRESULTIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andRESULTIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andRESULTEqualTo(String value) {
            addCriterion("RESULT =", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTNotEqualTo(String value) {
            addCriterion("RESULT <>", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTGreaterThan(String value) {
            addCriterion("RESULT >", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTGreaterThanOrEqualTo(String value) {
            addCriterion("RESULT >=", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTLessThan(String value) {
            addCriterion("RESULT <", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTLessThanOrEqualTo(String value) {
            addCriterion("RESULT <=", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTLike(String value) {
            addCriterion("RESULT like", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTNotLike(String value) {
            addCriterion("RESULT not like", value, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTIn(List<String> values) {
            addCriterion("RESULT in", values, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTNotIn(List<String> values) {
            addCriterion("RESULT not in", values, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTBetween(String value1, String value2) {
            addCriterion("RESULT between", value1, value2, "RESULT");
            return (Criteria) this;
        }

        public Criteria andRESULTNotBetween(String value1, String value2) {
            addCriterion("RESULT not between", value1, value2, "RESULT");
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