package com.dao.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EsbCollectMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EsbCollectMsgExample() {
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

        public Criteria andRECEIVE_TIME_STAMPIsNull() {
            addCriterion("RECEIVE_TIME_STAMP is null");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPIsNotNull() {
            addCriterion("RECEIVE_TIME_STAMP is not null");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPEqualTo(Date value) {
            addCriterion("RECEIVE_TIME_STAMP =", value, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPNotEqualTo(Date value) {
            addCriterion("RECEIVE_TIME_STAMP <>", value, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPGreaterThan(Date value) {
            addCriterion("RECEIVE_TIME_STAMP >", value, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPGreaterThanOrEqualTo(Date value) {
            addCriterion("RECEIVE_TIME_STAMP >=", value, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPLessThan(Date value) {
            addCriterion("RECEIVE_TIME_STAMP <", value, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPLessThanOrEqualTo(Date value) {
            addCriterion("RECEIVE_TIME_STAMP <=", value, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPIn(List<Date> values) {
            addCriterion("RECEIVE_TIME_STAMP in", values, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPNotIn(List<Date> values) {
            addCriterion("RECEIVE_TIME_STAMP not in", values, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPBetween(Date value1, Date value2) {
            addCriterion("RECEIVE_TIME_STAMP between", value1, value2, "RECEIVE_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andRECEIVE_TIME_STAMPNotBetween(Date value1, Date value2) {
            addCriterion("RECEIVE_TIME_STAMP not between", value1, value2, "RECEIVE_TIME_STAMP");
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