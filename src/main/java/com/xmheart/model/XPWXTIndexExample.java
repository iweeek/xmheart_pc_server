package com.xmheart.model;

import java.util.ArrayList;
import java.util.List;

public class XPWXTIndexExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public XPWXTIndexExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
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

		public Criteria andBannerImage1UrlIsNull() {
			addCriterion("banner_image_1_url is null");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlIsNotNull() {
			addCriterion("banner_image_1_url is not null");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlEqualTo(String value) {
			addCriterion("banner_image_1_url =", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlNotEqualTo(String value) {
			addCriterion("banner_image_1_url <>", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlGreaterThan(String value) {
			addCriterion("banner_image_1_url >", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlGreaterThanOrEqualTo(String value) {
			addCriterion("banner_image_1_url >=", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlLessThan(String value) {
			addCriterion("banner_image_1_url <", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlLessThanOrEqualTo(String value) {
			addCriterion("banner_image_1_url <=", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlLike(String value) {
			addCriterion("banner_image_1_url like", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlNotLike(String value) {
			addCriterion("banner_image_1_url not like", value, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlIn(List<String> values) {
			addCriterion("banner_image_1_url in", values, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlNotIn(List<String> values) {
			addCriterion("banner_image_1_url not in", values, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlBetween(String value1, String value2) {
			addCriterion("banner_image_1_url between", value1, value2, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1UrlNotBetween(String value1, String value2) {
			addCriterion("banner_image_1_url not between", value1, value2, "bannerImage1Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlIsNull() {
			addCriterion("banner_image_1_action_url is null");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlIsNotNull() {
			addCriterion("banner_image_1_action_url is not null");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlEqualTo(String value) {
			addCriterion("banner_image_1_action_url =", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlNotEqualTo(String value) {
			addCriterion("banner_image_1_action_url <>", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlGreaterThan(String value) {
			addCriterion("banner_image_1_action_url >", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlGreaterThanOrEqualTo(String value) {
			addCriterion("banner_image_1_action_url >=", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlLessThan(String value) {
			addCriterion("banner_image_1_action_url <", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlLessThanOrEqualTo(String value) {
			addCriterion("banner_image_1_action_url <=", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlLike(String value) {
			addCriterion("banner_image_1_action_url like", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlNotLike(String value) {
			addCriterion("banner_image_1_action_url not like", value, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlIn(List<String> values) {
			addCriterion("banner_image_1_action_url in", values, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlNotIn(List<String> values) {
			addCriterion("banner_image_1_action_url not in", values, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlBetween(String value1, String value2) {
			addCriterion("banner_image_1_action_url between", value1, value2, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage1ActionUrlNotBetween(String value1, String value2) {
			addCriterion("banner_image_1_action_url not between", value1, value2, "bannerImage1ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlIsNull() {
			addCriterion("banner_image_2_url is null");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlIsNotNull() {
			addCriterion("banner_image_2_url is not null");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlEqualTo(String value) {
			addCriterion("banner_image_2_url =", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlNotEqualTo(String value) {
			addCriterion("banner_image_2_url <>", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlGreaterThan(String value) {
			addCriterion("banner_image_2_url >", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlGreaterThanOrEqualTo(String value) {
			addCriterion("banner_image_2_url >=", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlLessThan(String value) {
			addCriterion("banner_image_2_url <", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlLessThanOrEqualTo(String value) {
			addCriterion("banner_image_2_url <=", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlLike(String value) {
			addCriterion("banner_image_2_url like", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlNotLike(String value) {
			addCriterion("banner_image_2_url not like", value, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlIn(List<String> values) {
			addCriterion("banner_image_2_url in", values, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlNotIn(List<String> values) {
			addCriterion("banner_image_2_url not in", values, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlBetween(String value1, String value2) {
			addCriterion("banner_image_2_url between", value1, value2, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2UrlNotBetween(String value1, String value2) {
			addCriterion("banner_image_2_url not between", value1, value2, "bannerImage2Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlIsNull() {
			addCriterion("banner_image_2_action_url is null");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlIsNotNull() {
			addCriterion("banner_image_2_action_url is not null");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlEqualTo(String value) {
			addCriterion("banner_image_2_action_url =", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlNotEqualTo(String value) {
			addCriterion("banner_image_2_action_url <>", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlGreaterThan(String value) {
			addCriterion("banner_image_2_action_url >", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlGreaterThanOrEqualTo(String value) {
			addCriterion("banner_image_2_action_url >=", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlLessThan(String value) {
			addCriterion("banner_image_2_action_url <", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlLessThanOrEqualTo(String value) {
			addCriterion("banner_image_2_action_url <=", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlLike(String value) {
			addCriterion("banner_image_2_action_url like", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlNotLike(String value) {
			addCriterion("banner_image_2_action_url not like", value, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlIn(List<String> values) {
			addCriterion("banner_image_2_action_url in", values, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlNotIn(List<String> values) {
			addCriterion("banner_image_2_action_url not in", values, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlBetween(String value1, String value2) {
			addCriterion("banner_image_2_action_url between", value1, value2, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage2ActionUrlNotBetween(String value1, String value2) {
			addCriterion("banner_image_2_action_url not between", value1, value2, "bannerImage2ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlIsNull() {
			addCriterion("banner_image_3_url is null");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlIsNotNull() {
			addCriterion("banner_image_3_url is not null");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlEqualTo(String value) {
			addCriterion("banner_image_3_url =", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlNotEqualTo(String value) {
			addCriterion("banner_image_3_url <>", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlGreaterThan(String value) {
			addCriterion("banner_image_3_url >", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlGreaterThanOrEqualTo(String value) {
			addCriterion("banner_image_3_url >=", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlLessThan(String value) {
			addCriterion("banner_image_3_url <", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlLessThanOrEqualTo(String value) {
			addCriterion("banner_image_3_url <=", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlLike(String value) {
			addCriterion("banner_image_3_url like", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlNotLike(String value) {
			addCriterion("banner_image_3_url not like", value, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlIn(List<String> values) {
			addCriterion("banner_image_3_url in", values, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlNotIn(List<String> values) {
			addCriterion("banner_image_3_url not in", values, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlBetween(String value1, String value2) {
			addCriterion("banner_image_3_url between", value1, value2, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3UrlNotBetween(String value1, String value2) {
			addCriterion("banner_image_3_url not between", value1, value2, "bannerImage3Url");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlIsNull() {
			addCriterion("banner_image_3_action_url is null");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlIsNotNull() {
			addCriterion("banner_image_3_action_url is not null");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlEqualTo(String value) {
			addCriterion("banner_image_3_action_url =", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlNotEqualTo(String value) {
			addCriterion("banner_image_3_action_url <>", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlGreaterThan(String value) {
			addCriterion("banner_image_3_action_url >", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlGreaterThanOrEqualTo(String value) {
			addCriterion("banner_image_3_action_url >=", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlLessThan(String value) {
			addCriterion("banner_image_3_action_url <", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlLessThanOrEqualTo(String value) {
			addCriterion("banner_image_3_action_url <=", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlLike(String value) {
			addCriterion("banner_image_3_action_url like", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlNotLike(String value) {
			addCriterion("banner_image_3_action_url not like", value, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlIn(List<String> values) {
			addCriterion("banner_image_3_action_url in", values, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlNotIn(List<String> values) {
			addCriterion("banner_image_3_action_url not in", values, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlBetween(String value1, String value2) {
			addCriterion("banner_image_3_action_url between", value1, value2, "bannerImage3ActionUrl");
			return (Criteria) this;
		}

		public Criteria andBannerImage3ActionUrlNotBetween(String value1, String value2) {
			addCriterion("banner_image_3_action_url not between", value1, value2, "bannerImage3ActionUrl");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xpw_xtindex
	 * @mbg.generated  Sat Oct 28 09:54:47 CST 2017
	 */
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table xpw_xtindex
     *
     * @mbg.generated do_not_delete_during_merge Tue Oct 17 10:50:14 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}