package com.example.mymall.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SmsSeckillSkuRelationExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SmsSeckillSkuRelationExample() {
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

		public Criteria andPromotionIdIsNull() {
			addCriterion("promotion_id is null");
			return (Criteria) this;
		}

		public Criteria andPromotionIdIsNotNull() {
			addCriterion("promotion_id is not null");
			return (Criteria) this;
		}

		public Criteria andPromotionIdEqualTo(Long value) {
			addCriterion("promotion_id =", value, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdNotEqualTo(Long value) {
			addCriterion("promotion_id <>", value, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdGreaterThan(Long value) {
			addCriterion("promotion_id >", value, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("promotion_id >=", value, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdLessThan(Long value) {
			addCriterion("promotion_id <", value, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdLessThanOrEqualTo(Long value) {
			addCriterion("promotion_id <=", value, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdIn(List<Long> values) {
			addCriterion("promotion_id in", values, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdNotIn(List<Long> values) {
			addCriterion("promotion_id not in", values, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdBetween(Long value1, Long value2) {
			addCriterion("promotion_id between", value1, value2, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionIdNotBetween(Long value1, Long value2) {
			addCriterion("promotion_id not between", value1, value2, "promotionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdIsNull() {
			addCriterion("promotion_session_id is null");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdIsNotNull() {
			addCriterion("promotion_session_id is not null");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdEqualTo(Long value) {
			addCriterion("promotion_session_id =", value, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdNotEqualTo(Long value) {
			addCriterion("promotion_session_id <>", value, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdGreaterThan(Long value) {
			addCriterion("promotion_session_id >", value, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("promotion_session_id >=", value, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdLessThan(Long value) {
			addCriterion("promotion_session_id <", value, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdLessThanOrEqualTo(Long value) {
			addCriterion("promotion_session_id <=", value, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdIn(List<Long> values) {
			addCriterion("promotion_session_id in", values, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdNotIn(List<Long> values) {
			addCriterion("promotion_session_id not in", values, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdBetween(Long value1, Long value2) {
			addCriterion("promotion_session_id between", value1, value2, "promotionSessionId");
			return (Criteria) this;
		}

		public Criteria andPromotionSessionIdNotBetween(Long value1, Long value2) {
			addCriterion("promotion_session_id not between", value1, value2, "promotionSessionId");
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

		public Criteria andSeckillPriceIsNull() {
			addCriterion("seckill_price is null");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceIsNotNull() {
			addCriterion("seckill_price is not null");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceEqualTo(BigDecimal value) {
			addCriterion("seckill_price =", value, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceNotEqualTo(BigDecimal value) {
			addCriterion("seckill_price <>", value, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceGreaterThan(BigDecimal value) {
			addCriterion("seckill_price >", value, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("seckill_price >=", value, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceLessThan(BigDecimal value) {
			addCriterion("seckill_price <", value, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("seckill_price <=", value, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceIn(List<BigDecimal> values) {
			addCriterion("seckill_price in", values, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceNotIn(List<BigDecimal> values) {
			addCriterion("seckill_price not in", values, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("seckill_price between", value1, value2, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillPriceNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("seckill_price not between", value1, value2, "seckillPrice");
			return (Criteria) this;
		}

		public Criteria andSeckillCountIsNull() {
			addCriterion("seckill_count is null");
			return (Criteria) this;
		}

		public Criteria andSeckillCountIsNotNull() {
			addCriterion("seckill_count is not null");
			return (Criteria) this;
		}

		public Criteria andSeckillCountEqualTo(Integer value) {
			addCriterion("seckill_count =", value, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountNotEqualTo(Integer value) {
			addCriterion("seckill_count <>", value, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountGreaterThan(Integer value) {
			addCriterion("seckill_count >", value, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("seckill_count >=", value, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountLessThan(Integer value) {
			addCriterion("seckill_count <", value, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountLessThanOrEqualTo(Integer value) {
			addCriterion("seckill_count <=", value, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountIn(List<Integer> values) {
			addCriterion("seckill_count in", values, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountNotIn(List<Integer> values) {
			addCriterion("seckill_count not in", values, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountBetween(Integer value1, Integer value2) {
			addCriterion("seckill_count between", value1, value2, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillCountNotBetween(Integer value1, Integer value2) {
			addCriterion("seckill_count not between", value1, value2, "seckillCount");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitIsNull() {
			addCriterion("seckill_limit is null");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitIsNotNull() {
			addCriterion("seckill_limit is not null");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitEqualTo(Integer value) {
			addCriterion("seckill_limit =", value, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitNotEqualTo(Integer value) {
			addCriterion("seckill_limit <>", value, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitGreaterThan(Integer value) {
			addCriterion("seckill_limit >", value, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitGreaterThanOrEqualTo(Integer value) {
			addCriterion("seckill_limit >=", value, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitLessThan(Integer value) {
			addCriterion("seckill_limit <", value, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitLessThanOrEqualTo(Integer value) {
			addCriterion("seckill_limit <=", value, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitIn(List<Integer> values) {
			addCriterion("seckill_limit in", values, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitNotIn(List<Integer> values) {
			addCriterion("seckill_limit not in", values, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitBetween(Integer value1, Integer value2) {
			addCriterion("seckill_limit between", value1, value2, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillLimitNotBetween(Integer value1, Integer value2) {
			addCriterion("seckill_limit not between", value1, value2, "seckillLimit");
			return (Criteria) this;
		}

		public Criteria andSeckillSortIsNull() {
			addCriterion("seckill_sort is null");
			return (Criteria) this;
		}

		public Criteria andSeckillSortIsNotNull() {
			addCriterion("seckill_sort is not null");
			return (Criteria) this;
		}

		public Criteria andSeckillSortEqualTo(Integer value) {
			addCriterion("seckill_sort =", value, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortNotEqualTo(Integer value) {
			addCriterion("seckill_sort <>", value, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortGreaterThan(Integer value) {
			addCriterion("seckill_sort >", value, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("seckill_sort >=", value, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortLessThan(Integer value) {
			addCriterion("seckill_sort <", value, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortLessThanOrEqualTo(Integer value) {
			addCriterion("seckill_sort <=", value, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortIn(List<Integer> values) {
			addCriterion("seckill_sort in", values, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortNotIn(List<Integer> values) {
			addCriterion("seckill_sort not in", values, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortBetween(Integer value1, Integer value2) {
			addCriterion("seckill_sort between", value1, value2, "seckillSort");
			return (Criteria) this;
		}

		public Criteria andSeckillSortNotBetween(Integer value1, Integer value2) {
			addCriterion("seckill_sort not between", value1, value2, "seckillSort");
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