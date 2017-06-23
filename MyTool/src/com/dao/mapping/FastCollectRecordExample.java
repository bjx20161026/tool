package com.dao.mapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FastCollectRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FastCollectRecordExample() {
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

        public Criteria andINSERT_TIMEIsNull() {
            addCriterion("INSERT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMEIsNotNull() {
            addCriterion("INSERT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMEEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME =", value, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMENotEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME <>", value, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMEGreaterThan(Date value) {
            addCriterionForJDBCDate("INSERT_TIME >", value, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMEGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME >=", value, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMELessThan(Date value) {
            addCriterionForJDBCDate("INSERT_TIME <", value, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMELessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME <=", value, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMEIn(List<Date> values) {
            addCriterionForJDBCDate("INSERT_TIME in", values, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMENotIn(List<Date> values) {
            addCriterionForJDBCDate("INSERT_TIME not in", values, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMEBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSERT_TIME between", value1, value2, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andINSERT_TIMENotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSERT_TIME not between", value1, value2, "INSERT_TIME");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLIsNull() {
            addCriterion("PROTOCOL is null");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLIsNotNull() {
            addCriterion("PROTOCOL is not null");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLEqualTo(String value) {
            addCriterion("PROTOCOL =", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLNotEqualTo(String value) {
            addCriterion("PROTOCOL <>", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLGreaterThan(String value) {
            addCriterion("PROTOCOL >", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLGreaterThanOrEqualTo(String value) {
            addCriterion("PROTOCOL >=", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLLessThan(String value) {
            addCriterion("PROTOCOL <", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLLessThanOrEqualTo(String value) {
            addCriterion("PROTOCOL <=", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLLike(String value) {
            addCriterion("PROTOCOL like", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLNotLike(String value) {
            addCriterion("PROTOCOL not like", value, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLIn(List<String> values) {
            addCriterion("PROTOCOL in", values, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLNotIn(List<String> values) {
            addCriterion("PROTOCOL not in", values, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLBetween(String value1, String value2) {
            addCriterion("PROTOCOL between", value1, value2, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andPROTOCOLNotBetween(String value1, String value2) {
            addCriterion("PROTOCOL not between", value1, value2, "PROTOCOL");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEIsNull() {
            addCriterion("DEALTYPE is null");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEIsNotNull() {
            addCriterion("DEALTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEEqualTo(String value) {
            addCriterion("DEALTYPE =", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPENotEqualTo(String value) {
            addCriterion("DEALTYPE <>", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEGreaterThan(String value) {
            addCriterion("DEALTYPE >", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEGreaterThanOrEqualTo(String value) {
            addCriterion("DEALTYPE >=", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPELessThan(String value) {
            addCriterion("DEALTYPE <", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPELessThanOrEqualTo(String value) {
            addCriterion("DEALTYPE <=", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPELike(String value) {
            addCriterion("DEALTYPE like", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPENotLike(String value) {
            addCriterion("DEALTYPE not like", value, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEIn(List<String> values) {
            addCriterion("DEALTYPE in", values, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPENotIn(List<String> values) {
            addCriterion("DEALTYPE not in", values, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPEBetween(String value1, String value2) {
            addCriterion("DEALTYPE between", value1, value2, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andDEALTYPENotBetween(String value1, String value2) {
            addCriterion("DEALTYPE not between", value1, value2, "DEALTYPE");
            return (Criteria) this;
        }

        public Criteria andFILENAMEIsNull() {
            addCriterion("FILENAME is null");
            return (Criteria) this;
        }

        public Criteria andFILENAMEIsNotNull() {
            addCriterion("FILENAME is not null");
            return (Criteria) this;
        }

        public Criteria andFILENAMEEqualTo(String value) {
            addCriterion("FILENAME =", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotEqualTo(String value) {
            addCriterion("FILENAME <>", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEGreaterThan(String value) {
            addCriterion("FILENAME >", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEGreaterThanOrEqualTo(String value) {
            addCriterion("FILENAME >=", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMELessThan(String value) {
            addCriterion("FILENAME <", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMELessThanOrEqualTo(String value) {
            addCriterion("FILENAME <=", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMELike(String value) {
            addCriterion("FILENAME like", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotLike(String value) {
            addCriterion("FILENAME not like", value, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEIn(List<String> values) {
            addCriterion("FILENAME in", values, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotIn(List<String> values) {
            addCriterion("FILENAME not in", values, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMEBetween(String value1, String value2) {
            addCriterion("FILENAME between", value1, value2, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILENAMENotBetween(String value1, String value2) {
            addCriterion("FILENAME not between", value1, value2, "FILENAME");
            return (Criteria) this;
        }

        public Criteria andFILEPATHIsNull() {
            addCriterion("FILEPATH is null");
            return (Criteria) this;
        }

        public Criteria andFILEPATHIsNotNull() {
            addCriterion("FILEPATH is not null");
            return (Criteria) this;
        }

        public Criteria andFILEPATHEqualTo(String value) {
            addCriterion("FILEPATH =", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHNotEqualTo(String value) {
            addCriterion("FILEPATH <>", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHGreaterThan(String value) {
            addCriterion("FILEPATH >", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHGreaterThanOrEqualTo(String value) {
            addCriterion("FILEPATH >=", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHLessThan(String value) {
            addCriterion("FILEPATH <", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHLessThanOrEqualTo(String value) {
            addCriterion("FILEPATH <=", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHLike(String value) {
            addCriterion("FILEPATH like", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHNotLike(String value) {
            addCriterion("FILEPATH not like", value, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHIn(List<String> values) {
            addCriterion("FILEPATH in", values, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHNotIn(List<String> values) {
            addCriterion("FILEPATH not in", values, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHBetween(String value1, String value2) {
            addCriterion("FILEPATH between", value1, value2, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andFILEPATHNotBetween(String value1, String value2) {
            addCriterion("FILEPATH not between", value1, value2, "FILEPATH");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEIsNull() {
            addCriterion("SPENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEIsNotNull() {
            addCriterion("SPENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEEqualTo(BigDecimal value) {
            addCriterion("SPENDTIME =", value, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMENotEqualTo(BigDecimal value) {
            addCriterion("SPENDTIME <>", value, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEGreaterThan(BigDecimal value) {
            addCriterion("SPENDTIME >", value, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPENDTIME >=", value, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMELessThan(BigDecimal value) {
            addCriterion("SPENDTIME <", value, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMELessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPENDTIME <=", value, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEIn(List<BigDecimal> values) {
            addCriterion("SPENDTIME in", values, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMENotIn(List<BigDecimal> values) {
            addCriterion("SPENDTIME not in", values, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMEBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPENDTIME between", value1, value2, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andSPENDTIMENotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPENDTIME not between", value1, value2, "SPENDTIME");
            return (Criteria) this;
        }

        public Criteria andQUANTITYIsNull() {
            addCriterion("QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andQUANTITYIsNotNull() {
            addCriterion("QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andQUANTITYEqualTo(BigDecimal value) {
            addCriterion("QUANTITY =", value, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYNotEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <>", value, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYGreaterThan(BigDecimal value) {
            addCriterion("QUANTITY >", value, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY >=", value, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYLessThan(BigDecimal value) {
            addCriterion("QUANTITY <", value, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYLessThanOrEqualTo(BigDecimal value) {
            addCriterion("QUANTITY <=", value, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYIn(List<BigDecimal> values) {
            addCriterion("QUANTITY in", values, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYNotIn(List<BigDecimal> values) {
            addCriterion("QUANTITY not in", values, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY between", value1, value2, "QUANTITY");
            return (Criteria) this;
        }

        public Criteria andQUANTITYNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("QUANTITY not between", value1, value2, "QUANTITY");
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