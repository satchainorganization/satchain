package com.satchain.bean.model;

import java.util.ArrayList;
import java.util.List;

public class DeviceRelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceRelationExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameIsNull() {
            addCriterion("device_farther_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameIsNotNull() {
            addCriterion("device_farther_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameEqualTo(String value) {
            addCriterion("device_farther_name =", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameNotEqualTo(String value) {
            addCriterion("device_farther_name <>", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameGreaterThan(String value) {
            addCriterion("device_farther_name >", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_farther_name >=", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameLessThan(String value) {
            addCriterion("device_farther_name <", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameLessThanOrEqualTo(String value) {
            addCriterion("device_farther_name <=", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameLike(String value) {
            addCriterion("device_farther_name like", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameNotLike(String value) {
            addCriterion("device_farther_name not like", value, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameIn(List<String> values) {
            addCriterion("device_farther_name in", values, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameNotIn(List<String> values) {
            addCriterion("device_farther_name not in", values, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameBetween(String value1, String value2) {
            addCriterion("device_farther_name between", value1, value2, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andDeviceFartherNameNotBetween(String value1, String value2) {
            addCriterion("device_farther_name not between", value1, value2, "deviceFartherName");
            return (Criteria) this;
        }

        public Criteria andMoonNumIsNull() {
            addCriterion("moon_num is null");
            return (Criteria) this;
        }

        public Criteria andMoonNumIsNotNull() {
            addCriterion("moon_num is not null");
            return (Criteria) this;
        }

        public Criteria andMoonNumEqualTo(String value) {
            addCriterion("moon_num =", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumNotEqualTo(String value) {
            addCriterion("moon_num <>", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumGreaterThan(String value) {
            addCriterion("moon_num >", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumGreaterThanOrEqualTo(String value) {
            addCriterion("moon_num >=", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumLessThan(String value) {
            addCriterion("moon_num <", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumLessThanOrEqualTo(String value) {
            addCriterion("moon_num <=", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumLike(String value) {
            addCriterion("moon_num like", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumNotLike(String value) {
            addCriterion("moon_num not like", value, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumIn(List<String> values) {
            addCriterion("moon_num in", values, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumNotIn(List<String> values) {
            addCriterion("moon_num not in", values, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumBetween(String value1, String value2) {
            addCriterion("moon_num between", value1, value2, "moonNum");
            return (Criteria) this;
        }

        public Criteria andMoonNumNotBetween(String value1, String value2) {
            addCriterion("moon_num not between", value1, value2, "moonNum");
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