package com.dao.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class meta_dt_msg_send_recordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public meta_dt_msg_send_recordExample() {
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

        public Criteria andCALL_RESULTIsNull() {
            addCriterion("CALL_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTIsNotNull() {
            addCriterion("CALL_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTEqualTo(String value) {
            addCriterion("CALL_RESULT =", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTNotEqualTo(String value) {
            addCriterion("CALL_RESULT <>", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTGreaterThan(String value) {
            addCriterion("CALL_RESULT >", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTGreaterThanOrEqualTo(String value) {
            addCriterion("CALL_RESULT >=", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTLessThan(String value) {
            addCriterion("CALL_RESULT <", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTLessThanOrEqualTo(String value) {
            addCriterion("CALL_RESULT <=", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTLike(String value) {
            addCriterion("CALL_RESULT like", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTNotLike(String value) {
            addCriterion("CALL_RESULT not like", value, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTIn(List<String> values) {
            addCriterion("CALL_RESULT in", values, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTNotIn(List<String> values) {
            addCriterion("CALL_RESULT not in", values, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTBetween(String value1, String value2) {
            addCriterion("CALL_RESULT between", value1, value2, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andCALL_RESULTNotBetween(String value1, String value2) {
            addCriterion("CALL_RESULT not between", value1, value2, "CALL_RESULT");
            return (Criteria) this;
        }

        public Criteria andERR_MSGIsNull() {
            addCriterion("ERR_MSG is null");
            return (Criteria) this;
        }

        public Criteria andERR_MSGIsNotNull() {
            addCriterion("ERR_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andERR_MSGEqualTo(String value) {
            addCriterion("ERR_MSG =", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGNotEqualTo(String value) {
            addCriterion("ERR_MSG <>", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGGreaterThan(String value) {
            addCriterion("ERR_MSG >", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGGreaterThanOrEqualTo(String value) {
            addCriterion("ERR_MSG >=", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGLessThan(String value) {
            addCriterion("ERR_MSG <", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGLessThanOrEqualTo(String value) {
            addCriterion("ERR_MSG <=", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGLike(String value) {
            addCriterion("ERR_MSG like", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGNotLike(String value) {
            addCriterion("ERR_MSG not like", value, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGIn(List<String> values) {
            addCriterion("ERR_MSG in", values, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGNotIn(List<String> values) {
            addCriterion("ERR_MSG not in", values, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGBetween(String value1, String value2) {
            addCriterion("ERR_MSG between", value1, value2, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andERR_MSGNotBetween(String value1, String value2) {
            addCriterion("ERR_MSG not between", value1, value2, "ERR_MSG");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTIsNull() {
            addCriterion("MSG_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTIsNotNull() {
            addCriterion("MSG_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTEqualTo(String value) {
            addCriterion("MSG_CONTENT =", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTNotEqualTo(String value) {
            addCriterion("MSG_CONTENT <>", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTGreaterThan(String value) {
            addCriterion("MSG_CONTENT >", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTGreaterThanOrEqualTo(String value) {
            addCriterion("MSG_CONTENT >=", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTLessThan(String value) {
            addCriterion("MSG_CONTENT <", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTLessThanOrEqualTo(String value) {
            addCriterion("MSG_CONTENT <=", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTLike(String value) {
            addCriterion("MSG_CONTENT like", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTNotLike(String value) {
            addCriterion("MSG_CONTENT not like", value, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTIn(List<String> values) {
            addCriterion("MSG_CONTENT in", values, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTNotIn(List<String> values) {
            addCriterion("MSG_CONTENT not in", values, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTBetween(String value1, String value2) {
            addCriterion("MSG_CONTENT between", value1, value2, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andMSG_CONTENTNotBetween(String value1, String value2) {
            addCriterion("MSG_CONTENT not between", value1, value2, "MSG_CONTENT");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPIsNull() {
            addCriterion("SEND_TIME_STAMP is null");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPIsNotNull() {
            addCriterion("SEND_TIME_STAMP is not null");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPEqualTo(Date value) {
            addCriterion("SEND_TIME_STAMP =", value, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPNotEqualTo(Date value) {
            addCriterion("SEND_TIME_STAMP <>", value, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPGreaterThan(Date value) {
            addCriterion("SEND_TIME_STAMP >", value, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME_STAMP >=", value, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPLessThan(Date value) {
            addCriterion("SEND_TIME_STAMP <", value, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPLessThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME_STAMP <=", value, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPIn(List<Date> values) {
            addCriterion("SEND_TIME_STAMP in", values, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPNotIn(List<Date> values) {
            addCriterion("SEND_TIME_STAMP not in", values, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME_STAMP between", value1, value2, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andSEND_TIME_STAMPNotBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME_STAMP not between", value1, value2, "SEND_TIME_STAMP");
            return (Criteria) this;
        }

        public Criteria andESB_MSGIsNull() {
            addCriterion("ESB_MSG is null");
            return (Criteria) this;
        }

        public Criteria andESB_MSGIsNotNull() {
            addCriterion("ESB_MSG is not null");
            return (Criteria) this;
        }

        public Criteria andESB_MSGEqualTo(String value) {
            addCriterion("ESB_MSG =", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGNotEqualTo(String value) {
            addCriterion("ESB_MSG <>", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGGreaterThan(String value) {
            addCriterion("ESB_MSG >", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGGreaterThanOrEqualTo(String value) {
            addCriterion("ESB_MSG >=", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGLessThan(String value) {
            addCriterion("ESB_MSG <", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGLessThanOrEqualTo(String value) {
            addCriterion("ESB_MSG <=", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGLike(String value) {
            addCriterion("ESB_MSG like", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGNotLike(String value) {
            addCriterion("ESB_MSG not like", value, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGIn(List<String> values) {
            addCriterion("ESB_MSG in", values, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGNotIn(List<String> values) {
            addCriterion("ESB_MSG not in", values, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGBetween(String value1, String value2) {
            addCriterion("ESB_MSG between", value1, value2, "ESB_MSG");
            return (Criteria) this;
        }

        public Criteria andESB_MSGNotBetween(String value1, String value2) {
            addCriterion("ESB_MSG not between", value1, value2, "ESB_MSG");
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