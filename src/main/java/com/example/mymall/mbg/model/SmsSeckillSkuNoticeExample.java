package com.example.mymall.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmsSeckillSkuNoticeExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SmsSeckillSkuNoticeExample() {
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

		public Criteria andMemberIdIsNull() {
			addCriterion("member_id is null");
			return (Criteria) this;
		}

		public Criteria andMemberIdIsNotNull() {
			addCriterion("member_id is not null");
			return (Criteria) this;
		}

		public Criteria andMemberIdEqualTo(Long value) {
			addCriterion("member_id =", value, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdNotEqualTo(Long value) {
			addCriterion("member_id <>", value, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdGreaterThan(Long value) {
			addCriterion("member_id >", value, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
			addCriterion("member_id >=", value, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdLessThan(Long value) {
			addCriterion("member_id <", value, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdLessThanOrEqualTo(Long value) {
			addCriterion("member_id <=", value, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdIn(List<Long> values) {
			addCriterion("member_id in", values, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdNotIn(List<Long> values) {
			addCriterion("member_id not in", values, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdBetween(Long value1, Long value2) {
			addCriterion("member_id between", value1, value2, "memberId");
			return (Criteria) this;
		}

		public Criteria andMemberIdNotBetween(Long value1, Long value2) {
			addCriterion("member_id not between", value1, value2, "memberId");
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

		public Criteria andSessionIdIsNull() {
			addCriterion("session_id is null");
			return (Criteria) this;
		}

		public Criteria andSessionIdIsNotNull() {
			addCriterion("session_id is not null");
			return (Criteria) this;
		}

		public Criteria andSessionIdEqualTo(Long value) {
			addCriterion("session_id =", value, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdNotEqualTo(Long value) {
			addCriterion("session_id <>", value, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdGreaterThan(Long value) {
			addCriterion("session_id >", value, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("session_id >=", value, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdLessThan(Long value) {
			addCriterion("session_id <", value, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdLessThanOrEqualTo(Long value) {
			addCriterion("session_id <=", value, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdIn(List<Long> values) {
			addCriterion("session_id in", values, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdNotIn(List<Long> values) {
			addCriterion("session_id not in", values, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdBetween(Long value1, Long value2) {
			addCriterion("session_id between", value1, value2, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSessionIdNotBetween(Long value1, Long value2) {
			addCriterion("session_id not between", value1, value2, "sessionId");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeIsNull() {
			addCriterion("subcribe_time is null");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeIsNotNull() {
			addCriterion("subcribe_time is not null");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeEqualTo(Date value) {
			addCriterion("subcribe_time =", value, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeNotEqualTo(Date value) {
			addCriterion("subcribe_time <>", value, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeGreaterThan(Date value) {
			addCriterion("subcribe_time >", value, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("subcribe_time >=", value, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeLessThan(Date value) {
			addCriterion("subcribe_time <", value, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeLessThanOrEqualTo(Date value) {
			addCriterion("subcribe_time <=", value, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeIn(List<Date> values) {
			addCriterion("subcribe_time in", values, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeNotIn(List<Date> values) {
			addCriterion("subcribe_time not in", values, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeBetween(Date value1, Date value2) {
			addCriterion("subcribe_time between", value1, value2, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSubcribeTimeNotBetween(Date value1, Date value2) {
			addCriterion("subcribe_time not between", value1, value2, "subcribeTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNull() {
			addCriterion("send_time is null");
			return (Criteria) this;
		}

		public Criteria andSendTimeIsNotNull() {
			addCriterion("send_time is not null");
			return (Criteria) this;
		}

		public Criteria andSendTimeEqualTo(Date value) {
			addCriterion("send_time =", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotEqualTo(Date value) {
			addCriterion("send_time <>", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThan(Date value) {
			addCriterion("send_time >", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("send_time >=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThan(Date value) {
			addCriterion("send_time <", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeLessThanOrEqualTo(Date value) {
			addCriterion("send_time <=", value, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeIn(List<Date> values) {
			addCriterion("send_time in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotIn(List<Date> values) {
			addCriterion("send_time not in", values, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeBetween(Date value1, Date value2) {
			addCriterion("send_time between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andSendTimeNotBetween(Date value1, Date value2) {
			addCriterion("send_time not between", value1, value2, "sendTime");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeIsNull() {
			addCriterion("notice_type is null");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeIsNotNull() {
			addCriterion("notice_type is not null");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeEqualTo(Boolean value) {
			addCriterion("notice_type =", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeNotEqualTo(Boolean value) {
			addCriterion("notice_type <>", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeGreaterThan(Boolean value) {
			addCriterion("notice_type >", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("notice_type >=", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeLessThan(Boolean value) {
			addCriterion("notice_type <", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeLessThanOrEqualTo(Boolean value) {
			addCriterion("notice_type <=", value, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeIn(List<Boolean> values) {
			addCriterion("notice_type in", values, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeNotIn(List<Boolean> values) {
			addCriterion("notice_type not in", values, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeBetween(Boolean value1, Boolean value2) {
			addCriterion("notice_type between", value1, value2, "noticeType");
			return (Criteria) this;
		}

		public Criteria andNoticeTypeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("notice_type not between", value1, value2, "noticeType");
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