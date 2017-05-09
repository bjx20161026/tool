package com.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class work_order_fileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public work_order_fileExample() {
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

        public Criteria andOPREATE_DATEIsNull() {
            addCriterion("OPREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATEIsNotNull() {
            addCriterion("OPREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATEEqualTo(Date value) {
            addCriterionForJDBCDate("OPREATE_DATE =", value, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATENotEqualTo(Date value) {
            addCriterionForJDBCDate("OPREATE_DATE <>", value, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATEGreaterThan(Date value) {
            addCriterionForJDBCDate("OPREATE_DATE >", value, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPREATE_DATE >=", value, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATELessThan(Date value) {
            addCriterionForJDBCDate("OPREATE_DATE <", value, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPREATE_DATE <=", value, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATEIn(List<Date> values) {
            addCriterionForJDBCDate("OPREATE_DATE in", values, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATENotIn(List<Date> values) {
            addCriterionForJDBCDate("OPREATE_DATE not in", values, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPREATE_DATE between", value1, value2, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andOPREATE_DATENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPREATE_DATE not between", value1, value2, "OPREATE_DATE");
            return (Criteria) this;
        }

        public Criteria andFLAGIsNull() {
            addCriterion("FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFLAGIsNotNull() {
            addCriterion("FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFLAGEqualTo(BigDecimal value) {
            addCriterion("FLAG =", value, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGNotEqualTo(BigDecimal value) {
            addCriterion("FLAG <>", value, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGGreaterThan(BigDecimal value) {
            addCriterion("FLAG >", value, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAG >=", value, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGLessThan(BigDecimal value) {
            addCriterion("FLAG <", value, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FLAG <=", value, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGIn(List<BigDecimal> values) {
            addCriterion("FLAG in", values, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGNotIn(List<BigDecimal> values) {
            addCriterion("FLAG not in", values, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAG between", value1, value2, "FLAG");
            return (Criteria) this;
        }

        public Criteria andFLAGNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FLAG not between", value1, value2, "FLAG");
            return (Criteria) this;
        }

        public Criteria andUUIDIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUUIDIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUUIDEqualTo(String value) {
            addCriterion("UUID =", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDNotEqualTo(String value) {
            addCriterion("UUID <>", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDGreaterThan(String value) {
            addCriterion("UUID >", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDLessThan(String value) {
            addCriterion("UUID <", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDLike(String value) {
            addCriterion("UUID like", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDNotLike(String value) {
            addCriterion("UUID not like", value, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDIn(List<String> values) {
            addCriterion("UUID in", values, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDNotIn(List<String> values) {
            addCriterion("UUID not in", values, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "UUID");
            return (Criteria) this;
        }

        public Criteria andUUIDNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "UUID");
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