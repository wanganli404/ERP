package com.hnun.erp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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
            List<java.sql.Date> dateList = new ArrayList<>();
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

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(Long value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(Long value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(Long value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(Long value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(Long value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(Long value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<Long> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<Long> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(Long value1, Long value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(Long value1, Long value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andChecktimeIsNull() {
            addCriterion("CHECKTIME is null");
            return (Criteria) this;
        }

        public Criteria andChecktimeIsNotNull() {
            addCriterion("CHECKTIME is not null");
            return (Criteria) this;
        }

        public Criteria andChecktimeEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME =", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME <>", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeGreaterThan(Date value) {
            addCriterionForJDBCDate("CHECKTIME >", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME >=", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeLessThan(Date value) {
            addCriterionForJDBCDate("CHECKTIME <", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHECKTIME <=", value, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeIn(List<Date> values) {
            addCriterionForJDBCDate("CHECKTIME in", values, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("CHECKTIME not in", values, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHECKTIME between", value1, value2, "checktime");
            return (Criteria) this;
        }

        public Criteria andChecktimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHECKTIME not between", value1, value2, "checktime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("STARTTIME is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("STARTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("STARTTIME >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("STARTTIME <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STARTTIME <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("STARTTIME in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("STARTTIME not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STARTTIME between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STARTTIME not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("ENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("ENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ENDTIME >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("ENDTIME <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ENDTIME <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("ENDTIME in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ENDTIME not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENDTIME between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ENDTIME not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("CREATER is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("CREATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(Long value) {
            addCriterion("CREATER =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(Long value) {
            addCriterion("CREATER <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(Long value) {
            addCriterion("CREATER >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATER >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(Long value) {
            addCriterion("CREATER <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(Long value) {
            addCriterion("CREATER <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<Long> values) {
            addCriterion("CREATER in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<Long> values) {
            addCriterion("CREATER not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(Long value1, Long value2) {
            addCriterion("CREATER between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(Long value1, Long value2) {
            addCriterion("CREATER not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNull() {
            addCriterion("CHECKER is null");
            return (Criteria) this;
        }

        public Criteria andCheckerIsNotNull() {
            addCriterion("CHECKER is not null");
            return (Criteria) this;
        }

        public Criteria andCheckerEqualTo(Long value) {
            addCriterion("CHECKER =", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotEqualTo(Long value) {
            addCriterion("CHECKER <>", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThan(Long value) {
            addCriterion("CHECKER >", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerGreaterThanOrEqualTo(Long value) {
            addCriterion("CHECKER >=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThan(Long value) {
            addCriterion("CHECKER <", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerLessThanOrEqualTo(Long value) {
            addCriterion("CHECKER <=", value, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerIn(List<Long> values) {
            addCriterion("CHECKER in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotIn(List<Long> values) {
            addCriterion("CHECKER not in", values, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerBetween(Long value1, Long value2) {
            addCriterion("CHECKER between", value1, value2, "checker");
            return (Criteria) this;
        }

        public Criteria andCheckerNotBetween(Long value1, Long value2) {
            addCriterion("CHECKER not between", value1, value2, "checker");
            return (Criteria) this;
        }

        public Criteria andStarterIsNull() {
            addCriterion("STARTER is null");
            return (Criteria) this;
        }

        public Criteria andStarterIsNotNull() {
            addCriterion("STARTER is not null");
            return (Criteria) this;
        }

        public Criteria andStarterEqualTo(Long value) {
            addCriterion("STARTER =", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotEqualTo(Long value) {
            addCriterion("STARTER <>", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterGreaterThan(Long value) {
            addCriterion("STARTER >", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterGreaterThanOrEqualTo(Long value) {
            addCriterion("STARTER >=", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLessThan(Long value) {
            addCriterion("STARTER <", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterLessThanOrEqualTo(Long value) {
            addCriterion("STARTER <=", value, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterIn(List<Long> values) {
            addCriterion("STARTER in", values, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotIn(List<Long> values) {
            addCriterion("STARTER not in", values, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterBetween(Long value1, Long value2) {
            addCriterion("STARTER between", value1, value2, "starter");
            return (Criteria) this;
        }

        public Criteria andStarterNotBetween(Long value1, Long value2) {
            addCriterion("STARTER not between", value1, value2, "starter");
            return (Criteria) this;
        }

        public Criteria andEnderIsNull() {
            addCriterion("ENDER is null");
            return (Criteria) this;
        }

        public Criteria andEnderIsNotNull() {
            addCriterion("ENDER is not null");
            return (Criteria) this;
        }

        public Criteria andEnderEqualTo(Long value) {
            addCriterion("ENDER =", value, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderNotEqualTo(Long value) {
            addCriterion("ENDER <>", value, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderGreaterThan(Long value) {
            addCriterion("ENDER >", value, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderGreaterThanOrEqualTo(Long value) {
            addCriterion("ENDER >=", value, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderLessThan(Long value) {
            addCriterion("ENDER <", value, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderLessThanOrEqualTo(Long value) {
            addCriterion("ENDER <=", value, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderIn(List<Long> values) {
            addCriterion("ENDER in", values, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderNotIn(List<Long> values) {
            addCriterion("ENDER not in", values, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderBetween(Long value1, Long value2) {
            addCriterion("ENDER between", value1, value2, "ender");
            return (Criteria) this;
        }

        public Criteria andEnderNotBetween(Long value1, Long value2) {
            addCriterion("ENDER not between", value1, value2, "ender");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidIsNull() {
            addCriterion("SUPPLIERUUID is null");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidIsNotNull() {
            addCriterion("SUPPLIERUUID is not null");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidEqualTo(Long value) {
            addCriterion("SUPPLIERUUID =", value, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidNotEqualTo(Long value) {
            addCriterion("SUPPLIERUUID <>", value, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidGreaterThan(Long value) {
            addCriterion("SUPPLIERUUID >", value, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidGreaterThanOrEqualTo(Long value) {
            addCriterion("SUPPLIERUUID >=", value, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidLessThan(Long value) {
            addCriterion("SUPPLIERUUID <", value, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidLessThanOrEqualTo(Long value) {
            addCriterion("SUPPLIERUUID <=", value, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidIn(List<Long> values) {
            addCriterion("SUPPLIERUUID in", values, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidNotIn(List<Long> values) {
            addCriterion("SUPPLIERUUID not in", values, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidBetween(Long value1, Long value2) {
            addCriterion("SUPPLIERUUID between", value1, value2, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andSupplieruuidNotBetween(Long value1, Long value2) {
            addCriterion("SUPPLIERUUID not between", value1, value2, "supplieruuid");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("TOTALMONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("TOTALMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(Double value) {
            addCriterion("TOTALMONEY =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(Double value) {
            addCriterion("TOTALMONEY <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(Double value) {
            addCriterion("TOTALMONEY >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("TOTALMONEY >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(Double value) {
            addCriterion("TOTALMONEY <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(Double value) {
            addCriterion("TOTALMONEY <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<Double> values) {
            addCriterion("TOTALMONEY in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<Double> values) {
            addCriterion("TOTALMONEY not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(Double value1, Double value2) {
            addCriterion("TOTALMONEY between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(Double value1, Double value2) {
            addCriterion("TOTALMONEY not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andWaybillsnIsNull() {
            addCriterion("WAYBILLSN is null");
            return (Criteria) this;
        }

        public Criteria andWaybillsnIsNotNull() {
            addCriterion("WAYBILLSN is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillsnEqualTo(Long value) {
            addCriterion("WAYBILLSN =", value, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnNotEqualTo(Long value) {
            addCriterion("WAYBILLSN <>", value, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnGreaterThan(Long value) {
            addCriterion("WAYBILLSN >", value, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnGreaterThanOrEqualTo(Long value) {
            addCriterion("WAYBILLSN >=", value, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnLessThan(Long value) {
            addCriterion("WAYBILLSN <", value, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnLessThanOrEqualTo(Long value) {
            addCriterion("WAYBILLSN <=", value, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnIn(List<Long> values) {
            addCriterion("WAYBILLSN in", values, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnNotIn(List<Long> values) {
            addCriterion("WAYBILLSN not in", values, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnBetween(Long value1, Long value2) {
            addCriterion("WAYBILLSN between", value1, value2, "waybillsn");
            return (Criteria) this;
        }

        public Criteria andWaybillsnNotBetween(Long value1, Long value2) {
            addCriterion("WAYBILLSN not between", value1, value2, "waybillsn");
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