package com.xmheart.model;

public class XPWNewsMediaArticleWithBLOBs extends XPWNewsMediaArticle {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_news_media_article.brief
	 * @mbg.generated  Thu Sep 07 16:26:06 CST 2017
	 */
	private String brief;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_news_media_article.content
	 * @mbg.generated  Thu Sep 07 16:26:06 CST 2017
	 */
	private String content;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_news_media_article.brief
	 * @return  the value of xpw_news_media_article.brief
	 * @mbg.generated  Thu Sep 07 16:26:06 CST 2017
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_news_media_article.brief
	 * @param brief  the value for xpw_news_media_article.brief
	 * @mbg.generated  Thu Sep 07 16:26:06 CST 2017
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_news_media_article.content
	 * @return  the value of xpw_news_media_article.content
	 * @mbg.generated  Thu Sep 07 16:26:06 CST 2017
	 */
	public String getContent() {
		return content;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_news_media_article.content
	 * @param content  the value for xpw_news_media_article.content
	 * @mbg.generated  Thu Sep 07 16:26:06 CST 2017
	 */
	public void setContent(String content) {
		this.content = content;
	}
}