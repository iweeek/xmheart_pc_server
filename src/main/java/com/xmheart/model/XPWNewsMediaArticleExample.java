package com.xmheart.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XPWNewsMediaArticleExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public XPWNewsMediaArticleExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
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

		public Criteria andColumnNameIsNull() {
			addCriterion("column_name is null");
			return (Criteria) this;
		}

		public Criteria andColumnNameIsNotNull() {
			addCriterion("column_name is not null");
			return (Criteria) this;
		}

		public Criteria andColumnNameEqualTo(String value) {
			addCriterion("column_name =", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotEqualTo(String value) {
			addCriterion("column_name <>", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameGreaterThan(String value) {
			addCriterion("column_name >", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameGreaterThanOrEqualTo(String value) {
			addCriterion("column_name >=", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameLessThan(String value) {
			addCriterion("column_name <", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameLessThanOrEqualTo(String value) {
			addCriterion("column_name <=", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameLike(String value) {
			addCriterion("column_name like", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotLike(String value) {
			addCriterion("column_name not like", value, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameIn(List<String> values) {
			addCriterion("column_name in", values, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotIn(List<String> values) {
			addCriterion("column_name not in", values, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameBetween(String value1, String value2) {
			addCriterion("column_name between", value1, value2, "columnName");
			return (Criteria) this;
		}

		public Criteria andColumnNameNotBetween(String value1, String value2) {
			addCriterion("column_name not between", value1, value2, "columnName");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andUrlIsNull() {
			addCriterion("url is null");
			return (Criteria) this;
		}

		public Criteria andUrlIsNotNull() {
			addCriterion("url is not null");
			return (Criteria) this;
		}

		public Criteria andUrlEqualTo(String value) {
			addCriterion("url =", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotEqualTo(String value) {
			addCriterion("url <>", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThan(String value) {
			addCriterion("url >", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlGreaterThanOrEqualTo(String value) {
			addCriterion("url >=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThan(String value) {
			addCriterion("url <", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLessThanOrEqualTo(String value) {
			addCriterion("url <=", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlLike(String value) {
			addCriterion("url like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotLike(String value) {
			addCriterion("url not like", value, "url");
			return (Criteria) this;
		}

		public Criteria andUrlIn(List<String> values) {
			addCriterion("url in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotIn(List<String> values) {
			addCriterion("url not in", values, "url");
			return (Criteria) this;
		}

		public Criteria andUrlBetween(String value1, String value2) {
			addCriterion("url between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andUrlNotBetween(String value1, String value2) {
			addCriterion("url not between", value1, value2, "url");
			return (Criteria) this;
		}

		public Criteria andImgUrlIsNull() {
			addCriterion("img_url is null");
			return (Criteria) this;
		}

		public Criteria andImgUrlIsNotNull() {
			addCriterion("img_url is not null");
			return (Criteria) this;
		}

		public Criteria andImgUrlEqualTo(String value) {
			addCriterion("img_url =", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlNotEqualTo(String value) {
			addCriterion("img_url <>", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlGreaterThan(String value) {
			addCriterion("img_url >", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlGreaterThanOrEqualTo(String value) {
			addCriterion("img_url >=", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlLessThan(String value) {
			addCriterion("img_url <", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlLessThanOrEqualTo(String value) {
			addCriterion("img_url <=", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlLike(String value) {
			addCriterion("img_url like", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlNotLike(String value) {
			addCriterion("img_url not like", value, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlIn(List<String> values) {
			addCriterion("img_url in", values, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlNotIn(List<String> values) {
			addCriterion("img_url not in", values, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlBetween(String value1, String value2) {
			addCriterion("img_url between", value1, value2, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andImgUrlNotBetween(String value1, String value2) {
			addCriterion("img_url not between", value1, value2, "imgUrl");
			return (Criteria) this;
		}

		public Criteria andCategoryIsNull() {
			addCriterion("category is null");
			return (Criteria) this;
		}

		public Criteria andCategoryIsNotNull() {
			addCriterion("category is not null");
			return (Criteria) this;
		}

		public Criteria andCategoryEqualTo(String value) {
			addCriterion("category =", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotEqualTo(String value) {
			addCriterion("category <>", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryGreaterThan(String value) {
			addCriterion("category >", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryGreaterThanOrEqualTo(String value) {
			addCriterion("category >=", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryLessThan(String value) {
			addCriterion("category <", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryLessThanOrEqualTo(String value) {
			addCriterion("category <=", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryLike(String value) {
			addCriterion("category like", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotLike(String value) {
			addCriterion("category not like", value, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryIn(List<String> values) {
			addCriterion("category in", values, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotIn(List<String> values) {
			addCriterion("category not in", values, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryBetween(String value1, String value2) {
			addCriterion("category between", value1, value2, "category");
			return (Criteria) this;
		}

		public Criteria andCategoryNotBetween(String value1, String value2) {
			addCriterion("category not between", value1, value2, "category");
			return (Criteria) this;
		}

		public Criteria andFileNameIsNull() {
			addCriterion("file_name is null");
			return (Criteria) this;
		}

		public Criteria andFileNameIsNotNull() {
			addCriterion("file_name is not null");
			return (Criteria) this;
		}

		public Criteria andFileNameEqualTo(String value) {
			addCriterion("file_name =", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotEqualTo(String value) {
			addCriterion("file_name <>", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameGreaterThan(String value) {
			addCriterion("file_name >", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameGreaterThanOrEqualTo(String value) {
			addCriterion("file_name >=", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameLessThan(String value) {
			addCriterion("file_name <", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameLessThanOrEqualTo(String value) {
			addCriterion("file_name <=", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameLike(String value) {
			addCriterion("file_name like", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotLike(String value) {
			addCriterion("file_name not like", value, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameIn(List<String> values) {
			addCriterion("file_name in", values, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotIn(List<String> values) {
			addCriterion("file_name not in", values, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameBetween(String value1, String value2) {
			addCriterion("file_name between", value1, value2, "fileName");
			return (Criteria) this;
		}

		public Criteria andFileNameNotBetween(String value1, String value2) {
			addCriterion("file_name not between", value1, value2, "fileName");
			return (Criteria) this;
		}

		public Criteria andIsPinnedIsNull() {
			addCriterion("is_pinned is null");
			return (Criteria) this;
		}

		public Criteria andIsPinnedIsNotNull() {
			addCriterion("is_pinned is not null");
			return (Criteria) this;
		}

		public Criteria andIsPinnedEqualTo(Boolean value) {
			addCriterion("is_pinned =", value, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedNotEqualTo(Boolean value) {
			addCriterion("is_pinned <>", value, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedGreaterThan(Boolean value) {
			addCriterion("is_pinned >", value, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedGreaterThanOrEqualTo(Boolean value) {
			addCriterion("is_pinned >=", value, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedLessThan(Boolean value) {
			addCriterion("is_pinned <", value, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedLessThanOrEqualTo(Boolean value) {
			addCriterion("is_pinned <=", value, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedIn(List<Boolean> values) {
			addCriterion("is_pinned in", values, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedNotIn(List<Boolean> values) {
			addCriterion("is_pinned not in", values, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedBetween(Boolean value1, Boolean value2) {
			addCriterion("is_pinned between", value1, value2, "isPinned");
			return (Criteria) this;
		}

		public Criteria andIsPinnedNotBetween(Boolean value1, Boolean value2) {
			addCriterion("is_pinned not between", value1, value2, "isPinned");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIsNull() {
			addCriterion("publish_time is null");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIsNotNull() {
			addCriterion("publish_time is not null");
			return (Criteria) this;
		}

		public Criteria andPublishTimeEqualTo(Date value) {
			addCriterion("publish_time =", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotEqualTo(Date value) {
			addCriterion("publish_time <>", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeGreaterThan(Date value) {
			addCriterion("publish_time >", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("publish_time >=", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLessThan(Date value) {
			addCriterion("publish_time <", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
			addCriterion("publish_time <=", value, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeIn(List<Date> values) {
			addCriterion("publish_time in", values, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotIn(List<Date> values) {
			addCriterion("publish_time not in", values, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeBetween(Date value1, Date value2) {
			addCriterion("publish_time between", value1, value2, "publishTime");
			return (Criteria) this;
		}

		public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
			addCriterion("publish_time not between", value1, value2, "publishTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNull() {
			addCriterion("created_time is null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNotNull() {
			addCriterion("created_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeEqualTo(Date value) {
			addCriterion("created_time =", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotEqualTo(Date value) {
			addCriterion("created_time <>", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThan(Date value) {
			addCriterion("created_time >", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("created_time >=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThan(Date value) {
			addCriterion("created_time <", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("created_time <=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIn(List<Date> values) {
			addCriterion("created_time in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotIn(List<Date> values) {
			addCriterion("created_time not in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeBetween(Date value1, Date value2) {
			addCriterion("created_time between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("created_time not between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeIsNull() {
			addCriterion("updated_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeIsNotNull() {
			addCriterion("updated_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeEqualTo(Date value) {
			addCriterion("updated_time =", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeNotEqualTo(Date value) {
			addCriterion("updated_time <>", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeGreaterThan(Date value) {
			addCriterion("updated_time >", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("updated_time >=", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeLessThan(Date value) {
			addCriterion("updated_time <", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("updated_time <=", value, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeIn(List<Date> values) {
			addCriterion("updated_time in", values, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeNotIn(List<Date> values) {
			addCriterion("updated_time not in", values, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
			addCriterion("updated_time between", value1, value2, "updatedTime");
			return (Criteria) this;
		}

		public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("updated_time not between", value1, value2, "updatedTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xpw_news_media_article
	 * @mbg.generated  Tue Sep 05 13:17:55 CST 2017
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
     * This class corresponds to the database table xpw_news_media_article
     *
     * @mbg.generated do_not_delete_during_merge Mon Sep 04 22:57:07 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}