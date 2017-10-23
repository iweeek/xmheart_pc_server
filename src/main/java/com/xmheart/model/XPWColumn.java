package com.xmheart.model;

import java.util.Date;

public class XPWColumn {

    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_column.id
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    private Long id;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_column.column_name
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    private String columnName;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_column.url
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    private String url;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_column.parent_column_id
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    private Long parentColumnId;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_column.position
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    private Boolean position;
    /**
     * This field was generated by MyBatis Generator. This field corresponds to the database column xpw_column.publish_time
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    private Date publishTime;

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_column.id
     * @return  the value of xpw_column.id
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_column.id
     * @param id  the value for xpw_column.id
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_column.column_name
     * @return  the value of xpw_column.column_name
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_column.column_name
     * @param columnName  the value for xpw_column.column_name
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_column.url
     * @return  the value of xpw_column.url
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_column.url
     * @param url  the value for xpw_column.url
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_column.parent_column_id
     * @return  the value of xpw_column.parent_column_id
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public Long getParentColumnId() {
        return parentColumnId;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_column.parent_column_id
     * @param parentColumnId  the value for xpw_column.parent_column_id
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public void setParentColumnId(Long parentColumnId) {
        this.parentColumnId = parentColumnId;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_column.position
     * @return  the value of xpw_column.position
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public Boolean getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_column.position
     * @param position  the value for xpw_column.position
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public void setPosition(Boolean position) {
        this.position = position;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the value of the database column xpw_column.publish_time
     * @return  the value of xpw_column.publish_time
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the value of the database column xpw_column.publish_time
     * @param publishTime  the value for xpw_column.publish_time
     * @mbg.generated  Mon Oct 23 16:57:26 CST 2017
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
}