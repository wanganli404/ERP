package com.hnun.erp.bean;

import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("ORIGIN is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("ORIGIN is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(String value) {
            addCriterion("ORIGIN =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(String value) {
            addCriterion("ORIGIN <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(String value) {
            addCriterion("ORIGIN >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(String value) {
            addCriterion("ORIGIN >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(String value) {
            addCriterion("ORIGIN <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(String value) {
            addCriterion("ORIGIN <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLike(String value) {
            addCriterion("ORIGIN like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotLike(String value) {
            addCriterion("ORIGIN not like", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<String> values) {
            addCriterion("ORIGIN in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<String> values) {
            addCriterion("ORIGIN not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(String value1, String value2) {
            addCriterion("ORIGIN between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(String value1, String value2) {
            addCriterion("ORIGIN not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andProducerIsNull() {
            addCriterion("PRODUCER is null");
            return (Criteria) this;
        }

        public Criteria andProducerIsNotNull() {
            addCriterion("PRODUCER is not null");
            return (Criteria) this;
        }

        public Criteria andProducerEqualTo(String value) {
            addCriterion("PRODUCER =", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotEqualTo(String value) {
            addCriterion("PRODUCER <>", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThan(String value) {
            addCriterion("PRODUCER >", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCER >=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThan(String value) {
            addCriterion("PRODUCER <", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLessThanOrEqualTo(String value) {
            addCriterion("PRODUCER <=", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerLike(String value) {
            addCriterion("PRODUCER like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotLike(String value) {
            addCriterion("PRODUCER not like", value, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerIn(List<String> values) {
            addCriterion("PRODUCER in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotIn(List<String> values) {
            addCriterion("PRODUCER not in", values, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerBetween(String value1, String value2) {
            addCriterion("PRODUCER between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andProducerNotBetween(String value1, String value2) {
            addCriterion("PRODUCER not between", value1, value2, "producer");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andInpriceIsNull() {
            addCriterion("INPRICE is null");
            return (Criteria) this;
        }

        public Criteria andInpriceIsNotNull() {
            addCriterion("INPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andInpriceEqualTo(Double value) {
            addCriterion("INPRICE =", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceNotEqualTo(Double value) {
            addCriterion("INPRICE <>", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceGreaterThan(Double value) {
            addCriterion("INPRICE >", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("INPRICE >=", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceLessThan(Double value) {
            addCriterion("INPRICE <", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceLessThanOrEqualTo(Double value) {
            addCriterion("INPRICE <=", value, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceIn(List<Double> values) {
            addCriterion("INPRICE in", values, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceNotIn(List<Double> values) {
            addCriterion("INPRICE not in", values, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceBetween(Double value1, Double value2) {
            addCriterion("INPRICE between", value1, value2, "inprice");
            return (Criteria) this;
        }

        public Criteria andInpriceNotBetween(Double value1, Double value2) {
            addCriterion("INPRICE not between", value1, value2, "inprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceIsNull() {
            addCriterion("OUTPRICE is null");
            return (Criteria) this;
        }

        public Criteria andOutpriceIsNotNull() {
            addCriterion("OUTPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOutpriceEqualTo(Double value) {
            addCriterion("OUTPRICE =", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceNotEqualTo(Double value) {
            addCriterion("OUTPRICE <>", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceGreaterThan(Double value) {
            addCriterion("OUTPRICE >", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("OUTPRICE >=", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceLessThan(Double value) {
            addCriterion("OUTPRICE <", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceLessThanOrEqualTo(Double value) {
            addCriterion("OUTPRICE <=", value, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceIn(List<Double> values) {
            addCriterion("OUTPRICE in", values, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceNotIn(List<Double> values) {
            addCriterion("OUTPRICE not in", values, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceBetween(Double value1, Double value2) {
            addCriterion("OUTPRICE between", value1, value2, "outprice");
            return (Criteria) this;
        }

        public Criteria andOutpriceNotBetween(Double value1, Double value2) {
            addCriterion("OUTPRICE not between", value1, value2, "outprice");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidIsNull() {
            addCriterion("GOODSTYPEUUID is null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidIsNotNull() {
            addCriterion("GOODSTYPEUUID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidEqualTo(Long value) {
            addCriterion("GOODSTYPEUUID =", value, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidNotEqualTo(Long value) {
            addCriterion("GOODSTYPEUUID <>", value, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidGreaterThan(Long value) {
            addCriterion("GOODSTYPEUUID >", value, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidGreaterThanOrEqualTo(Long value) {
            addCriterion("GOODSTYPEUUID >=", value, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidLessThan(Long value) {
            addCriterion("GOODSTYPEUUID <", value, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidLessThanOrEqualTo(Long value) {
            addCriterion("GOODSTYPEUUID <=", value, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidIn(List<Long> values) {
            addCriterion("GOODSTYPEUUID in", values, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidNotIn(List<Long> values) {
            addCriterion("GOODSTYPEUUID not in", values, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidBetween(Long value1, Long value2) {
            addCriterion("GOODSTYPEUUID between", value1, value2, "goodstypeuuid");
            return (Criteria) this;
        }

        public Criteria andGoodstypeuuidNotBetween(Long value1, Long value2) {
            addCriterion("GOODSTYPEUUID not between", value1, value2, "goodstypeuuid");
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