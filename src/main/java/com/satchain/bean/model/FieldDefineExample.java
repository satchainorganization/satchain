package com.satchain.bean.model;

import java.util.ArrayList;
import java.util.List;

public class FieldDefineExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FieldDefineExample() {
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

        public Criteria andFieldNameIsNull() {
            addCriterion("field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andMinDataIsNull() {
            addCriterion("min_data is null");
            return (Criteria) this;
        }

        public Criteria andMinDataIsNotNull() {
            addCriterion("min_data is not null");
            return (Criteria) this;
        }

        public Criteria andMinDataEqualTo(Double value) {
            addCriterion("min_data =", value, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataNotEqualTo(Double value) {
            addCriterion("min_data <>", value, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataGreaterThan(Double value) {
            addCriterion("min_data >", value, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataGreaterThanOrEqualTo(Double value) {
            addCriterion("min_data >=", value, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataLessThan(Double value) {
            addCriterion("min_data <", value, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataLessThanOrEqualTo(Double value) {
            addCriterion("min_data <=", value, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataIn(List<Double> values) {
            addCriterion("min_data in", values, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataNotIn(List<Double> values) {
            addCriterion("min_data not in", values, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataBetween(Double value1, Double value2) {
            addCriterion("min_data between", value1, value2, "minData");
            return (Criteria) this;
        }

        public Criteria andMinDataNotBetween(Double value1, Double value2) {
            addCriterion("min_data not between", value1, value2, "minData");
            return (Criteria) this;
        }

        public Criteria andMaxDataIsNull() {
            addCriterion("max_data is null");
            return (Criteria) this;
        }

        public Criteria andMaxDataIsNotNull() {
            addCriterion("max_data is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDataEqualTo(Double value) {
            addCriterion("max_data =", value, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataNotEqualTo(Double value) {
            addCriterion("max_data <>", value, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataGreaterThan(Double value) {
            addCriterion("max_data >", value, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataGreaterThanOrEqualTo(Double value) {
            addCriterion("max_data >=", value, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataLessThan(Double value) {
            addCriterion("max_data <", value, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataLessThanOrEqualTo(Double value) {
            addCriterion("max_data <=", value, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataIn(List<Double> values) {
            addCriterion("max_data in", values, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataNotIn(List<Double> values) {
            addCriterion("max_data not in", values, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataBetween(Double value1, Double value2) {
            addCriterion("max_data between", value1, value2, "maxData");
            return (Criteria) this;
        }

        public Criteria andMaxDataNotBetween(Double value1, Double value2) {
            addCriterion("max_data not between", value1, value2, "maxData");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andShowLableIsNull() {
            addCriterion("show_lable is null");
            return (Criteria) this;
        }

        public Criteria andShowLableIsNotNull() {
            addCriterion("show_lable is not null");
            return (Criteria) this;
        }

        public Criteria andShowLableEqualTo(Boolean value) {
            addCriterion("show_lable =", value, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableNotEqualTo(Boolean value) {
            addCriterion("show_lable <>", value, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableGreaterThan(Boolean value) {
            addCriterion("show_lable >", value, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("show_lable >=", value, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableLessThan(Boolean value) {
            addCriterion("show_lable <", value, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableLessThanOrEqualTo(Boolean value) {
            addCriterion("show_lable <=", value, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableIn(List<Boolean> values) {
            addCriterion("show_lable in", values, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableNotIn(List<Boolean> values) {
            addCriterion("show_lable not in", values, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableBetween(Boolean value1, Boolean value2) {
            addCriterion("show_lable between", value1, value2, "showLable");
            return (Criteria) this;
        }

        public Criteria andShowLableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("show_lable not between", value1, value2, "showLable");
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