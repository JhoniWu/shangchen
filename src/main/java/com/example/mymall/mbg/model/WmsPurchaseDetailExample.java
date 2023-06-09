package com.example.mymall.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WmsPurchaseDetailExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public WmsPurchaseDetailExample() {
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

		public Criteria andPurchaseIdIsNull() {
			addCriterion("purchase_id is null");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdIsNotNull() {
			addCriterion("purchase_id is not null");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdEqualTo(Long value) {
			addCriterion("purchase_id =", value, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdNotEqualTo(Long value) {
			addCriterion("purchase_id <>", value, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdGreaterThan(Long value) {
			addCriterion("purchase_id >", value, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdGreaterThanOrEqualTo(Long value) {
			addCriterion("purchase_id >=", value, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdLessThan(Long value) {
			addCriterion("purchase_id <", value, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdLessThanOrEqualTo(Long value) {
			addCriterion("purchase_id <=", value, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdIn(List<Long> values) {
			addCriterion("purchase_id in", values, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdNotIn(List<Long> values) {
			addCriterion("purchase_id not in", values, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdBetween(Long value1, Long value2) {
			addCriterion("purchase_id between", value1, value2, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andPurchaseIdNotBetween(Long value1, Long value2) {
			addCriterion("purchase_id not between", value1, value2, "purchaseId");
			return (Criteria) this;
		}

		public Criteria andSkuIdIsNull() {
			addCriterion("sku_id is null");
			return (Criteria) this;
		}

		public Criteria andSkuIdIsNotNull() {
			addCriterion("sku_id is not null");
			return (Criteria) this;
		}

		public Criteria andSkuIdEqualTo(Long value) {
			addCriterion("sku_id =", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotEqualTo(Long value) {
			addCriterion("sku_id <>", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdGreaterThan(Long value) {
			addCriterion("sku_id >", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
			addCriterion("sku_id >=", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdLessThan(Long value) {
			addCriterion("sku_id <", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdLessThanOrEqualTo(Long value) {
			addCriterion("sku_id <=", value, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdIn(List<Long> values) {
			addCriterion("sku_id in", values, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotIn(List<Long> values) {
			addCriterion("sku_id not in", values, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdBetween(Long value1, Long value2) {
			addCriterion("sku_id between", value1, value2, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuIdNotBetween(Long value1, Long value2) {
			addCriterion("sku_id not between", value1, value2, "skuId");
			return (Criteria) this;
		}

		public Criteria andSkuNumIsNull() {
			addCriterion("sku_num is null");
			return (Criteria) this;
		}

		public Criteria andSkuNumIsNotNull() {
			addCriterion("sku_num is not null");
			return (Criteria) this;
		}

		public Criteria andSkuNumEqualTo(Integer value) {
			addCriterion("sku_num =", value, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumNotEqualTo(Integer value) {
			addCriterion("sku_num <>", value, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumGreaterThan(Integer value) {
			addCriterion("sku_num >", value, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumGreaterThanOrEqualTo(Integer value) {
			addCriterion("sku_num >=", value, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumLessThan(Integer value) {
			addCriterion("sku_num <", value, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumLessThanOrEqualTo(Integer value) {
			addCriterion("sku_num <=", value, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumIn(List<Integer> values) {
			addCriterion("sku_num in", values, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumNotIn(List<Integer> values) {
			addCriterion("sku_num not in", values, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumBetween(Integer value1, Integer value2) {
			addCriterion("sku_num between", value1, value2, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuNumNotBetween(Integer value1, Integer value2) {
			addCriterion("sku_num not between", value1, value2, "skuNum");
			return (Criteria) this;
		}

		public Criteria andSkuPriceIsNull() {
			addCriterion("sku_price is null");
			return (Criteria) this;
		}

		public Criteria andSkuPriceIsNotNull() {
			addCriterion("sku_price is not null");
			return (Criteria) this;
		}

		public Criteria andSkuPriceEqualTo(BigDecimal value) {
			addCriterion("sku_price =", value, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceNotEqualTo(BigDecimal value) {
			addCriterion("sku_price <>", value, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceGreaterThan(BigDecimal value) {
			addCriterion("sku_price >", value, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("sku_price >=", value, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceLessThan(BigDecimal value) {
			addCriterion("sku_price <", value, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("sku_price <=", value, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceIn(List<BigDecimal> values) {
			addCriterion("sku_price in", values, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceNotIn(List<BigDecimal> values) {
			addCriterion("sku_price not in", values, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sku_price between", value1, value2, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andSkuPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("sku_price not between", value1, value2, "skuPrice");
			return (Criteria) this;
		}

		public Criteria andWareIdIsNull() {
			addCriterion("ware_id is null");
			return (Criteria) this;
		}

		public Criteria andWareIdIsNotNull() {
			addCriterion("ware_id is not null");
			return (Criteria) this;
		}

		public Criteria andWareIdEqualTo(Long value) {
			addCriterion("ware_id =", value, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdNotEqualTo(Long value) {
			addCriterion("ware_id <>", value, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdGreaterThan(Long value) {
			addCriterion("ware_id >", value, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ware_id >=", value, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdLessThan(Long value) {
			addCriterion("ware_id <", value, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdLessThanOrEqualTo(Long value) {
			addCriterion("ware_id <=", value, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdIn(List<Long> values) {
			addCriterion("ware_id in", values, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdNotIn(List<Long> values) {
			addCriterion("ware_id not in", values, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdBetween(Long value1, Long value2) {
			addCriterion("ware_id between", value1, value2, "wareId");
			return (Criteria) this;
		}

		public Criteria andWareIdNotBetween(Long value1, Long value2) {
			addCriterion("ware_id not between", value1, value2, "wareId");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(Integer value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Integer value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Integer value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Integer value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Integer value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Integer> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Integer> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Integer value1, Integer value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("status not between", value1, value2, "status");
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